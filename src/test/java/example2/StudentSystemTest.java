package example2;

import example2.interfaces.StudentDatabase;
import example2.interfaces.StudentParser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StudentSystemTest {
    @Mock
    private StudentParser parser;

    @Mock
    private StudentDatabase database;

    @InjectMocks
    private StudentSystem studentSystem;

    @Test
    public void createStudent_sampleInput_expectedResult() {
        String input = "Pesho,18";
        String expectedResult = "1,Pesho,18";
        Student student = new Student("Pesho", 18);
        Student withId = new Student(1, "Pesho", 18);

        when(parser.parseStudent(input)).thenReturn(student);
        when(parser.formatStudent(withId)).thenReturn(expectedResult);
        when(database.persist(student)).thenReturn(withId);
        StudentSystem studentSystem = new StudentSystem(parser, database);

        String result = studentSystem.createStudent(input);

        assertEquals(expectedResult, result);
    }
}
