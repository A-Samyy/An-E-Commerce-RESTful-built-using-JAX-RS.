package gov.iti.jets.domain.dtos.shoppingCart;

import gov.iti.jets.domain.models.ShoppingCart;
import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;

public class ShoppingCartSerializable implements JsonbSerializer<ShoppingCart> {
    @Override
    public void serialize( ShoppingCart shoppingCart, JsonGenerator jsonGenerator, SerializationContext serializationContext ) {
        var str = shoppingCart.toString();
        jsonGenerator.write( str );
    }
}
