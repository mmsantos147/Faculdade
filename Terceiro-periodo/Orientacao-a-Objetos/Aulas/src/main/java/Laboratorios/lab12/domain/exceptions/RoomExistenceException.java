package Laboratorios.lab12.domain.exceptions;

public class RoomExistenceException extends Exception {
    private int number;

    public RoomExistenceException(String message, int number) {
        super(message);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
