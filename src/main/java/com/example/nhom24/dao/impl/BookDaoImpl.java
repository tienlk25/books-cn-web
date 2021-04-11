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

    @Override
    public Book findById(Integer id) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DBConfig.getConnection();
        String SQL_QUERY = "select * from book where id = " + id;
        PreparedStatement pst = con.prepareStatement(SQL_QUERY);
        ResultSet rs = pst.executeQuery();
        Book book = new Book();
        while (rs.next()) {
            book = getBook(rs);
        }
        return book;
    }

    @Override
    public void updateBook(Book book) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DBConfig.getConnection();
        String SQL_QUERY = "update book set name = '" + book.getName() + "', publisher = '" + book.getPublisher() + "' , price = " + book.getPrice() + " where id = " + book.getId() + ";";
        PreparedStatement ps = con.prepareStatement(SQL_QUERY);
        ps.executeUpdate();
        System.out.println(SQL_QUERY);
    }

    @Override
    public void delete(Integer id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DBConfig.getConnection();
        String SQL_QUERY = "DELETE from book where id = " + id;
        PreparedStatement ps = con.prepareStatement(SQL_QUERY);
        ps.executeUpdate();
        System.out.println(SQL_QUERY);
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
