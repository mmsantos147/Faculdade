package hostelapp.version3.model;

public class PersonalInfo {
    private int personalId;
    private String email;

    public PersonalInfo(int personalId, String email) {
        this.personalId = personalId;
        this.email = email;
    }

    public int getPersonalId() {
        return personalId;
    }

    public void setPersonalId(int personalId) {
        this.personalId = personalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
