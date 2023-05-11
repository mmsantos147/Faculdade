package hostelapp.version2;

import hostelapp.version2.model.*;

public class main {
    public static void main(String[] args) {
        Guest matheus = new Guest("Matheus", "Santos");
        Address address = new Address();
        Date birthday = new Date();

        address.setCity("Pirassununga");
        address.setAddress("Rua Adolfo Engel");
        address.setState("São Paulo");
        address.setEmail("matheus.santos@sla.com");
        address.setCountry("Brasil");
        address.setZipCode("00000-000");

        birthday.setDay(14);
        birthday.setMonth(7);
        birthday.setYear(2003);
        matheus.setDate(birthday);
        String formattedBirthday = matheus.getDate().getDay() + "/" +
                matheus.getDate().getMonth() + "/" +
                matheus.getDate().getYear();
        matheus.setAddress(address);
        Address matheusAddress = matheus.getAddress();
        String email = matheusAddress.getEmail();

        System.out.println("Name...: " + matheus.getName());
        System.out.println("Last name...: " + matheus.getLastName());
        System.out.println("E-mail...: " + email);
        System.out.println("Birthday...: "+ matheus.getDate());
        System.out.println("Address...: " + matheus.getAddress().getAddress());
        System.out.println("City...: " + matheus.getAddress().getCity());
        System.out.println("State...: " + matheus.getAddress().getState());
        System.out.println("Country...: " + matheus.getAddress().getCountry());
        System.out.println("Zip-code...: " + matheus.getAddress().getZipCode());
    }
}
