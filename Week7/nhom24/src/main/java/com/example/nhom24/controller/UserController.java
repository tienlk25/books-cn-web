package com.example.nhom24.controller;

import com.example.nhom24.dao.UserDao;
import com.example.nhom24.dao.impl.UserDaoImpl;
import com.example.nhom24.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/login")
public class UserController extends HttpServlet {
    private final UserDao userDao;

    public UserController() {
        userDao = new UserDaoImpl();
    }
    String errs = "  ";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
        req.setAttribute("mes", errs);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        errs = "  ";
        req.setAttribute("mes", errs);
        super.service(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        try {
            User user = userDao.getUserByUserName(username);
            if (user != null && user.getPassword().equals(password)){
                resp.sendRedirect("/nhom24_war_exploded/home");
            } else {
//                out.println("<script type=\"text/javascript\">");
//                out.println("alert('User or password incorrect');");
//                out.println("</script>");
                errs ="username or password is incorrect!!";
                req.setAttribute("mes", errs);
                req.getRequestDispatcher("login.jsp").forward(req, resp);

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }


    }
}
