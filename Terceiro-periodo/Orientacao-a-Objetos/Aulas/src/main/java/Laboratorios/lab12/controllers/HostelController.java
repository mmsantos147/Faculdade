package Laboratorios.lab12.controllers;

import Laboratorios.lab12.domain.Address;
import Laboratorios.lab12.domain.Hostel;

public class HostelController {
    private Hostel hostel;

    public Hostel getHostel() {
        return hostel;
    }

    public void setHostel(Hostel hostel) {
        this.hostel = hostel;
    }

    public void registerInfo() {
        hostel = new Hostel();
    }

    public void saveInfo(String name, String homepage, Address address) {
        hostel.setName(name);
        hostel.setHomepageAddress(homepage);
        hostel.setAddress(address);
    }
}
