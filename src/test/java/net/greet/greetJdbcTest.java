package net.greet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class greetJdbcTest {

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
                    statement.addBatch("delete from users where name in ('Thabang', 'Ntando', 'Sive')");
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
    public void addDataToUsersTableViaMigration() {

        try {

            Connection conn = getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery ("select count(*) as counter from users");

            if (rs.next()) {
                assertEquals(2, rs.getInt("counter"));
            }


        } catch (Exception e) {
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

            addUsersPreparedStatement.setString(1, "Thabang");
            addUsersPreparedStatement.setInt(2, 1);
            addUsersPreparedStatement.execute();


            addUsersPreparedStatement.setString(1, "Ntando");
            addUsersPreparedStatement.setInt(2, 1);
            addUsersPreparedStatement.execute();

            ResultSet rs = conn.createStatement().executeQuery("select * from users where name in ('Thabang', 'Ntando')");


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
        Greeted_jdbc greet = new Greeted_jdbc();
        greet.greeted("Ntando");
        greet.greeted("Thabang");
        greet.greeted("Sive");
        assertEquals(3, greet.counter());
    }

    @Test
    void shouldReturnTheCorrectNumOfOneUserStored() {
        Greeted_jdbc greet = new Greeted_jdbc();

        greet.greeted("Ntando");
        greet.greeted("Ntando");
        greet.greeted("Thabang");
        greet.greeted("Sive");

        assertEquals(2, greet.counterForUser("Ntando"));
    }
    @Test
    void shouldRemoveAllUsers() {
        Greeted_jdbc greet = new Greeted_jdbc();

        greet.greeted("Ntando");
        greet.greeted("Ntando");
        greet.greeted("Ntando");
        greet.greeted("Thabang");
        assertEquals(2, greet.counter());
        greet.clearUsers();
        assertEquals(0, greet.counter());
    }

    @Test
    void shouldRemoveOneUsers() {
        Greeted_jdbc greet = new Greeted_jdbc();

        greet.greeted("Ntando");
        greet.greeted("Ntando");
        greet.greeted("Ntando");
        greet.greeted("Thabang");
        greet.greeted("Sive");
        greet.counter();
        assertEquals(3,  greet.counter());
        greet.clearUser("Ntando");
        assertEquals(2,  greet.counter());


    }
}
