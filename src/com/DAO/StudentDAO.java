package com.DAO;

import com.JDBC.MyConnection;
import com.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

    public ArrayList<Student> getStudent(ArrayList<Student> list ){
    Connection connection = MyConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;

        try {
            ps = connection.prepareStatement("select * from student");
            rs = ps.executeQuery();


            while(rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                student.setName(rs.getString(2));
                student.setAddress(rs.getString(3));
                student.setUserName(rs.getString(4));
                student.setPassword(rs.getString(5));
                list.add(student);
            }
        return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }

    return null;
    }

    public String addStudent(Student student){
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("insert into student values(?,?,?,?,?)");
            ps.setInt(1,student.getId());
            ps.setString(2,student.getName());
            ps.setString(3,student.getAddress());
            ps.setString(4,student.getUserName());
            ps.setString(5,student.getPassword());
             int x = ps.executeUpdate();
             if(x >0){
                 return "Registration SuccessFul";
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Registration Failed";
    }
}
