package service;


import org.example.domain.Chore;
import org.example.enumerator.ChoreFilter;
import org.example.exception.*;
import org.example.service.ChoreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;

import java.time.LocalDate;
import java.util.List;

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
    @DisplayName("#deleteChore > When the list is empty > Throw an exception")
    void deleteChoreWhenTheChoresListIsEmpty() {
        ChoreService service = new ChoreService();
        assertThrows(EmptyChoreException.class,
                ()-> service.deleteChore("Description", LocalDate.now().plusDays(1))
        );
    }

    @Test
    @DisplayName("#deleteChore > When the list is not empty > When the chore does not exist > Throw an exception")
    void deleteChoreWhenChoreDoesntExist() {
        ChoreService service = new ChoreService();
        service.addChore("Description", LocalDate.now());
        assertThrows(ChoreDoesntExistException.class,
                ()-> service.deleteChore("Description", LocalDate.now().plusDays(1))
        );
    }

    @Test
    @DisplayName("#deleteChore > When the list is not empty > When the chore exists > Delete the chore")
    void deleteChoreWhenChoreExistNotEmpty() {
        ChoreService service = new ChoreService();
        service.addChore("Chore #01", LocalDate.now().plusDays(1));
        assertEquals(1, service.getChores().size());

        service.deleteChore("Chore #01", LocalDate.now().plusDays(1));
        assertEquals(0, service.getChores().size());
    }

    @Test
    @DisplayName("#toggleChore > When the deadline is valid > Toggle the chore")
    void toggleChoreWhenValidDeadline() {
        ChoreService service = new ChoreService();
        service.addChore("Chore #01", LocalDate.now());
        assertFalse(service.getChores().get(0).getIsCompleted());

        assertDoesNotThrow(
                ()->service.toggleChore("Chore #01", LocalDate.now())
        );

        assertTrue(service.getChores().get(0).getIsCompleted());
    }

    @Test
    @DisplayName("#toggleChore > When the deadline is valid > When toggle the chore twice > Toggle chore")
    void toggleChoreWhenTheDeadlineIsValidWhenToggleTheChoreTwiceToggleTheChore() {
        ChoreService service = new ChoreService();
        service.addChore("Chore #01", LocalDate.now());
        assertFalse(service.getChores().get(0).getIsCompleted());

        assertDoesNotThrow(() -> service.toggleChore("Chore #01", LocalDate.now()));

        assertTrue(service.getChores().get(0).getIsCompleted());

        assertDoesNotThrow(() -> service.toggleChore("Chore #01", LocalDate.now()));

        assertFalse(service.getChores().get(0).getIsCompleted());
    }

    @Test
    @DisplayName("#toggleChore > When the chore does not exist > Throw an exception")
    void toggleChoreWhenChoreDoesNotExist() {
        ChoreService service = new ChoreService();
        assertThrows(ChoreDoesntExistException.class,
                ()-> service.deleteChore("Chore #01", LocalDate.now().plusDays(1))
        );
    }

    @Test
    @DisplayName("#toggleChore > When the deadline is invalid > When the status is uncompleted > Toggle the chore")
    void toggleChoreWhenInvalidDeadline() {
        ChoreService service = new ChoreService();
        service.addChore("Chore #01", LocalDate.now().minusDays(1));
        assertFalse(service.getChores().get(0).getIsCompleted());

        assertDoesNotThrow(
                ()-> service.toggleChore("Chore #01", LocalDate.now().minusDays(1))
        );

        assertTrue(service.getChores().get(0).getIsCompleted());

        assertDoesNotThrow(
                ()-> service.toggleChore("Chore #01", LocalDate.now().minusDays(1))
        );

        assertFalse(service.getChores().get(0).getIsCompleted());
    }

    @Test
    @DisplayName("#toggleChore > When the deadline is invalid > When status is completed > Throw an exception")
    void toggleChoreWhenInvalidDeadlineWhenStatusCompleted() {
        ChoreService service = new ChoreService();
        service.getChores().add(new Chore("Chore #01", Boolean.TRUE, LocalDate.now().minusDays(1)));
        assertThrows(ToggleChoreWithInvalidDeadlineException.class,
                ()->service.toggleChore("Chore #01", LocalDate.now().minusDays(1))
        );
    }

    @Test
    @DisplayName("#filterChores > When the filter is COMPLETED > When the list is empty > Return an empty list")
    void filterWhenStatusCompletedListIsEmpty() {
        ChoreService service = new ChoreService();
        List<Chore> response = service.filterChore(ChoreFilter.COMPLETED);
        assertTrue(response.isEmpty());
    }

    @Test
    @DisplayName("#filterChores > When the filter is COMPLETED > When the list is not empty > Return the filtered chores")
    void filterWhenStatusCompletedListIsNotEmpty() {
        ChoreService service = new ChoreService();
        service.getChores().add(new Chore("Chore #01",Boolean.FALSE, LocalDate.now()));
        service.getChores().add(new Chore("Chore #02",Boolean.TRUE, LocalDate.now()));
        List<Chore> response = service.filterChore(ChoreFilter.COMPLETED);
        assertAll(
                () -> assertEquals(1, response.size()),
                () -> assertEquals("Chore #02", response.get(0).getDescription()),
                () -> assertEquals(Boolean.TRUE, response.get(0).getIsCompleted())
        );
    }

    @Test
    @DisplayName("#filterChores > When the filter is UNCOMPLETED > When the list is empty > Return an empty list")
    void filterWhenStatusUncompletedListIsEmpty() {
        ChoreService service = new ChoreService();
        List<Chore> response = service.filterChore(ChoreFilter.UNCOMPLETED);
        assertTrue(response.isEmpty());
    }

    @Test
    @DisplayName("#filterChores > When the filter is UNCOMPLETED > When the list is not empty > Return the filtered chores")
    void filterWhenStatusUncompletedListIsNotEmpty() {
        ChoreService service = new ChoreService();
        service.getChores().add(new Chore("Chore #01",Boolean.FALSE, LocalDate.now()));
        service.getChores().add(new Chore("Chore #02",Boolean.TRUE, LocalDate.now()));
        List<Chore> response = service.filterChore(ChoreFilter.UNCOMPLETED);
        assertAll(
                () -> assertEquals(1, response.size()),
                () -> assertEquals("Chore #01", response.get(0).getDescription()),
                () -> assertEquals(Boolean.FALSE, response.get(0).getIsCompleted())
        );
    }

    @Test
    @DisplayName("#filterChores > When the filter is ALL > When the list is empty > Return all chores")
    void filterAllListIsEmpty() {
        ChoreService service = new ChoreService();
        List<Chore> response = service.filterChore(ChoreFilter.ALL);
        //assertEquals(0,response.size());
        assertTrue(response.isEmpty());
    }

    @Test
    @DisplayName("#filterChores > When the filter is ALL > When the list is not empty > Return all chores")
    void filterAllListIsNotEmpty() {
        ChoreService service = new ChoreService();
        service.getChores().add(new Chore("Chore #01",Boolean.FALSE, LocalDate.now()));
        service.getChores().add(new Chore("Chore #02",Boolean.TRUE, LocalDate.now()));
        List<Chore> response = service.filterChore(ChoreFilter.ALL);
        assertAll(
                () -> assertEquals(2, response.size()),
                () -> assertEquals("Chore #01", response.get(0).getDescription()),
                () -> assertEquals(Boolean.FALSE, response.get(0).getIsCompleted()),
                () -> assertEquals("Chore #02", response.get(1).getDescription()),
                () -> assertEquals(Boolean.TRUE, response.get(1).getIsCompleted())
        );
    }

    @Test
    @DisplayName("#editChore > When the Chore does not exist > throw exception")
    void editChoreWhenChoreDoesNotExist() {
        ChoreService service = new ChoreService();
        assertAll(
                ()->assertThrows(ChoreDoesntExistException.class,
                        ()-> service.editChore("Chore 1", LocalDate.now(), "Chore 2")),
                ()->assertThrows(ChoreDoesntExistException.class,
                        ()->service.editChore("Chore 1", LocalDate.now(), LocalDate.now().plusDays(1))),
                ()->assertThrows(ChoreDoesntExistException.class,
                        ()->service.editChore("Chore 1", LocalDate.now(), "Chore 2", LocalDate.now().plusDays(1)))
        );
    }

    @Test
    @DisplayName("#editChore > Editing only the deadline > edit deadline")
    void editChoreEditingOnlyDeadline() {
        ChoreService service = new ChoreService();
        service.getChores().add( new Chore("Chore 1", Boolean.FALSE, LocalDate.now()));
        assertEquals(true, service.editChore("Chore 1", LocalDate.now(), LocalDate.now().plusDays(1)));
    }

    @Test
    @DisplayName("#editChore > Editing only the description > edit description")
    void editChoreEditingOnlyDescription() {
        ChoreService service = new ChoreService();
        service.getChores().add( new Chore("Chore 1", Boolean.FALSE, LocalDate.now()));
        assertEquals(true, service.editChore("Chore 1", LocalDate.now(), "Chore 2"));
    }

    @Test
    @DisplayName("#editChore > Editing the deadline and description > edit deadline and description")
    void editChoreEditingDescriptionAndDeadline() {
        ChoreService service = new ChoreService();
        service.getChores().add( new Chore("Chore 1", Boolean.FALSE, LocalDate.now()));
        assertEquals(true, service.editChore("Chore 1", LocalDate.now(), "Chore 2", LocalDate.now().plusDays(1)));
    }

    @Test
    @DisplayName("#printChores > When the list is not empty > Print the chores")
    void printChoresWhenListEmpty(){
        ChoreService service = new ChoreService();
        assertEquals("Chore List is Empty", service.printChore());
    }
    @Test
    @DisplayName("#printChores > When the list is not empty > Print the chores")
    void printChoresWhenListIsNotEmpty() {
        ChoreService service = new ChoreService();
        service.getChores().add(new Chore("Chore 1", false, LocalDate.now().plusDays(1)));
        service.getChores().add(new Chore("Chore 2", true, LocalDate.now().plusDays(2)));

        String expectedOutput = "Descrição: Chore 1 Deadline: " + LocalDate.now().plusDays(1) + " Status: Incompleta" + "\n" +
                "Descrição: Chore 2 Deadline: " + LocalDate.now().plusDays(2) + " Status: Completa" + "\n";

        assertEquals(expectedOutput, service.printChore());
    }
}

