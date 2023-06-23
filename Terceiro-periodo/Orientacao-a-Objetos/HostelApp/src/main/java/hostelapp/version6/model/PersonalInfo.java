package hostelapp.version6.model;

public class PersonalInfo {
    private String personalId;
    private String email;

    public PersonalInfo(String personalId, String email) {
        this.personalId = personalId;
        this.email = email;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
