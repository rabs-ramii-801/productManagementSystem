package com.klef.jfsd.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Student;
import com.klef.jfsd.springboot.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository repository;

	@Override
	public String addStudent(Student s) {
		// TODO Auto-generated method stub
		repository.save(s);
		return "Student Added Successfully";
	}

	@Override
	public String updateStudent(Student s) {
		// TODO Auto-generated method stub
		Optional<Student> object=repository.findById(s.getId());
		String msg=null;
		
		if(object.isPresent())
		{
			Student student = object.get();
			student.setAge(s.getAge());
			student.setContact(s.getContact());
			student.setDepartment(s.getDepartment());
			student.setEmail(s.getEmail());
			student.setGender(s.getGender());
			student.setName(s.getName());
			
			repository.save(student);
			
			msg="Student Updated Succesfully";
		}
		else
		{
			msg="ID not Found";
		}
		
		return msg;
		
	}

	@Override
	public String deleteStudent(int sid) {
		// TODO Auto-generated method stub
		Optional<Student> object=repository.findById(sid);
		String msg=null;
		
		if(object.isPresent())
		{
			Student s = object.get();
			repository.delete(s);
			msg="Student Added Succesfully";
		}
		else {
			msg="ID not found";
		}
		return msg;
		
	}

	@Override
	public Student viewStudentbyid(int sid) {
		// TODO Auto-generated method stub
		return repository.findById(sid).get();
		
	}

	@Override
	public List<Student> viewallstudents() {
		// TODO Auto-generated method stub
		
		return (List<Student>) repository.findAll();
	}

}
