package gov.iti.jets.domain.dtos.User;

import gov.iti.jets.domain.enums.Role;
import jakarta.persistence.Column;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserPutDto {
        private int id;

        private String name;

        private String email;

        private String phoneNumber;

        private String password;

    public UserPutDto() {
    }

    public UserPutDto( int id, String name, String email, String phoneNumber, String password ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserPutDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
