package gov.iti.jets.domain.dtos.Product;

import gov.iti.jets.domain.enums.Category;
import jakarta.persistence.Column;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductPostDto {
    private String name;

    private String description;

    private long price;

    private int quantity;

    private Category category;

    public ProductPostDto() {
    }

    public ProductPostDto( String name, String description, long price, int quantity, Category category ) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
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

    @Override
    public String toString() {
        return "ProductPostDto{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
}
