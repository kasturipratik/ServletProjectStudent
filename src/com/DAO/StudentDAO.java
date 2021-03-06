package com.DAO;

import com.JDBC.MyConnection;
import com.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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

        try {
            ps = connection.prepareStatement("insert into student values(?,?,?,?,?)");
            ps.setInt(1,student.getId());
            ps.setString(2,student.getName());
            ps.setString(3,student.getAddress());
            ps.setString(4,student.getUserName());
            ps.setString(5,student.getPassword());
             int x = ps.executeUpdate();
             if(x >0){
                 return "New Registration SuccessFul for "+ student.getName();
             }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "Registration Failed";
    }

    /**
     *  Deleting the student from the database
     * @param student
     * @returnthe message of the deletion success
     */
    public String deleteStudent(Student student){
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement("delete from student where id =?");
            ps.setInt(1,student.getId());
            int x = ps.executeUpdate();
            if(x > 0){
                return "Student " + student.getName() + " deleted from the database.";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Student delete failed";
    }

    /**
     * get the student using the id  received from the edit button to update it later
     * @param id
     * @return student
     */
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

    /**
     * Update the student to the database
     * @param student
     * @return
     */
    public String updateStudent(Student student){
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = null;


        try {
            ps = connection.prepareStatement(
                    "update student set name= ?, address =?, username =?, password =? where id =? ");
            ps.setString(1,student.getName());
            ps.setString(2,student.getAddress());
            ps.setString(3,student.getUserName());
            ps.setString(4,student.getPassword());
            ps.setInt(5,student.getId());

            int x = ps.executeUpdate();
            if(x > 0){
                return "Update Successful for " + student.getName();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Update Cannot be performed";
    }

    public int returnMaxId()  {
        Connection connection = MyConnection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        int num = 99;

        try {
            ps = connection.prepareStatement(" SELECT * FROM student ORDER BY id DESC LIMIT 0, 1");
           rs = ps.executeQuery();

            if(rs.next()){
            num  = rs.getInt("id");
                System.out.println(num);
            return num + 1 ;
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return num+1;

    }

}

