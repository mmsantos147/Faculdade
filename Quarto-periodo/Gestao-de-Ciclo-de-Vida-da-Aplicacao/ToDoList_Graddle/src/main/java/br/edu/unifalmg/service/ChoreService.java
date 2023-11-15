package br.edu.unifalmg.service;

import br.edu.unifalmg.domain.Chore;
import br.edu.unifalmg.enumerator.ChoreFilter;
import br.edu.unifalmg.exception.*;
import br.edu.unifalmg.repository.ChoreRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChoreService {

    private List<Chore> chores;

    private ObjectMapper mapper;

    private ChoreRepository repository;

    public ChoreService(ChoreRepository repository) {
        chores = new ArrayList<>();
        mapper = new ObjectMapper().findAndRegisterModules();
        this.repository = repository;
    }

    public ChoreService() {
        chores = new ArrayList<>();
    }

    /**
     * Method to add a new chore
     *
     * @param description The description of the chore
     * @param deadline The deadline to fulfill the chore
     * @return Chore The new (and uncompleted) chore
     * @throws InvalidDescriptionException When the description is null or empty
     * @throws InvalidDeadlineException When the deadline is null or empty
     * @throws DuplicatedChoreException When the given chore already exists
     */
    public Chore addChore(String description, LocalDate deadline) {
        if (Objects.isNull(description) || description.isEmpty()) {
            throw new InvalidDescriptionException("The description cannot be null or empty");
        }
        if (Objects.isNull(deadline) || deadline.isBefore(LocalDate.now())) {
            throw new InvalidDeadlineException("The deadline cannot be null or before the current date");
        }
        for (Chore chore : chores) {
            if (chore.getDescription().equals(description)
                    && chore.getDeadline().isEqual(deadline)) {
                throw new DuplicatedChoreException("The given chore already exists.");
            }
        }

//         Using anyMatch solution
//
//        boolean doesTheChoreExist = chores.stream().anyMatch(chore -> chore.getDescription().equals(description) && chore.getDeadline().isEqual(deadline));
//        if (doesTheChoreExist) {
//            throw new DuplicatedChoreException("The given chore already exists.");
//        }

        // Using Constructor with all arguments
        Chore chore = new Chore(description, Boolean.FALSE, deadline);


//         Using Lombok's builder
//
//         Chore chore = Chore.builder()
//                .description(description)
//                .deadline(deadline)
//                .isCompleted(false)
//                .build();

//         Using Getter and Setters
//
//         Chore chore = new Chore();
//         chore.setDescription(description);
//         chore.setDeadline(deadline);
//         chore.setIsCompleted(Boolean.FALSE);

        repository.save(chore);
        chores.add(chore);
        return chore;
    }

    /**
     * Get the added chores.
     *
     * @return List<Chore> The chores added until now.
     */
    public List<Chore> getChores() {
        return this.chores;
    }

    public Chore getChore(String description, LocalDate deadline) {

        if (description == null || description.isEmpty() || description.isBlank()) {
            throw new InvalidDescriptionException("The description cannot be null or empty");
        }

        if (deadline == null) {
            throw new InvalidDeadlineException("The deadline cannot be null or before the current date");
        }

        for (Chore chore: chores) {
            if(chore.getDescription().equals(description) && chore.getDeadline().equals(deadline)) {
                return chore;
            }
        }

        throw new ChoreNotFoundException("The chore does not exists.");
    }
    /**
     * Method to delete a given chore.
     *
     * @param description The description of the chore
     * @param deadline The deadline of the chore
     */
    public void deleteChore(String description, LocalDate deadline) {
        if (isChoreListEmpty.test(this.chores)) {
            throw new EmptyChoreListException("Unable to remove a chore from an empty list");
        }
        boolean isChoreExist = this.chores.stream().anyMatch((chore -> chore.getDescription().equals(description)
            && chore.getDeadline().isEqual(deadline)));
        if (!isChoreExist) {
            throw new ChoreNotFoundException("The given chore does not exist.");
        }

        this.chores = this.chores.stream().filter(chore -> !chore.getDescription().equals(description)
                && !chore.getDeadline().isEqual(deadline)).collect(Collectors.toList());
    }

    /**
     *
     * Method to toggle a chore from completed to uncompleted and vice-versa.
     *
     * @param description The chore's description
     * @param deadline The deadline to complete the chore
     * @throws ChoreNotFoundException When the chore is not found on the list
     */
    public void toggleChore(String description, LocalDate deadline) {
        boolean isChoreExist = this.chores.stream().anyMatch((chore) -> chore.getDescription().equals(description) && chore.getDeadline().isEqual(deadline));
        if (!isChoreExist) {
            throw new ChoreNotFoundException("Chore not found. Impossible to toggle!");
        }

        this.chores = this.chores.stream().map(chore -> {
            if (!chore.getDescription().equals(description) && !chore.getDeadline().isEqual(deadline)) {
                return chore;
            }
            if (chore.getDeadline().isBefore(LocalDate.now())
                    && chore.getIsCompleted()) {
                throw new ToggleChoreWithInvalidDeadlineException("Unable to toggle a completed chore with a past deadline");
            }
            chore.setIsCompleted(!chore.getIsCompleted());
            return chore;
        }).collect(Collectors.toList());
    }

    /**
     * Filter the chores by its status
     *
     * @param filter COMPLETED, UNCOMPLETED or ALL
     * @return A list with the filtered chores
     */
    public List<Chore> filterChores(ChoreFilter filter) {
        switch (filter) {
            case COMPLETED:
                return this.chores.stream().filter(Chore::getIsCompleted).collect(Collectors.toList());
            case UNCOMPLETED:
                return this.chores.stream().filter(chore -> !chore.getIsCompleted()).collect(Collectors.toList());
            case ALL:
            default:
                return this.chores;
        }
    }

    public String printChore() {
        StringBuilder output = new StringBuilder();
        if(chores == null || chores.isEmpty()) return "Chore List is Empty";

        for (Chore chore : chores) {
            output.append("Descrição: ").append(chore.getDescription()).append(" Deadline: ").append(chore.getDeadline())
                    .append(" Status: ").append(chore.getIsCompleted() ? "Completa" : "Incompleta").append("\n");
        }
        return output.toString();
    }

    public boolean editChore(String description, LocalDate deadline, String newDescription) {
        boolean isChoreExist = this.chores.stream().anyMatch((chore) -> chore.getDescription().equals(description) &&
                chore.getDeadline().equals(deadline));

        if (!isChoreExist) {
            throw new ChoreNotFoundException("The given chore does not exist. Impossible to toggle");
        }

        for (Chore chore : chores) {
            if (chore.getDescription().equals(description) && chore.getDeadline().equals(deadline) ) {
                chore.setDescription(newDescription);
                return true;
            }
        }
        return false;
    }
    public boolean editChore(String description, LocalDate deadline, String newDescription, LocalDate newDeadline) {
        boolean isChoreExist = this.chores.stream().anyMatch((chore) -> chore.getDescription().equals(description) &&
                chore.getDeadline().equals(deadline));

        if (!isChoreExist) {
            throw new ChoreNotFoundException("The given chore does not exist. Impossible to toggle");
        }

        for (Chore chore : chores) {
            if (chore.getDescription().equals(description) && chore.getDeadline().equals(deadline) ) {
                chore.setDescription(newDescription);
                chore.setDeadline(newDeadline);
                return true;
            }
        }
        return false;
    }

    public void readData() throws FileNotFoundException {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ISO_DATE_TIME))
                .create();

        JsonReader reader = new JsonReader(new FileReader("src/main/resources/chores.json"));
        Type choreListType = new TypeToken<List<Chore>>(){}.getType();

        List<Chore> newChores = gson.fromJson(reader, choreListType);

        this.chores.addAll(newChores);
    }
    /**
     * Load the chores from the repository.
     * The repository can return NULL if no chores are found.
     */
    public void loadChores() {
        this.chores = repository.load();
    }

    /**
     * Save the chores into the file
     *
     * @return TRUE, if the saved was completed and <br/>
     *         FALSE, when the save fails
     */
    public Boolean saveChores() {
        return repository.saveAll(this.chores);
    }

    private final Predicate<List<Chore>> isChoreListEmpty = choreList -> choreList.isEmpty();

}
