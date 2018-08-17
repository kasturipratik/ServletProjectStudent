package com.DAO;

import com.model.Student;

import java.util.Comparator;

/**
 * sorting data using name of the student
 */
public class nameSorting implements Comparator<Student> {
    public int compare(Student a, Student b){
        return a.getName().compareTo(b.getName());
    }
}
