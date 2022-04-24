package gov.iti.jets.domain.models;

import jakarta.json.bind.annotation.JsonbTransient;
import gov.iti.jets.domain.enums.Category;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    @Column( name = "product_name" )
    private String name;

    private String description;

    private long price;

    private int quantity;

    private Category category;

    protected Product() {

    }

    public Product( int id, String name, String description, long price, int quantity, Category category ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public Product( String name, String description, long price, int quantity, Category category ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

   
    @JsonbTransient
    public long getPrice() {
        return price;
    }

    public void setPrice( long price ) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory( Category category ) {
        this.category = category;
    }

    public String getPriceFormatted() {
        return "" + this.price / 100 + "." + this.price % 100;
    }

 
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\'' + ", price=" + price + ", quantity=" + quantity + ", category=" + category + '}';
    }

   
  
}
