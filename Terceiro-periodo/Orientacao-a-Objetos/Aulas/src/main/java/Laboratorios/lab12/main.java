package Laboratorios.lab12;

import Laboratorios.lab12.domain.*;
import Laboratorios.lab12.controllers.*;
import Laboratorios.lab12.domain.exceptions.GuestExistenceException;
import Laboratorios.lab12.domain.exceptions.RoomExistenceException;
import java.util.Iterator;

public class main {
    public static void main(String[] args) {
        HostelController hostel = new HostelController();
        RoomController room = new RoomController();
        GuestController guest = new GuestController();
        Address matheusAddress = new Address();
        Address hostelAddress = new Address();



        hostelAddress.setCity("Alfenas");
        hostelAddress.setState("Minas Gerais");
        hostelAddress.setCountry("Brasil");
        hostelAddress.setZipCode("00000-000");

        matheusAddress.setCity("Pirassununga");
        matheusAddress.setState("São Paulo");
        matheusAddress.setCountry("Brasil");
        matheusAddress.setZipCode("13636-000");

        hostel.registerInfo();
        hostel.saveInfo("Sparkling Water","www.sparklinwater.teste", hostelAddress);

        try {
            room.registerRoom();
            room.saveRoomData("Matheus", 666, Type.Single, 666, "single room", 66.6);
            room.registerRoom();
            room.saveRoomData("Thiago", 666, Type.Single, 666, "single room", 66.6);
        } catch (RoomExistenceException e1) {
            System.out.println("Exception: " + e1.getMessage() +"Room number: " + e1.getNumber());
        }

        try {
            guest.registerGuest();
            guest.persistGuestData("Matheus", "Santos", "123.456.789-00","matheus.santos@teste.com", Title.DR, matheusAddress);
            guest.registerGuest();
            guest.persistGuestData("Thiago", "Santos", "123.000.000-00","matheus.santos@teste.com", Title.DR, matheusAddress);
            guest.registerGuest();
            guest.persistGuestData("Marcos", "Santos", "123.456.789-00","matheus.santos@teste.com", Title.DR, matheusAddress);
        } catch (GuestExistenceException e1) {
            System.out.println("Exception: " + e1.getMessage() + " Guest already exist " + "cpf= " + e1.getCpf());
        }

//        Iterator<Guest> gt;
//        gt = guest.getGt();

//        Iterator<Room> rm;
//        rm = room.getRm();

        System.out.println(hostel.getHostel().toString());
        System.out.println();



        while (guest.getGt().hasNext()) {
            System.out.println(guest.getGt().next().toString());
        }

    }
}
