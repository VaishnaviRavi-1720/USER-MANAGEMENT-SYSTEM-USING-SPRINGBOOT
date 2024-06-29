package com.web.service;

import java.util.List;

import com.web.entity.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public Student getOneStudent(int sid);
	public void  deleteStudent(int sid);
	public List<Student> getAllStudent();
	public Student updateStudent(Student student);

}
