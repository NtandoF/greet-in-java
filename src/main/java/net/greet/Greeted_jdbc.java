package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static java.sql.DriverManager.getConnection;

public class Greeted_jdbc implements Counter {
    final String INSERT_USERS_SQL = "insert into users (name, counter) values(?, ?)";

    final String FIND_USERS_SQL = "select * from users";

    final String FIND_USER_BY_NAME_SQL = "select * from users where name = ?";

    final String UPDATE_USERS_SQL = "update users set counter = counter + 1 where name = ?";


    Connection conn;
    PreparedStatement psCreateNewUsers;
    PreparedStatement psFindUsers;
    PreparedStatement psUpdateUsersCount;
    PreparedStatement findUserByName;

    public Greeted_jdbc() {
        try {
            conn = getConnection("jdbc:h2:./target/greetings_db","sa", "");
            psCreateNewUsers = conn.prepareStatement(INSERT_USERS_SQL);
            psFindUsers = conn.prepareStatement(FIND_USERS_SQL);
            psUpdateUsersCount = conn.prepareStatement(UPDATE_USERS_SQL);
            findUserByName = conn.prepareStatement(FIND_USER_BY_NAME_SQL);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void greetedNames() {
        try {
            PreparedStatement vp = conn.prepareStatement("select * from users");
            ResultSet rs = vp.executeQuery();
            while(rs.next()){
                System.out.println( rs.getString("name") + " count:" + rs.getInt("counter"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
            psFindUsers.execute();
            ResultSet rsname = psFindUsers.executeQuery();
            System.out.println(rsname.next() + " ntando is");
            if (!rsname.next()) {
                System.out.println("no count for " + name);
                psCreateNewUsers.setString(1, name);
                psCreateNewUsers.setInt(2,1);
                psCreateNewUsers.execute();
            } else {
                psUpdateUsersCount.setString(1, rsname.getString("name"));
                psUpdateUsersCount.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
          return 0;
    }
    @Override
    public int counter() {

        try {
            ResultSet rs = psFindUsers.executeQuery();
            if (rs.next()) {
                return rs.getInt("counter");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }


    @Override
    public int clearUser(String name) {
        return 0;
    }


    @Override
    public void clearUsers() {

            try {
                    Statement statement = conn.createStatement();
                    statement.addBatch("delete from users");
                    statement.executeBatch();
                System.out.println("Users deleted :-)");

            } catch(Exception ex) {
                System.out.println("These test will fail until the users table is created: " + ex);
            }
       }

    public void userUpdateOrCreate(String user) {
        // find
        // update or create
        
        try {
            
            if(findUser(user).isEmpty()) {
                //No user found
                //create user/ insert
                psCreateNewUsers.setString(1, user);
                psCreateNewUsers.setInt(2,1);
                psCreateNewUsers.execute();

            } else {
                //we update user count
                psUpdateUsersCount.setString(1, user);
                psUpdateUsersCount.executeUpdate();
            }
            
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public Map<String, Integer> findUser(String user) throws SQLException {
        Map<String, Integer> map = new HashMap<>();

        findUserByName.setString(1, user);

        ResultSet rs = findUserByName.executeQuery();

        if(rs.next()) {
            //add user to map => {name=3}
            map.put(rs.getString("name"), rs.getInt("counter"));
        }

        return map;
    }

    public Map<String, Integer> findAllUsers() throws SQLException {
        Map<String, Integer> map = new HashMap<>();

//        findUserByName.setString(1, user);user

        psFindUsers.execute();

        ResultSet rs = psFindUsers.executeQuery();
//        System.out.println("ResultSet: " + rs);

        while (rs.next()) {
            //add user to map => {name=3, Unalo=2}
            map.put(rs.getString("name"), rs.getInt("counter"));
        }

        return map;
    }
}

