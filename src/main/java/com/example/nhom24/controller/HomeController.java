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
import java.util.List;

@WebServlet("/home")
public class HomeController extends HttpServlet {

    private final BookDao bookDao;

    public HomeController() {
        bookDao = new BookDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
        dispatcher.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("book");
        try {
            List<Book> books = bookDao.findByName(bookName);
            if(books != null){
                RequestDispatcher dp = req.getRequestDispatcher("result.jsp");
                req.setAttribute("search", bookName);
                req.setAttribute("books", books);
                dp.forward(req, resp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
