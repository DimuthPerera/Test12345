package hms;

import java.sql.SQLException;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public void executeStrategy(Student studentDetails) throws SQLException {
        strategy.doOperation(studentDetails);
    }
}
