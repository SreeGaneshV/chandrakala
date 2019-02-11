package main.java.com.ganesh.dao;

import java.util.List;

import main.java.com.ganesh.model.Student;
   


public interface StudentDao {
	public void add(Student student);
	public void edit(Student student);
	public void delete(int studentId);
	public Student getStudent(int studentId);
	public List getAllStudent();
}
