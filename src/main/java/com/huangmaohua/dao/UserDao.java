package com.huangmaohua.dao;

import com.huangmaohua.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //insert-into-usertable
        String sql="INSERT INTO USERTABLE(username,password,email,gender,birthdate) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement= con.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getGender());
        preparedStatement.setDate(5, user.getBirthdate());
        int rs =preparedStatement.executeUpdate();
        return rs > 0;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //delete--where id=?
        String sql="delete from usertable where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setLong(1,user.getId());
        int rs = preparedStatement.executeUpdate();
        if(rs>0){
            return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //update--where id=?
        String sql="update usertable set username=?,password=?,email=?,gender=?,birthdate=? where id=?";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, user.getUsername());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getGender());
        preparedStatement.setDate(5,user.getBirthdate());
        preparedStatement.setLong(6,user.getId());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        //select--where id=?
        return null;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql ="SELECT* FROM USERTABLE WHERE USERNAME=?AND PASSWORD=?";
        PreparedStatement st =con.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs =st.executeQuery();
        User user = null;
        if(rs.next()){
            user= new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        return null;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        return null;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        return null;
    }
}
