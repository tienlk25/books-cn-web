package com.example.nhom24.controller;

import com.example.nhom24.dao.BookDao;
import com.example.nhom24.dao.impl.BookDaoImpl;
import com.example.nhom24.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/detail")
public class BookDetailController extends HttpServlet {
    private final BookDao bookDao;
    private Book book;

    public BookDetailController(){
        bookDao = new BookDaoImpl();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("bookId");
        try {
            book = bookDao.findById(Integer.parseInt(id));
            req.setAttribute("book", book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("detail.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String publisher = req.getParameter("publisher");
        Integer price = Integer.valueOf(req.getParameter("price"));
//        book
        try {
            book.setName(name);
            System.out.println(name);
            book.setPublisher(publisher);
            book.setPrice(price);
            bookDao.updateBook(book);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        RequestDispatcher dp = req.getRequestDispatcher("home.jsp");
        dp.forward(req, resp);
    }

}
