package Laboratorios.lab12.controllers;

import Laboratorios.lab12.domain.*;

public class RoomController {
    private Hostel hostel;
    private Room room;

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void registerRoom() {
        hostel = new Hostel();
        room = new Room();
    }

    public void saveRoomData(String name, int number, Type type, int floor, String description, double dimensions) {
        room.setName(name);
        room.setNumber(number);
        room.setType(type);
        room.setFloor(floor);
        room.setDescription(description);
        room.setDimensions(dimensions);

        hostel.addRooms(room);
    }
}
