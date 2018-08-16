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
import java.util.ArrayList;

@WebServlet("/DisplayStudent")
public class DisplayStudent extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Student> students = new ArrayList<>();
        StudentDAO studentDAO = new StudentDAO();

        studentDAO.getStudent(students);

        System.out.println(students);
        RequestDispatcher rs = request.getRequestDispatcher("display.jsp");
        request.setAttribute("studentList", students);

        rs.forward(request,response);



    }
}
