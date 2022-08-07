package hms;

import hms.Student;

import java.sql.SQLException;

public interface Strategy {
    public void doOperation(Student studentDetails) throws SQLException;
}
