package gov.iti.jets.domain.dtos.User;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserPatchDto {
    private int id;

    private Object name;

    private Object email;

    private Object phoneNumber;

    private Object password;

    public UserPatchDto() {
    }

    public UserPatchDto( int id ) {
        this.id = id;
    }

    public UserPatchDto( int id, Object name, Object email, Object phoneNumber, Object password ) {
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

    public Object getName() {
        return name;
    }

    public void setName( Object name ) {
        this.name = name;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail( Object email ) {
        this.email = email;
    }

    public Object getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber( Object phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword( Object password ) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserPatchDto{" +
                "id=" + id +
                ", name=" + name +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", password=" + password +
                '}';
    }
}
