package by.clevertec.serialization;


import by.clevertec.dto.Address;
import by.clevertec.dto.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SerializerTest {
    @Test
    void testSerializationAndDeserialization() throws Exception {
        User user = new User()
                .setName("John Doe")
                .setAge(30)
                .setAddress(new Address()
                        .setCity("Gomel")
                        .setStreet("Sovetskaya street"));
        Serializer serializer = new Serializer();
        String json = serializer.serialize(user);
        User deserializedUser = serializer.deserialize(json, User.class);
        assertEquals(user, deserializedUser);
    }
}