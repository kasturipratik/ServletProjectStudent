package com.Servlet;

import com.DAO.StudentDAO;
import com.DAO.nameSorting;
import com.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;


/**
 * Displaying all the list of students from the database
 */
@WebServlet("/DisplayStudent")
public class DisplayStudent extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Student> students = new ArrayList<>();
        StudentDAO studentDAO = new StudentDAO();

        studentDAO.getStudent(students);
        //sorting the data using name of the person

        RequestDispatcher rs = request.getRequestDispatcher("display.jsp");
        //sorting the list of students using their name
        Collections.sort(students,new nameSorting());
        request.setAttribute("studentList", students);

        rs.forward(request,response);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
