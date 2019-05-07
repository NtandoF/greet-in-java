package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GreetedUsingJDBCTest {

    final String GREET_DATABASE_URL = "jdbc:h2:./target/greetings_db";

    public Connection getConnection() throws Exception {

        Connection conn = DriverManager.getConnection(GREET_DATABASE_URL, "sa", "");
        return conn;
    }
        @BeforeEach
        public void cleanUpTables() {

            try {
                try(Connection conn = getConnection()) {
                    Statement statement = conn.createStatement();
                    statement.addBatch("delete from users where name in ('thabang', 'ntando', 'sive')");
                    statement.executeBatch();
                }
            } catch(Exception ex) {
                System.out.println("These test will fail until the users table is created: " + ex);
            }
        }

        @Test
        public void loadJdbcDriver() {

            try {
                Class.forName("org.h2.Driver");
            } catch (ClassNotFoundException e) {
                fail(e);
            }
      }



    @Test
    public void addDataUsersUsingPreparedStatement() {

        try {

            Connection conn = getConnection();
            final String INSERT_USERS_SQL = "insert into users (name, counter) values (?, ?)";
            final String FIND_USERS_SQL = "select name, counter from users where name = ?";

            PreparedStatement addUsersPreparedStatement = conn.prepareStatement(INSERT_USERS_SQL);

            addUsersPreparedStatement.setString(1, "thabang");
            addUsersPreparedStatement.setInt(2, 1);
            addUsersPreparedStatement.execute();


            addUsersPreparedStatement.setString(1, "ntando");
            addUsersPreparedStatement.setInt(2, 1);
            addUsersPreparedStatement.execute();

            ResultSet rs = conn.createStatement().executeQuery("select * from users where name in ('thabang', 'ntando')");


            int counter = 0;
            while(rs.next()) {
                counter++;
                if (counter == 1) {
                    assertEquals(1, rs.getInt("counter"));
                }
                else if ( counter == 2) {
                    assertEquals(1, rs.getInt("counter"));
                }
            }
            assertEquals(2, counter);



        } catch (Exception e) {
            fail(e);
        }
    }

    @Test
    void shouldReturnTheCorrectNumOfUsersStored() {
        GreetedUsingJDBC greet = new GreetedUsingJDBC();
        greet.greeted("ntando");
        greet.greeted("thabang");
        greet.greeted("sive");
        assertEquals(3, greet.counter());
    }

    @Test
    void shouldReturnTheCorrectNumOfOneUserStored() {
        GreetedUsingJDBC greet = new GreetedUsingJDBC();

        greet.greeted("ntando");
        greet.greeted("ntando");
        greet.greeted("thabang");
        greet.greeted("sive");

        assertEquals(2, greet.counterForUser("Ntando"));
    }
    @Test
    void shouldRemoveAllUsers() {
        GreetedUsingJDBC greet = new GreetedUsingJDBC();
        assertEquals(0, greet.counter());
        greet.greeted("ntando");
        greet.greeted("ntando");
        greet.greeted("ntando");
        greet.greeted("thabang");
        assertEquals(2, greet.counter());
        greet.clearUsers();
        assertEquals(0, greet.counter());
    }

    @Test
    void shouldRemoveOneUsers() {
        GreetedUsingJDBC greet = new GreetedUsingJDBC();
        assertEquals(0,  greet.counter());
        greet.greeted("ntando");
        greet.greeted("ntando");
        greet.greeted("ntando");
        greet.greeted("thabang");
        greet.greeted("sive");

        greet.clearUser("ntando");
        assertEquals(2,  greet.counter());


    }
}
