package org.example.service;

import org.example.domain.Chore;
import org.example.exception.DuplicatedChoreException;
import org.example.exception.InvalidDeadLineException;
import org.example.exception.InvalidDescriptionException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
