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

@WebServlet("/delete")
public class DeleteStudent extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id =Integer.parseInt(request.getParameter("id"));

        StudentDAO studentDAO = new StudentDAO();
        Student student = studentDAO.getStudent(id);
        String message = studentDAO.deleteStudent(student);

        RequestDispatcher rd = request.getRequestDispatcher("DisplayStudent");
        request.setAttribute("message", message);
       rd.forward(request,response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
