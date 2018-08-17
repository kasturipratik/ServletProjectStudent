package com.DAO;

import com.JDBC.MyConnection;
import com.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAO {

    /**
     * method to get all the students from the database
     * @param list
     * @return list of studetns from the database
     */
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

    /**
     * This method gets the data from the form and stores it into the database
     * @param student
     * @return registration result
     */
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

    /**
     * Deleting the student from the database
     * @param id
     * @return the message of the deletion success
     */
    public String deleteStudent(int id){
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("delete from student where id =?");
            ps.setInt(1,id);
            int x = ps.executeUpdate();
            if(x > 0){
                return "Student just deleted";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Student delete failed";
    }

    public Student getStudent(int id){

        Student student = null;
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("select * from student where id =?");
            ps.setInt(1,id);

            ResultSet resultSet = ps.executeQuery();

            if(resultSet.next()){
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                student = new Student(id, name,address,userName,password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return student;
    }
}
