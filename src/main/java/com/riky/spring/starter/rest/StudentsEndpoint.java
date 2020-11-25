package com.riky.spring.starter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riky.spring.starter.model.StudentSearchOutput;
import com.riky.spring.starter.model.StudentSearchParams;
import com.riky.spring.starter.model.business.Student;
import com.riky.spring.starter.service.StudentsService;

@RestController
@RequestMapping("/ex-1")
// ex1 endpoint...
public class StudentsEndpoint {
	
	@Autowired
	private StudentsService service;
	
	@PostMapping(path = "/alumni", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postStudent(Student student) {
		service.insertStudent(student);
	}
	
	@GetMapping(path = "/alumni", consumes = MediaType.APPLICATION_JSON_VALUE)
	public StudentSearchOutput postStudent(@RequestParam("name") String name) {
		return service.getStudent(new StudentSearchParams());
	}

}
