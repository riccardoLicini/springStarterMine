package com.riky.spring.starter.rest;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.riky.spring.starter.StudentsService;
import com.riky.spring.starter.entity.Student;
import com.riky.spring.starter.model.EducationLevel;
import com.riky.spring.starter.model.StudentSearchOutput;
import com.riky.spring.starter.model.StudentSearchParams;

@RestController
@RequestMapping("/ex-1")
public class StudentsEndpoint {

	@Autowired
	private StudentsService service;

	@PostMapping(path = "/alumni", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void postStudent(@Valid @RequestBody Student student) {
		
		service.insertStudent(student);
	}

	@GetMapping(path = "/alumni", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StudentSearchOutput> postStudent(
			@RequestParam(name = "name", required = false) String name,
			@RequestParam(name = "educationLevel", required = false) EducationLevel educationLevel,
			@RequestParam(name = "page", required = false, defaultValue = "1") int page) {
		
		StudentSearchOutput students = service.getStudents(new StudentSearchParams(name, educationLevel), 
				new PageRequest(Math.max(0, page - 1), 3))
//				PageRequest.of(Math.max(0, page - 1), 3))
;

		return ResponseEntity.status(students.getTotalCount() == 0 ? HttpStatus.NO_CONTENT : HttpStatus.OK)
				.body(students);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
