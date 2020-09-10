package com.springrestdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestdemo.entity.StudentErrorResponse;
import com.springrestdemo.entity.Students;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	List<Students> studentsList = new ArrayList<Students>();
	@PostConstruct
	public void setData() {
		studentsList.add(new Students("Sree", "Raj"));
		studentsList.add(new Students("Ram", "Krish"));
		studentsList.add(new Students("Deva", "XXX"));
	}

	@GetMapping("/students")
	public List<Students> getStudent(){
		return studentsList;
	}
	
	@GetMapping("/students/{studentId}")
	public Students getSpecificStudent(@PathVariable int studentId) {
		if(studentId>=studentsList.size() || studentId<0)
			throw new StudentNotFoundException("Student Id no found-" + studentId);
		return studentsList.get(studentId);
	}
}
