package by.clevertec.serialization;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class Serializer {
    @SneakyThrows
    public String serialize(Object obj) throws IllegalAccessException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public <T> T deserialize(String json, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    public Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            Object value = field.get(obj);

            if (value != null) {
                if (value.getClass().isPrimitive() || value instanceof String || value instanceof Number || value instanceof Boolean) {
                    map.put(field.getName(), value);
                } else {
                    map.put(field.getName(), objectToMap(value));
                }
            }
        }
        return map;
    }
}
