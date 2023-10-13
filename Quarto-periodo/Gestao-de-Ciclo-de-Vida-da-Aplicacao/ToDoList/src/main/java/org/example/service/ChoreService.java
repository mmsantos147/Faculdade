package org.example.service;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.Chore;
import org.example.enumerator.ChoreFilter;
import org.example.exception.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@Setter
public class ChoreService {

    private List<Chore> choreList;

    public ChoreService(){
        choreList = new ArrayList<>();
    }

    public Chore addChore(String description, LocalDate deadline) {
        if (description == null || description.isEmpty()) {
            throw new InvalidDescriptionException("The description cannot be null or empty");
        }

        if (deadline == null || deadline.isBefore(LocalDate.now())) {
            throw new InvalidDeadLineException("The deadline cannot be null or before the current date");
        }

        boolean choreExists = choreList.stream().anyMatch(chore -> chore.getDescription().equals(description) && chore.getDeadline().isEqual(deadline));
        if (choreExists) {
            throw new DuplicatedChoreException("The given chore already exists");
        }
//        for (Chore chore : choreList) {
//            if (chore.getDescription().equals(description) && chore.getDeadline().isEqual(deadline)) {
//                throw new DuplicatedChoreException("The given chore already exists");
//            }
//        }

//        Chore chore = new Chore();
//        chore.setDescription(description);
//        chore.setDeadline(deadline);
//        chore.setIsCompleted(Boolean.FALSE);
        Chore chore = Chore.builder()
                .description(description)
                .deadline(deadline)
                .isCompleted(Boolean.FALSE)
                .build();
        choreList.add(chore);
        return chore;
    }

    public List<Chore> getChores() {
        return this.choreList;
    }

    public void deleteChore(String description, LocalDate deadline) {
        if (this.choreList.isEmpty()) {
            throw new EmptyChoreException("Unable to remove a chore from an empty list");
        }
        boolean isChoreExist = this.choreList.stream().anyMatch((chore -> chore.getDescription().equals(description)
                && chore.getDeadline().isEqual(deadline)));
        if(!isChoreExist) {
            throw new ChoreDoesntExistException("The given chore does not exist");
        }

        this.choreList = this.choreList.stream().filter(chore -> !chore.getDescription().equals(description)
                && !chore.getDeadline().isEqual(deadline)).collect(Collectors.toList());
    }

    public void toggleChore(String description, LocalDate deadline) {
        boolean isChoreExist = this.choreList.stream().anyMatch((chore) -> chore.getDescription().equals(description) &&
                chore.getDeadline().equals(deadline));

        if (!isChoreExist) {
            throw new ChoreDoesntExistException("The given chore does not exist. Impossible to toggle");
        }

        this.choreList = this.choreList.stream().map(chore -> {
            if (!chore.getDescription().equals(description) && !chore.getDeadline().equals(deadline)) {
                return chore;
            }
            if (chore.getDeadline().isBefore(LocalDate.now()) && chore.getIsCompleted()){
                throw new ToggleChoreWithInvalidDeadlineException("Unable to toggle a completed chore with a past deadline");
            }
            chore.setIsCompleted(!chore.getIsCompleted());
            return chore;
        }).collect(Collectors.toList());
    }

    public List<Chore> filterChore(ChoreFilter filter) {
        switch (filter) {
            case COMPLETED:
                return this.choreList.stream().filter(Chore::getIsCompleted).collect(Collectors.toList());

            case UNCOMPLETED:
                return this.choreList.stream().filter(chore -> !chore.getIsCompleted()).collect(Collectors.toList());

            default:
                return this.choreList;
        }
    }

    private final Predicate<List<Chore>> isChoreListEmpty = List::isEmpty;

}
