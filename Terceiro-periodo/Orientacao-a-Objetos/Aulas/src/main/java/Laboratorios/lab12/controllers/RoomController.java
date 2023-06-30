package Laboratorios.lab12.controllers;

import Laboratorios.lab12.domain.*;
import Laboratorios.lab12.domain.exceptions.RoomExistenceException;
import java.util.Iterator;

public class RoomController {
    private Hostel hostel = new Hostel();
    private Room room = new Room();
    private Iterator<Room> rm = hostel.getRooms().iterator();

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

    public Iterator<Room> getRm() {
        return rm;
    }

    public void setRm() {
        this.rm = this.hostel.getRooms().iterator();
    }

    public void registerRoom() {
        hostel = new Hostel();
        room = new Room();
        rm = hostel.getRooms().iterator();
    }

    public boolean saveRoomData(String name, int number, Type type, int floor, String description, double dimensions) throws RoomExistenceException {
        room.setName(name);
        room.setNumber(number);
        room.setType(type);
        room.setFloor(floor);
        room.setDescription(description);
        room.setDimensions(dimensions);


        while (rm.hasNext()) {
            if (room.getNumber() != rm.next().getNumber() && !rm.hasNext()){
                hostel.addRooms(room);
                return true;
            }
        }
        throw new RoomExistenceException("Room already registered", room.getNumber());
    }
}
