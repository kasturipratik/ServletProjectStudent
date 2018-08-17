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

@WebServlet("/edit")
public class UpdateForm extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAO studentDAO = new StudentDAO();

        Student studentProfile = studentDAO.getStudent(id);

        request.setAttribute("student", studentProfile);

        RequestDispatcher rs = request.getRequestDispatcher("signup.jsp");
        rs.include(request,response);

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
