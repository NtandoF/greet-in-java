package net.greet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Greeted_jdbc implements Counter {
Connection connection;
    @Override
    public void greeted(String name) {
        try {
            PreparedStatement addUsersPreparedStatement = connection.prepareStatement( "insert into users (name, counter) values (?, ?)");
            addUsersPreparedStatement.setString(1, name);
            addUsersPreparedStatement.setInt(2, 1);
            addUsersPreparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int counterForUser(String name) {


    }

    @Override
    public int counter() {
        return 0;
    }

    @Override
    public int clearUser(String name) {
        return 0;
    }

    @Override
    public void clearUsers() {

    }
}
