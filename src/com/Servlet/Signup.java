package com.Servlet;

import com.DAO.StudentDAO;
import com.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Signup")
public class Signup  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("fName");
        String address = request.getParameter("address");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        Student student = new Student(name,address,userName,password);
        StudentDAO studentDAO = new StudentDAO();

        String message = studentDAO.addStudent(student);

        RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
        request.setAttribute("message", message);
        rd.include(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
