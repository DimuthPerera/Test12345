package hms;

import java.sql.*;

public class MySQLdb implements Strategy{
    @Override
    public void doOperation(Student studentDetails) throws SQLException {

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "student2", "student");

        Statement myState = conn.createStatement();
        myState.executeUpdate("INSERT INTO details (ID, name, address, phoneNumber) VALUES (" + studentDetails.getID() + ", '" + studentDetails.getName() + "', '" + studentDetails.getAddress() + "', '" + studentDetails.getPhoneNumber() + "'" + ")");
    }
}
