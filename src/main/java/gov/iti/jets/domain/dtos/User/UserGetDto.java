package gov.iti.jets.domain.dtos.User;

import gov.iti.jets.domain.enums.Role;
import gov.iti.jets.domain.models.ShoppingCart;
import jakarta.ws.rs.core.Link;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement
public class UserGetDto {
    private int id;
    private String name;

    private String email;

    private String phoneNumber;

    private String password;

    private Role role;

//    @XmlJavaTypeAdapter( Link.JaxbAdapter.class )
//    private ShoppingCart shoppingCart;

    private List<String> links= new ArrayList<>();

    public UserGetDto() {
    }
    public UserGetDto(int id, String name, String email, String phoneNumber, String password, Role role ) {
        this.id =id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
//        this.shoppingCart = shoppingCart;
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

    public Role getRole() {
        return role;
    }

    public void setRole( Role role ) {
        this.role = role;
    }

//    public ShoppingCart getShoppingCart() {
//        return shoppingCart;
//    }
//
//    public void setShoppingCart( ShoppingCart shoppingCart ) {
//        this.shoppingCart = shoppingCart;
//    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks( List<String> links ) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "UserGetDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
//                ", shoppingCart=" + shoppingCart +
                '}';
    }
}
