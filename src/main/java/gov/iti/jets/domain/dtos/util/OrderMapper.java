package gov.iti.jets.domain.dtos.util;

import gov.iti.jets.domain.dtos.order.OrderGetDto;
import gov.iti.jets.domain.dtos.order.OrderLineItemDto;
import gov.iti.jets.domain.models.Order;
import gov.iti.jets.domain.models.OrderLineItem;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderMapper {
    public static OrderGetDto entityToGetDto( Order entity ){
       return new OrderGetDto( entity.getId(), orderLineItemtoDtos(entity.getOrderLineItemsUnmodifiable()), entity.getTotal()  );
    }
    private static Set<OrderLineItemDto> orderLineItemtoDtos( Set<OrderLineItem> orderLineItems){
        return orderLineItems.stream().map(item -> orderLineItemtoDto(item) ).collect( Collectors.toSet());
    }

    private static OrderLineItemDto orderLineItemtoDto( OrderLineItem item){
        return  new OrderLineItemDto( item.getId(), item.getProduct(),item.getQuantity(),item.getUnitCost());
    }
}
