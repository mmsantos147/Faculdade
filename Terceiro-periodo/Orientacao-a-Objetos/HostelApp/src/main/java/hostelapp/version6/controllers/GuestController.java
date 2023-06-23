package hostelapp.version6.controllers;

import hostelapp.version6.model.*;

public class GuestController {
    private Guest guest;
    private Hostel hostel;

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

    public void registerGuest (){
        this.guest = new Guest();
        this.hostel = new Hostel();
    }

    public void persistGuestData(String name, String lastName, String email, Title title, Address address) {
        guest.setName(name);
        guest.setLastname(lastName);
        guest.setAddress(address);
        guest.setEmail(email);
        guest.setTitle(title);

        hostel.addGuests(guest);
    }
}
