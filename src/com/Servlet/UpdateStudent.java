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

@WebServlet("/update")
public class UpdateStudent extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("fName");
        String address = request.getParameter("address");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        Student student = new Student(id,name, address, userName, password);
        StudentDAO studentDAO = new StudentDAO();

        String updatedMessage = studentDAO.updateStudent(student);

        RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
        request.setAttribute("message",updatedMessage);
        rd.forward(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
