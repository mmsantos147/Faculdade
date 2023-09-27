package service;


import org.example.domain.Chore;
import org.example.exception.*;
import org.example.service.ChoreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ChoreServiceTest {

    @Test
    @DisplayName("#addChore > When description invalid > Throw exception")
    void addChoreWhenTheDescriptionIsInvalidThrowAnException() {
        ChoreService service = new ChoreService();
        assertAll(
                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, null)
                ),

                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", null)
                ),

                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, LocalDate.now().plusDays(1))
                ),

                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", LocalDate.now().plusDays(1))
                ),

                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore(null, LocalDate.now().minusDays(1))
                ),

                () -> assertThrows(InvalidDescriptionException.class,
                        () -> service.addChore("", LocalDate.now().minusDays(1))
                )
        );
    }

    @Test
    @DisplayName("#addChore > When deadline invalid > Throw exception")
    void addChoreWhenDeadlineInvalidThrowException() {
        ChoreService service = new ChoreService();
        assertAll(
                () -> assertThrows(InvalidDeadLineException.class,
                    () -> service.addChore("Description", null)
                ),

                ()-> assertThrows(InvalidDeadLineException.class,
                        () -> service.addChore("Description", LocalDate.now().minusDays(1))
                )
        );

    }

    @Test
    @DisplayName("#addChore > When adding a chore > When the chore already exists > Throw  an exception")
    void addDuplicatedChore(){
        ChoreService service = new ChoreService();
        service.addChore("Description", LocalDate.now());
        assertThrows(DuplicatedChoreException.class,
                () -> service.addChore("Description", LocalDate.now())
        );
    }

    @Test
    @DisplayName("#addChore > When the chore's list is empty > When adding a new chore > Add the chore")
    void addChoreWhenTheChoresListIsEmptyWhenAddingANewChoreAddTheChore() {
        ChoreService service = new ChoreService();
        Chore response = service.addChore("Description", LocalDate.now());
        assertAll(
                () -> assertEquals("Description", response.getDescription()),
                () -> assertEquals(LocalDate.now(), response.getDeadline()),
                () -> assertEquals(Boolean.FALSE, response.getIsCompleted())
        );
    }

    @Test
    @DisplayName("#addChore > When the chore's list has at least one element > When adding a new chore > Add the chore")
    void addChoreWhenTheChoresListHasAtLeastOneElementWhenAddingANewChoreAddTheChore() {
        ChoreService service = new ChoreService();
        service.addChore("Chore #01", LocalDate.now());
        service.addChore("Chore #02", LocalDate.now().plusDays(2));
        assertAll(
                () -> assertEquals(2, service.getChores().size()),
                () -> assertEquals("Chore #01", service.getChores().get(0).getDescription()),
                () -> assertEquals(LocalDate.now(), service.getChores().get(0).getDeadline()),
                () -> assertEquals(Boolean.FALSE, service.getChores().get(0).getIsCompleted()),
                () -> assertEquals("Chore #02", service.getChores().get(1).getDescription()),
                () -> assertEquals(LocalDate.now().plusDays(2), service.getChores().get(1).getDeadline()),
                () -> assertEquals(Boolean.FALSE, service.getChores().get(1).getIsCompleted())
        );
    }

    @Test
    void deleteChoreWhenTheChoresListIsEmpty() {
        ChoreService service = new ChoreService();
        assertThrows(EmptyChoreException.class,
                ()-> service.deleteChore("Description", LocalDate.now().plusDays(1))
        );
    }

    @Test
    void deleteChoreWhenChoreDoesntExist() {
        ChoreService service = new ChoreService();
        service.addChore("Description", LocalDate.now());
        assertThrows(ChoreDoesntExistException.class,
                ()-> service.deleteChore("Description", LocalDate.now().plusDays(1))
        );
    }

    @Test
    void deleteChoreWhenChoreExistNotEmpty() {
        ChoreService service = new ChoreService();
        service.addChore("Chore 1", LocalDate.now().plusDays(1));
        assertEquals(1, service.getChores().size());

        service.deleteChore("Chore 1", LocalDate.now().plusDays(1));
        assertEquals(0, service.getChores().size());
    }
}