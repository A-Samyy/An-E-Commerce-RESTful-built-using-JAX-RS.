package gov.iti.jets.domain.dtos.order;

import gov.iti.jets.domain.models.OrderLineItem;
import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;

public class OrderLineItemSerializable implements JsonbSerializer<OrderLineItem> {
    @Override
    public void serialize( OrderLineItem orderLineItem, JsonGenerator jsonGenerator, SerializationContext serializationContext ) {
        var str = orderLineItem.toString();
        jsonGenerator.write(str);
    }
}
