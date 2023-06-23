package hostelapp.version6;

import hostelapp.version6.controllers.*;
import hostelapp.version6.exception.ExceptionRoomNotFound;
import hostelapp.version6.model.*;

import java.util.ArrayList;
import java.util.List;

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
        room.saveRoomData("Florentino", 777, Type.Single, 777, "single room", 77.7);
        room.saveRoomData("Sla", 555, Type.Single, 555, "single room", 55.5);

        try {
            room.searchRoom(4);
        } catch (ExceptionRoomNotFound e) {
            System.out.println("Exceção capturada..: " + e.toString());
        }

        guest.registerGuest();
        guest.persistGuestData("Matheus", "Santos", "matheus.santos@teste.com", Title.DR, matheusAddress);

        System.out.println(hostel.getHostel().toString());
        System.out.println();
        System.out.println(room.getRoom().toString());
        System.out.println();
        System.out.println(guest.getGuest().toString());
    }
}
