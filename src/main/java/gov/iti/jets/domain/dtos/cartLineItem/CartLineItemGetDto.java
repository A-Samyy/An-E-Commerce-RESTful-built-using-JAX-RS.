package gov.iti.jets.domain.dtos.cartLineItem;

import gov.iti.jets.domain.models.Product;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartLineItemGetDto {
    private Product product;

    private int quantity;

    public CartLineItemGetDto() {
    }

    public CartLineItemGetDto( Product product, int quantity ) {
        this.product = product;
        this.quantity = quantity;
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

    @Override
    public String toString() {
        return "CartLineItemGetDto{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
