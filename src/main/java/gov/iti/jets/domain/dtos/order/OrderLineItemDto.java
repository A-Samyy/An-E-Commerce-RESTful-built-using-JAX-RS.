package gov.iti.jets.domain.dtos.order;

import gov.iti.jets.domain.models.Product;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

public class OrderLineItemDto implements Serializable {
    private int id;

    private Product product;

    private int quantity;

    private long unitCost;

    public OrderLineItemDto() {
    }

    public OrderLineItemDto( int id, Product product, int quantity, long unitCost ) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitCost = unitCost;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct( Product product ) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    public long getUnitCost() {
        return unitCost;
    }

    public void setUnitCost( long unitCost ) {
        this.unitCost = unitCost;
    }

    @Override
    public String toString() {
        return "OrderLineItemDto{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", unitCost=" + unitCost +
                '}';
    }
}
