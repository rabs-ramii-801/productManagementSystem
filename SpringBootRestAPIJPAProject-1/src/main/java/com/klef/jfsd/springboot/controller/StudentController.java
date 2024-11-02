package com.klef.jfsd.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.service.StudentService;

@RestController
//@RequestMapping("student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String home() {
		return "Spring Boot Rest API Object";
	}
	
	@PostMapping("add")
	public String addStudent(@RequestBody Student s)
	{
		return service.addStudent(s);
	}
	
	@GetMapping("viewall")
	public List<Student> viewallStudents()
	{
		return service.viewallstudents();
	}
	
	@GetMapping("display")
	public Student displaystudent(@RequestParam("id")  int sid)
	{
		return service.viewStudentbyid(sid);
	}
	
	@DeleteMapping("delete")
	public String deleteStudent(@RequestParam("id") int sid)
	{
		return service.deleteStudent(sid);
	}
	
	@PutMapping("update")
	public String updatestudent(@RequestBody Student s)
	{
		return service.updateStudent(s);
	}
	
	
	

}
