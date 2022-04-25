package gov.iti.jets.domain.dtos.Product;

import gov.iti.jets.domain.enums.Category;

public class ProductPatchDto {
    private int id;
    private Object name;

    private Object description;

    private Object price;

    private Object quantity;

    private Object category;

    public ProductPatchDto() {
    }

    public ProductPatchDto( int id ) {
        this.id = id;
    }

    public ProductPatchDto( int id, Object name, Object description, Object price, Object quantity, Object category ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
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

    public Object getDescription() {
        return description;
    }

    public void setDescription( Object description ) {
        this.description = description;
    }

    public Object getPrice() {
        return price;
    }

    public void setPrice( Object price ) {
        this.price = price;
    }

    public Object getQuantity() {
        return quantity;
    }

    public void setQuantity( Object quantity ) {
        this.quantity = quantity;
    }

    public Object getCategory() {
        return category;
    }

    public void setCategory( Object category ) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "ProductPatchDto{" +
                "id=" + id +
                ", name=" + name +
                ", description=" + description +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category=" + category +
                '}';
    }
}
