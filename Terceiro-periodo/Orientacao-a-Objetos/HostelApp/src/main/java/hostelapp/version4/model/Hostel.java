package hostelapp.version4.model;

public class Hostel {
    private String name;
    private static Hostel hostel = new Hostel();

    private Hostel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Hostel getHostel() {
        return hostel;
    }
}
