package gov.iti.jets.domain.dtos.util;

import gov.iti.jets.domain.dtos.order.OrderGetDto;
import gov.iti.jets.domain.models.Order;

public class OrderMapper {
    public static OrderGetDto entityToGetDto( Order entity ){
        return new OrderGetDto( entity.getId(), entity.getTotal() );
    }
}
