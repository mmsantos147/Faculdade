package hostelapp.version2.model;

public class Guest {
    private String name;
    private String lastname;
    private Integer id;
    private Address address;
    private Date  date;

    public Guest (String name, String lastname, int id) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
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

    public int getId() {
        if (this.id.toString().length() == 11) {
            return id;
        } else {
            return 0;
        }
    }

    public void setId(int id) {
        if (this.id.toString().length() == 11) {
            this.id = id;
        } else {
            System.out.println("Invalid personal id, try again");
        }
    }
}