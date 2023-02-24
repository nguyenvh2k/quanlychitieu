package dao;


import database.PostgreJDBC;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public List<User> findAllUser() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = PostgreJDBC.getConnection();
            String sql_selectAll = "select * from users_qlct";
            PreparedStatement pst = connection.prepareStatement(sql_selectAll);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt(1);
                String username = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String firstname = rs.getString(5);
                String fullname = rs.getString(6);
                int gender = rs.getInt(7);
                String address = rs.getString(8);
                User user = new User(userId,username,email,password,firstname,fullname,gender,address);
                userList.add(user);
            }
            PostgreJDBC.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return userList;
    }

    public Boolean findByUsername(String username) {
        Boolean result = false;
        try {
            Connection connection = PostgreJDBC.getConnection();
            String sql_selectByUsername = "select * from users_qlct where username=?";
            PreparedStatement pst = connection.prepareStatement(sql_selectByUsername);
            pst.setString(1,username);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                result=true;
            }
            System.out.println(sql_selectByUsername);
            PostgreJDBC.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    public User findByUsernameAndPassword(User user) {
        User user1 = null;
        try {
            Connection connection = PostgreJDBC.getConnection();
            String sql_selectByUsername = "select * from users_qlct where username=? and password=?";
            PreparedStatement pst = connection.prepareStatement(sql_selectByUsername);
            pst.setString(1,user.getUsername());
            pst.setString(2,user.getPassword());
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt(1);
                String username = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String firstname = rs.getString(5);
                String fullname = rs.getString(6);
                int gender = rs.getInt(7);
                String address = rs.getString(8);
                user1 = new User(userId,username,email,password,firstname,fullname,gender,address);
            }
            System.out.println(sql_selectByUsername);
            PostgreJDBC.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user1;
    }
    public int insertUser(User user) {
        int result=0;
        try {
            Connection connection = PostgreJDBC.getConnection();
            String sql_insert = "insert into users_qlct(user_id,username,email,password," +
                    "firstname,fullname,gender,address)" +
                    "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.prepareStatement(sql_insert);
            pst.setInt(1,user.getUser_id());
            pst.setString(2,user.getUsername());
            pst.setString(3,user.getEmail());
            pst.setString(4,user.getPassword());
            pst.setString(5,user.getFirstname());
            pst.setString(6,user.getFullname());
            pst.setInt(7,user.getGender());
            pst.setString(8,user.getAddress());
            result=pst.executeUpdate();
            System.out.println(sql_insert);
            PostgreJDBC.closeConnection(connection);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
