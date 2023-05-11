package hostelapp.version1.model;

public class Guest {
    private String name;
    private String lastname;
    private Address address;

    public Guest () {
        this("");
    }

    public Guest (String name) {
        this(name, "");
    }

    public Guest (String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
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

}
