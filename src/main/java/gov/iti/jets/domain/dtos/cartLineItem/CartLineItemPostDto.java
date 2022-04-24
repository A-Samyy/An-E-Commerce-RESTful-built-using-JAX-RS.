package gov.iti.jets.domain.dtos.cartLineItem;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartLineItemPostDto {
    int userId;
    int productId;
    int quantity;

    public CartLineItemPostDto() {
    }

    public CartLineItemPostDto( int userId, int productId, int quantity ) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId( int userId ) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId( int productId ) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity( int quantity ) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartLineItemPostDto{" +
                "userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
