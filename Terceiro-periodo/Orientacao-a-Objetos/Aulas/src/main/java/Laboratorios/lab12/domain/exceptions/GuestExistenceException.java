package Laboratorios.lab12.domain.exceptions;

public class GuestExistenceException extends Exception {
    private String cpf;

    public GuestExistenceException(String message, String cpf) {
        super(message);
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }
}
