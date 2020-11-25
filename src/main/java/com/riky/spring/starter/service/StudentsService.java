package com.riky.spring.starter.service;

import com.riky.spring.starter.model.StudentSearchOutput;
import com.riky.spring.starter.model.StudentSearchParams;
import com.riky.spring.starter.model.business.Student;

public interface StudentsService {
	
	Student insertStudent(Student student);
	
	StudentSearchOutput getStudent(StudentSearchParams student);
}
