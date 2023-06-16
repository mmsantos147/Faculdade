package Laboratorios.lab12.domain;

public class Employee {
    private String name;
    private String lastName;
    private Authentication authentication;
    private Role role;

    public Employee(String name, String lastName, Authentication authentication, Role role) {
        this.name = name;
        this.lastName = lastName;
        this.authentication = authentication;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Authentication getAuthentication() {
        return authentication;
    }

    public void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
