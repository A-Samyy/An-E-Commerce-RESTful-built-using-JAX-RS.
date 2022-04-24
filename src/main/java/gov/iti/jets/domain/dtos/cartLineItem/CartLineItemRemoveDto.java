package gov.iti.jets.domain.dtos.cartLineItem;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CartLineItemRemoveDto {
    int userId;
    int productId;

    public CartLineItemRemoveDto() {
    }

    public CartLineItemRemoveDto( int userId, int productId ) {
        this.userId = userId;
        this.productId = productId;
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

    @Override
    public String toString() {
        return "CartLineItemRemoveDto{" +
                "userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}
