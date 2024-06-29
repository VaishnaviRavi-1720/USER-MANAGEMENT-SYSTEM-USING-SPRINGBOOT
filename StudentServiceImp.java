package com.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.entity.Student;
import com.web.repo.StudentRepo;
@Service
public class StudentServiceImp implements StudentService {
	@Autowired
	private StudentRepo repo;

	@Override
	public Student saveStudent(Student student) {
		int tot=0;
		double per=0.0;
		String g=null,res=null;
		tot=student.getHtml()+student.getHibername()+student.getSpring()+student.getSpringboot();
		per=tot/4;
		if(per>=70) {
			g="A grade";
		}
		else if(per>=60) {
			g="B grade";
		}
		else if(per>=50) {
			g="C grade";
		}
		if(student.getHtml()>=35&&student.getHibername()>=35&&student.getSpring()>=35&& student.getSpringboot()>=35)
		{
			res="pass";
		}
		student.setTotal(tot);
		student.setPercentage(per);
		student.setGrade(g);
		student.setResult(res);
		Student saveStudent=repo.save(student);
		return saveStudent;
	}

	@Override
	public Student getOneStudent(int sid) {
		return repo.findById(sid).get();
	}

	@Override
	public void deleteStudent(int sid) {
		repo.deleteById(sid);

	}

	@Override
	public List<Student> getAllStudent() {
		
		return repo.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		int tot=0;
		double per=0.0;
		String g=null,res=null;
		tot=student.getHtml()+student.getHibername()+student.getSpring()+student.getSpringboot();
		per=tot/4;
		if(per>=70) {
			g="A grade";
		}
		else if(per>=60) {
			g="B grade";
		}
		else if(per>=50) {
			g="C grade";
		}
		if(student.getHtml()>=35&&student.getHibername()>=35&&student.getSpring()>=35&& student.getSpringboot()>=35)
		{
			res="pass";
		}
		student.setTotal(tot);
		student.setPercentage(per);
		student.setGrade(g);
		student.setResult(res);
		Student saveStudent=repo.save(student);
		return saveStudent;
	}

}
