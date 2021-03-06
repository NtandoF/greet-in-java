package net.greet;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import static java.sql.DriverManager.getConnection;

public class GreetedUsingJDBC implements Greeted {
    final String INSERT_USERS_SQL = "insert into users (name, counter) values(?, ?)";

    final String FIND_USERS_SQL = "select * from users";

    final String REMOVE_ONE_USER_SQL = "delete from users where name = ? ";

    final String FIND_ALL_USERS_SQL = "select count(*) as counter from users";

    final String FIND_USER_BY_NAME_SQL = "select * from users where name = ?";

    final String UPDATE_USERS_SQL = "update users set counter = counter + 1 where name = ?";


    Connection conn;
    PreparedStatement psCreateNewUsers;
    PreparedStatement psRemoveOneUser;
    PreparedStatement psFindAllUsers;
    PreparedStatement psFindUsers;
    PreparedStatement psUpdateUsersCount;
    PreparedStatement findUserByName;

    public GreetedUsingJDBC() {
        try {
            conn = getConnection("jdbc:h2:./target/greetings_db","sa", "");
            psCreateNewUsers = conn.prepareStatement(INSERT_USERS_SQL);
            psRemoveOneUser = conn.prepareStatement(REMOVE_ONE_USER_SQL);
            psFindUsers = conn.prepareStatement(FIND_USERS_SQL);
            psFindAllUsers = conn.prepareStatement(FIND_ALL_USERS_SQL);
            psUpdateUsersCount = conn.prepareStatement(UPDATE_USERS_SQL);
            findUserByName = conn.prepareStatement(FIND_USER_BY_NAME_SQL);

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public Map<String, Integer> greetedNames() {
        Map<String, Integer> map = new HashMap<>();
        try {
            PreparedStatement vp = conn.prepareStatement("select * from users");
            ResultSet rs = vp.executeQuery();
            while(rs.next()){
                map.put(rs.getString("name"), rs.getInt("counter")) ;
            }
            return map;
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return map;
    }


    @Override
    public String clearUser(String name) {
        try {
            psRemoveOneUser.setString(1, name);
            psRemoveOneUser.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "User deleted :-)";
    }


    @Override
    public String clearUsers() {

        try {
                    Statement statement = conn.createStatement();
                    statement.addBatch("delete from users");
                    statement.executeBatch();

            } catch(Exception ex) {
                System.out.println("These test will fail until the users table is created: " + ex);
            }
        return "Users was deleted :-)";
       }

    public void greeted(String name) {

        try {
            findUserByName.setString(1, name.toLowerCase());
            ResultSet rsCreateUser = findUserByName.executeQuery();

            if(rsCreateUser.next() == false) {

                psCreateNewUsers.setString(1, name.toLowerCase());
                psCreateNewUsers.setInt(2,1);
                psCreateNewUsers.execute();

            } else {

                psUpdateUsersCount.setString(1, name.toLowerCase());
                psUpdateUsersCount.executeUpdate();
            }


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public int counterForUser(String name) {
        Map<String, Integer> map = new HashMap<>();

        try {
            findUserByName.setString(1, name.toLowerCase());
            ResultSet rs = findUserByName.executeQuery();

            if(rs.next()) {
                map.put(rs.getString("name"), rs.getInt("counter"));
                System.out.println(map);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map.get(name.toLowerCase());
    }

    public int counter() {
        Map<String, Integer> map = new HashMap<>();

        try {
            psFindUsers.execute();

            ResultSet rs = psFindUsers.executeQuery();

            while (rs.next()) {

                map.put(rs.getString("name"), rs.getInt("counter"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map.size();
    }

    public String help(){
        return " Valid commands that you can use:\n" +
                "        greet : followed by your name and prefered language.\n" +
                "        greeted : to view all the people greeted.\n" +
                "        counter : to view how many people greeted. \n" +
                "        counterUser : to view how many times one person as been greeted. \n" +
                "        clearUser : to remove one person. \n" +
                "        clearUsers : to clear all people entered.";
    }


    public void exit(){
        System.exit(1);
    }
}

