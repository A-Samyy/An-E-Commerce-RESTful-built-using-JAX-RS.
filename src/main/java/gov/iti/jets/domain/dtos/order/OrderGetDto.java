package gov.iti.jets.domain.dtos.order;

import gov.iti.jets.domain.models.OrderLineItem;
import gov.iti.jets.domain.models.User;
import jakarta.json.bind.annotation.JsonbTypeSerializer;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@XmlRootElement
public class OrderGetDto implements Serializable {
    private int id;

//    @XmlJavaTypeAdapter( OrderLineItem.JaxbAdapter.class )
    @JsonbTypeSerializer( OrderLineItemSerializable.class )
private final Set<OrderLineItem> orderLineItems = new HashSet<>();

    private long total = 0;

    public OrderGetDto() {
    }

    public OrderGetDto( int id, long total ) {
        this.id = id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public Set<OrderLineItem> getOrderLineItems() {
        return orderLineItems;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal( long total ) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "OrderGetDto{" +
                "id=" + id +
                ", orderLineItems=" + orderLineItems +
                ", total=" + total +
                '}';
    }
}
