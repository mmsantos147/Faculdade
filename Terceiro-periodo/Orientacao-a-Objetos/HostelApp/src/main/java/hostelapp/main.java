package hostelapp;

import hostelapp.model.Guest;

public class main {
    public static void main(String[] args) {
        Guest matheus = new Guest("Matheus", "Santos");
        Guest gutts = new Guest("Gutts");
        Guest thiago = new Guest();
        thiago.setName("Thiago");
        thiago.setLastName("Santos");
        System.out.println("Name...: " + matheus.getName());
        System.out.println("Last name...: " + matheus.getLastName());
        System.out.println("Name...: " + thiago.getName());
        System.out.println("Last name...: " + thiago.getLastName());
        System.out.println("Name...: " + gutts.getName());
        System.out.println("Last name...: " + gutts.getLastName());
//        if (matheus.setName("Matheus")) {
//            matheus.setLastName("Santos");
//            System.out.println("Hóspede cadastrado: ");
//            System.out.println("Name...: " + matheus.getName());
//            System.out.println("Last name...: " + matheus.getLastName());
//        } else {
//            System.out.println("Nome do hospede invalido");
//        }
    }
}
