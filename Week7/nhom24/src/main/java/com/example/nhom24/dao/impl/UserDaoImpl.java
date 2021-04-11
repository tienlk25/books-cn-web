package com.example.nhom24.dao.impl;

import com.example.nhom24.config.DBConfig;
import com.example.nhom24.dao.UserDao;
import com.example.nhom24.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    public User getUserByUserName(String username) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DBConfig.getConnection();
        String SQL_QUERY = "select * from user where username = '" + username + "'";
        PreparedStatement pst = con.prepareStatement(SQL_QUERY);
        ResultSet rs = pst.executeQuery();
        if(rs.next()){
            return getUser(rs);
        }
        return null;
    }

    private User getUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        return user;
    }
}
