package hostelapp.version6.model;

import hostelapp.version6.exception.ExceptionRoomNotFound;

import java.util.ArrayList;
import java.util.List;

public class Hostel {
    private String name;
    private String homepageAddress;
    private String description;
    private int inaugurationDate;
    private List<Guest> guests = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();
    private Room room;
    private Guest guest;
    private Address address;
    private Contact contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomepageAddress() {
        return homepageAddress;
    }

    public void setHomepageAddress(String homepageAddress) {
        this.homepageAddress = homepageAddress;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInaugurationDate() {
        return inaugurationDate;
    }

    public void setInaugurationDate(int inaugurationDate) {
        this.inaugurationDate = inaugurationDate;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public void addGuests(Guest guest){
        guests.add(guest);
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployees(Employee employee){
        employees.add(employee);
    }

    public Room getRooms(int number) throws ExceptionRoomNotFound {
        for (Room room : rooms){
            if (room.getNumber() == number)
                return room;
        }
        throw new ExceptionRoomNotFound("Room not found", number);
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public void addRooms(Room room) {
        rooms.add(room);
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Hostel{" +
                "name='" + name + '\'' +
                ", homepageAddress='" + homepageAddress + '\'' +
                ", " + address.toString() +
                '}';
    }
}