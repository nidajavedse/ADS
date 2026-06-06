package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonUtil {

    private static final ObjectMapper mapper =
            new ObjectMapper();

    static {
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(
                SerializationFeature.INDENT_OUTPUT);
    }

    public static String toJson(Object obj)
            throws Exception {

        return mapper.writeValueAsString(obj);
    }
}