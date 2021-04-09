package com.example.nhom24.dao;

import com.example.nhom24.model.User;

import java.sql.SQLException;

public interface UserDao {
    User getUserByUserName(String username) throws SQLException, ClassNotFoundException;
}
