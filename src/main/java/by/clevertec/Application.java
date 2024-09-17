package by.clevertec;

import by.clevertec.dto.Address;
import by.clevertec.dto.User;
import by.clevertec.serialization.Serializer;

public class Application {
    public static void main(String[] args) {

        try {
            User user = new User()
                .setName("Ivanov Ivan Petrovich")
                .setAge(40)
                .setAddress(new Address()
                        .setStreet("Ilyich street")
                        .setCity("Gomel"));
            Serializer serializer = new Serializer();
            String json = serializer.serialize(user);
            System.out.println(json);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
