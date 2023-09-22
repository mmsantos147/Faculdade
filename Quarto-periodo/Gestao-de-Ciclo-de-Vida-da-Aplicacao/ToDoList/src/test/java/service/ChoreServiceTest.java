package service;


import org.example.exception.DuplicatedChoreException;
import org.example.exception.InvalidDeadLineException;
import org.example.exception.InvalidDescriptionException;
import org.example.service.ChoreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChoreServiceTest {

    @Test
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

}
