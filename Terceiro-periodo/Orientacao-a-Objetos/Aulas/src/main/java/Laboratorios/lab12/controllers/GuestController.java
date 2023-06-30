package Laboratorios.lab12.controllers;

import Laboratorios.lab12.domain.*;
import Laboratorios.lab12.domain.exceptions.GuestExistenceException;
import java.util.Iterator;
import java.util.Objects;


public class GuestController {
    private Guest guest;
    private Hostel hostel;
    Iterator<Guest> gt;

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public Iterator<Guest> getGt() {
        return gt;
    }

    public void setGt(Iterator<Guest> gt) {
        this.gt = this.hostel.getGuests().iterator();
    }

    public void registerGuest (){
        this.guest = new Guest();
        this.hostel = new Hostel();
        this.gt = this.hostel.getGuests().iterator();
    }

    public boolean persistGuestData (String name, String lastName, String cpf, String email, Title title, Address address) throws GuestExistenceException {
        guest.setName(name);
        guest.setLastname(lastName);
        guest.setCpf(cpf);
        guest.setAddress(address);
        guest.setEmail(email);
        guest.setTitle(title);

        while (gt.hasNext()) {
            if (!Objects.equals(guest.getCpf(), gt.next().getCpf()) && !gt.hasNext()) {
                hostel.addGuests(guest);
                return true;
            }
        }

        throw new GuestExistenceException("Guest already exist", guest.getCpf());
    }
}
