package hms;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JdeSerializer{

    public Student doOperation(String JString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Student student = mapper.readValue(JString, Student.class);
        return student;
    }
}
