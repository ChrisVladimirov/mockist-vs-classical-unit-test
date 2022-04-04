package example3;

import example2.StudentSystem;
import example2.impl.StudentParserImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentSystemTest {
    @Test
    public void createStudent_sampleInput_expectedResult() {
        String input = "Pesho,18";
        String expectedResult = "1,Pesho,18";
        StudentSystem studentSystem = new StudentSystem(new StudentParserImpl(), new FakeDatabase());

        String result = studentSystem.createStudent(input);

        assertEquals(expectedResult, result);
    }
}
