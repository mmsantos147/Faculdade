package hostelapp.version6.model;

public class Contact {
    private String email;
    private int phoneNumber;
    private Address address;

    public Contact(String email, int phoneNumber, Address address) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
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
                ", address=" + address +
                ", phone='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
