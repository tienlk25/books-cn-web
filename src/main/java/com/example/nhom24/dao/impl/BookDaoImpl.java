package com.example.nhom24.dao.impl;

import com.example.nhom24.config.DBConfig;
import com.example.nhom24.dao.BookDao;
import com.example.nhom24.model.Book;
import com.example.nhom24.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public List<Book> findByName(String name) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DBConfig.getConnection();
        String SQL_QUERY = "select * from book where name like '%" + name + "%'";
        PreparedStatement pst = con.prepareStatement(SQL_QUERY);
        ResultSet rs = pst.executeQuery();
        List<Book> books = new ArrayList<>();
        while (rs.next()) {
            Book book = getBook(rs);
            books.add(book);
        }
        return books;
    }

    private Book getBook(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setName(rs.getString("name"));
        book.setId(rs.getInt("id"));
        book.setPublisher(rs.getString("publisher"));
        book.setPrice(rs.getInt("price"));
        return book;
    }
}
