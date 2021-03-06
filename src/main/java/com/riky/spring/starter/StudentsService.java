package com.riky.spring.starter;

import org.springframework.data.domain.PageRequest;

import com.riky.spring.starter.entity.Student;
import com.riky.spring.starter.model.StudentSearchOutput;
import com.riky.spring.starter.model.StudentSearchParams;

public interface StudentsService {
	
	Student insertStudent(Student student);
	
	StudentSearchOutput getStudents(StudentSearchParams params, PageRequest page);
	
	Student deleteStudent(Student student);
}
