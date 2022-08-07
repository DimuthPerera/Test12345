package hms;

import org.codehaus.jackson.map.ObjectMapper;


import java.io.IOException;

public class Jserializer{
    public String doOperation(Student student) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE, true);

        String JString = mapper.writeValueAsString(student);

        return JString;


    }
}
