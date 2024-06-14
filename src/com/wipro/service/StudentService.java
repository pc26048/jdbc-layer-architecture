package com.wipro.service;

import java.sql.SQLException;
import java.util.List;

import com.wipro.model.Student;

public interface StudentService {
	
	void addStudent(Student student) throws SQLException,ClassNotFoundException;
	void deleteStudent(int id) throws SQLException,ClassNotFoundException;
	void updateStudent(int id,Student student) throws SQLException,ClassNotFoundException;
	List<Student>getAllStudents() throws SQLException,ClassNotFoundException;
	Student getStudent(int id) throws SQLException,ClassNotFoundException;
	
	

}
