package hostelapp.version6.exception;

public class ExceptionRoomNotFound extends Exception{
    private int number;

    public ExceptionRoomNotFound(String message, int number) {
        super(message);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
