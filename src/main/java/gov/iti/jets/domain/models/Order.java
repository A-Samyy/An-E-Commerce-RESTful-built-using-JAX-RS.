package gov.iti.jets.domain.models;

import gov.iti.jets.domain.dtos.order.OwnerSerializable;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "orders" )
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @OneToMany( mappedBy = "order", fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL )
    private final Set<OrderLineItem> orderLineItems = new HashSet<>();


    @ManyToOne
    @JoinColumn( name = "order_user" )
    @JsonbTypeSerializer( OwnerSerializable.class )
    private User owner;

    private long total = 0;

    protected Order() {

    }

    public Order( User owner ) {
        this.owner = owner;
        ShoppingCart shoppingCart = owner.getShoppingCart()
                .orElseThrow( () -> new IllegalArgumentException( "User shopping cart is null." ) );
        this.populateLineItemsFromCart( shoppingCart );
    }

    public void populateLineItemsFromCart( ShoppingCart shoppingCart ) {
        shoppingCart.getCartLineItemsUnmodifiable().forEach( cartLineItem -> this.addOrderLineItem( new OrderLineItem( cartLineItem ) ) );
    }

    public void addOrderLineItem( OrderLineItem orderLineItem ) {
        orderLineItem._setOrder( this );
        this.orderLineItems.add( orderLineItem );
        updateTotal( orderLineItem.getTotalCost() );
    }

    private void updateTotal( long orderLineItemTotalCost ) {
        total += orderLineItemTotalCost;
    }

    public int getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public Set<OrderLineItem> getOrderLineItemsUnmodifiable() {
        return Set.copyOf( orderLineItems );
    }

    public long getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", owner=" + owner.getName()+
                ", orderLineItems=" + orderLineItems +
                ", total=" + total +
                '}';
    }

    public String getTotalFormatted() {
        return "" + this.total / 100 + "." + this.total % 100;
    }
}
