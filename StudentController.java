package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.entity.Student;
import com.web.service.StudentServiceImp;

@Controller
public class StudentController {
	@Autowired
	private StudentServiceImp service;
	@RequestMapping("/home")
	public String displayHomePage() {
		return "home";
	}
	@RequestMapping("/addStudent")
	public String displayRegisterForm() {
		return "register";
	}
	@RequestMapping("/submit")
	public String submitRegister(Student student,ModelMap model) {
		service.saveStudent(student);
		return "success";
	}
	@RequestMapping("/viewAllStudent")
	public String displayAllStudents(ModelMap model) {
		model.put("students", service.getAllStudent());
		return "viewstudentpage";
	}
	@RequestMapping("/deleteUrl/{sid}")
	public String deleteStudent(@PathVariable int sid) {
		service.deleteStudent(sid);
		return "redirect:/viewAllStudent";
	}
	@RequestMapping("/editUrl/{sid}")
	public String editStudentForm(@PathVariable int sid,ModelMap model) {
		model.put("command", service.getOneStudent(sid));
		return "editstudentpage";
	}
	@RequestMapping("/editandsave")
	public String editAndSaveForm(Student student) {
		service.updateStudent(student);
		return "redirect:/viewAllStudent";
	}

}
