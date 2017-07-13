package com.bell.vas.tdd.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.http.MediaType;

import java.nio.charset.Charset;

/**
 * Created by Boualem on 2017-07-12.
 */
public class TestUtil {

//    private static final Logger log = LoggerFactory.getLogger(TestUtil.class);
    /** MediaType for JSON UTF8 */
    public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
            MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

    /**
     * Convert an object to JSON byte array.
     *
     * @param object
     *            the object to convert
     * @return the JSON byte array
//     * @throws IOException
     */
    public static byte[] convertObjectToJsonBytes(Object object)
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        JodaModule module = new JodaModule();
//        module.addSerializer(DateTime.class, new CustomDateTimeSerializer());
//        module.addSerializer(LocalDate.class, new CustomLocalDateSerializer());
        mapper.registerModule(module);
        try {
            return mapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
//            log.error("convertObjectToJsonBytes ",e);
        }
        return new byte[0];
    }

    /**
     * Create a byte array with a specific size filled with specified data
     *
     * @param size
     * @param data
     * @return
     */
    public static byte[] createByteArray(int size, String data) {
        byte[] byteArray = new byte[size];
        for (int i = 0; i < size; i++) {
            byteArray[i] = Byte.parseByte(data, 2);
        }
        return byteArray;
    }
}