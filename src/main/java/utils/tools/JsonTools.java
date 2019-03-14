package utils.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonTools {

    public static String toString(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        return mapper.writeValueAsString(object);
    }

    public static <T> T toObject(String json, Class<T> classValue) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enableDefaultTyping();

        return mapper.readValue(json, classValue);
    }
}
