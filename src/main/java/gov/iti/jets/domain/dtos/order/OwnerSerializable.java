package gov.iti.jets.domain.dtos.order;

import gov.iti.jets.domain.models.User;
import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;

public class OwnerSerializable implements JsonbSerializer<User> {
    @Override
    public void serialize( User user, JsonGenerator jsonGenerator, SerializationContext serializationContext ) {
        var str = user.toString();
        jsonGenerator.write( str );
    }
}
