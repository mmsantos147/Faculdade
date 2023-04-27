package hostelapp;

import hostelapp.model.*;

public class main {
    public static void main(String[] args) {
        Guest matheus = new Guest();

        if (matheus.setName("Matheus")) {
            matheus.setLastName("Santos");
            System.out.println("Hóspede cadastrado: ");
            System.out.println("Name...:" + matheus.getName());
            System.out.println("Last name...:" + matheus.getLastName());
        } else {
            System.out.println("Nome do hospede invalido");
        }
    }
}
