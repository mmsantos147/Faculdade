package Laboratorios.lab12;

import Laboratorios.lab12.domain.*;
import Laboratorios.lab12.controllers.*;

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

        room.registerRoom();
        room.saveRoomData("Matheus", 666, Type.Single, 666, "single room", 66.6);

        guest.registerGuest();
        guest.persistGuestData("Matheus", "Santos", "matheus.santos@teste.com", Title.DR, matheusAddress);

        System.out.println(hostel.getHostel().toString());
        System.out.println();
        System.out.println(room.getRoom().toString());
        System.out.println();
        System.out.println(guest.getGuest().toString());
    }
}
