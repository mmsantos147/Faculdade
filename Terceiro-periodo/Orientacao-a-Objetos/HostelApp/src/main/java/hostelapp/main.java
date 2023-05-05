package hostelapp;

import hostelapp.model.*;

public class main {
    public static void main(String[] args) {
        Guest matheus = new Guest("Matheus", "Santos");
        Address address = new Address();

        address.setCity("Pirassununga");
        address.setAddress("Rua Adolfo Engel");
        address.setState("São Paulo");
        address.setEmail("matheus.santos@sla.com");
        address.setCountry("Brasil");
        address.setZipCode("00000-000");

        matheus.setAddress(address);
        Address matheusAddress = matheus.getAddress();
        String email = matheusAddress.getEmail();

        System.out.println("Name...: " + matheus.getName());
        System.out.println("Last name...: " + matheus.getLastName());
        System.out.println("E-mail...: " + email);
        System.out.println("Address...: " + matheus.getAddress().getAddress());
        System.out.println("City...: " + matheus.getAddress().getCity());
        System.out.println("State...: " + matheus.getAddress().getState());
        System.out.println("Country...: " + matheus.getAddress().getCountry());
        System.out.println("Zip-code...: " + matheus.getAddress().getZipCode());
//        Guest gutts = new Guest("Gutts");
//        Guest thiago = new Guest();
//        thiago.setName("Thiago");
//        thiago.setLastName("Santos");
//        System.out.println("Name...: " + matheus.getName());
//        System.out.println("Last name...: " + matheus.getLastName());
//        System.out.println("Name...: " + thiago.getName());
//        System.out.println("Last name...: " + thiago.getLastName());
//        System.out.println("Name...: " + gutts.getName());
//        System.out.println("Last name...: " + gutts.getLastName());
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
