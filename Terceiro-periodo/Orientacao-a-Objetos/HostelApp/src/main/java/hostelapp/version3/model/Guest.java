package hostelapp.version3.model;

import java.util.*;

public class Guest {
    private String name;
    private String lastname;
    //private Integer id;
    private Address address;
    private Date date;
    private List<Reservation> reservations = new ArrayList<>();

    public Guest () {
        this("");
    }

    public Guest (String name) {
        this(name, "");
    }

    public Guest(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
        //this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name.length() > 2) {
            this.name = name;
            return true;
        }
        return false;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getLastName() {
        return lastname;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation (Reservation reservation){
        reservations.add(reservation);
    }
}

