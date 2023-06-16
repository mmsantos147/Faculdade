package Laboratorios.lab12.domain;

public class Guest {
    private String name;
    private String lastname;
    private String email;
    private Title title;
    private Date date;
    private Address address;

    public Guest() {}

    public Guest(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    public Guest(String name, String lastname, String email, Title title, Date date, Address address) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.title = title;
        this.date = date;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", "  + address.toString() +
                '}';
    }
}
