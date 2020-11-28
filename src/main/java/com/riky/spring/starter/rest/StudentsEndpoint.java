package com.riky.spring.starter.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riky.spring.starter.StudentsService;
import com.riky.spring.starter.entity.Student;
import com.riky.spring.starter.model.StudentSearchOutput;
import com.riky.spring.starter.model.StudentSearchParams;

@RestController
@RequestMapping("/ex-1")
public class StudentsEndpoint {
	
	@Autowired
	private StudentsService service;
	
	@PostMapping(path = "/alumni", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postStudent(Student student) {
		service.insertStudent(student);
	}
	
	@GetMapping(path = "/alumni", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentSearchOutput> postStudent(@RequestParam("name") String name) {
		StudentSearchOutput students = service.getStudents(new StudentSearchParams(name));
		
		return ResponseEntity
				.status(students.getTotalCount() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK)
				.body(students);
	}
}
