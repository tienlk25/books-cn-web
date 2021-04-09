package com.example.nhom24.dao;

import com.example.nhom24.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {
    List<Book> findByName(String name) throws ClassNotFoundException, SQLException;
}
