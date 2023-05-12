package hostelapp.version3;

import hostelapp.version3.model.*;
import java.util.List;
import java.util.ArrayList;

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

        Reservation reservation1 =  new Reservation();
        Date reservationDate1 = new Date(12,5,2023);
        Date checkinDate1 = new Date(15,7,2023);
        Date checkoutDate1 = new Date(22,7,2023);
        reservation1.setReservationDate(reservationDate1);
        reservation1.setCheckinDate(checkinDate1);
        reservation1.setCheckoutDate(checkoutDate1);

        ArrayList<Reservation> reservations =new ArrayList<>();
        reservations.add(reservation1);
        matheus.setReservations(reservations);

        System.out.println("Name...: " + matheus.getName());
        System.out.println("Last name...: " + matheus.getLastName());
        System.out.println("E-mail...: " + email);
        System.out.println("Birthday...: "+ matheus.getDate());
        System.out.println("Address...: " + matheus.getAddress().getAddress());
        System.out.println("City...: " + matheus.getAddress().getCity());
        System.out.println("State...: " + matheus.getAddress().getState());
        System.out.println("Country...: " + matheus.getAddress().getCountry());
        System.out.println("Zip-code...: " + matheus.getAddress().getZipCode());

        System.out.println();
        List<Reservation> temp =matheus.getReservations();
        for (Reservation reservation : temp)
            System.out.println(reservations);

    }
}
