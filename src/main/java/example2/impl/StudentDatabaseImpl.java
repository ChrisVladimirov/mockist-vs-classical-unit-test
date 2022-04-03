package example2.impl;

import example2.Student;
import example2.interfaces.StudentDatabase;

public class StudentDatabaseImpl implements StudentDatabase {
    private static int CURRENT_ID = 0;

    @Override
    public Student persist(Student student) {
        student.setFacultyNumber(CURRENT_ID++);

    }

    @Override
    public Student getStudentByFacultyNumber(int facultyNumber) {
        return null;
    }
}
