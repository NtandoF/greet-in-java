package net.greet;

import java.sql.*;

public class Greeted_jdbc implements Counter {
    final String INSERT_USERS_SQL = "insert into users (name, counter) values(?, ?)";

    final String FIND_USERS_SQL = "select counter from users where name = ?";

    final String UPDATE_USERS_SQL = "update users set counter = ? where name = ?";


    Connection conn;
    PreparedStatement psCreateNewUsers;
    PreparedStatement psFindUsers;
    PreparedStatement psUpdateUsersCount;

    public Greeted_jdbc() {
        try {
            conn = DriverManager.
                    getConnection("jdbc:h2:./target/greetings_db","sa", "");
            psCreateNewUsers = conn.prepareStatement(INSERT_USERS_SQL);
            psFindUsers = conn.prepareStatement(FIND_USERS_SQL);
            psUpdateUsersCount = conn.prepareStatement(UPDATE_USERS_SQL);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void greeted(String name) {
        try {
            psCreateNewUsers.setString(1, name);
            psCreateNewUsers.setInt(2, 1);
            psCreateNewUsers.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }
    }

    @Override
    public int counterForUser(String name) {

        try {
            psFindUsers.setString(1, name);
            ResultSet rsname = psFindUsers.executeQuery();
            if (!rsname.next()) {
                System.out.println("no count for " + name);

                psCreateNewUsers.setString(1, rsname.toString());
                psCreateNewUsers.setInt(2, 1);
                System.out.println(psCreateNewUsers.execute());

            } else {
                int Count = rsname.getInt("counter");
                psUpdateUsersCount.setInt(1, ++Count);
                psUpdateUsersCount.setString(2, rsname.toString());
                psUpdateUsersCount.execute();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
          return 0;
    }
    @Override
    public int counter() {

        try {
            psFindUsers.setInt(1, 1);
            ResultSet rs = psFindUsers.executeQuery();
            if (rs.next()) {
                return rs.getInt("counter");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        // if this pet wasn't greeted yet
        return 0;
    }


    @Override
    public int clearUser(String name) {
        return 0;
    }


    @Override
    public void clearUsers() {

    }

    @Override
    public void greetedNames() {
        try {
            PreparedStatement vp = conn.prepareStatement("select * from users");
            ResultSet rs = vp.executeQuery();

            while(rs.next()){
                System.out.println( rs.getString("name") + " count:" + rs.getInt("counter"));
               ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
