package hostelapp.version5.model;

public class Address {
    private String adress;
    private String zipCode;
    private String city;
    private String state;
    private String country;

    public String getAddress() {
        return adress;
    }

    public void setAddress(String adress) {
        this.adress = adress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
