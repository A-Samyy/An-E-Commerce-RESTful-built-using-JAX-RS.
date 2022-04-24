package gov.iti.jets.domain.dtos.User;

import gov.iti.jets.domain.enums.Role;
import jakarta.persistence.Column;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserPostDto {
    private String name;

    private String email;

    private String phoneNumber;

    private String password;

    private String role;

    public UserPostDto() {
    }

    public UserPostDto( String name, String email, String phoneNumber, String password ) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public UserPostDto( String name, String email, String phoneNumber, String password, String role ) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole( String role ) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserPostDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
