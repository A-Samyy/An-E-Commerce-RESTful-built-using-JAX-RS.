package gov.iti.jets.domain.models;


import gov.iti.jets.domain.dtos.shoppingCart.ShoppingCartSerializable;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalField;
import java.util.Optional;

import gov.iti.jets.domain.enums.Role;

@Entity
@Table( name = "users" )
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    private String email;

    private String phoneNumber;

 
    @Column( name = "user_password" )
    private String password;


    @Column( name = "user_role" )
    private Role role;

    @OneToOne( mappedBy = "owner" )
    @JsonbTypeSerializer( ShoppingCartSerializable.class )
    private ShoppingCart shoppingCart;

    public User( int id, String name, String email, String phoneNumber, String password ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public User( int id, String name, String email, String phoneNumber, String password, Role role ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public User( String name, String email, String phoneNumber, String password, Role role) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    public User( String name, String email, String phoneNumber, String password ) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    protected User() {

    }

    
    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
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

    public Optional<ShoppingCart> getShoppingCart() {
        return Optional.ofNullable( this.shoppingCart );
    }

    public void setShoppingCart( ShoppingCart shoppingCart ) {
        shoppingCart._setOwner( this );
        this.shoppingCart = shoppingCart;
    }

 
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber( String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", shoppingCart=" + shoppingCart +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
