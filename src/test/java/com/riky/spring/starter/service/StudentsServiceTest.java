package com.riky.spring.starter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.riky.spring.starter.StudentsService;
import com.riky.spring.starter.entity.Student;
import com.riky.spring.starter.model.StudentSearchOutput;
import com.riky.spring.starter.model.StudentSearchParams;

@RunWith(SpringRunner.class)
@SpringBootTest
class StudentsServiceTest {
	
	private static Student student;

    @Autowired
    StudentsService service;
    
	
	@Test
	void testInsertStudent() {
		Student toBeInserted = new Student();
		student = toBeInserted;
		Student inserted = service.insertStudent(toBeInserted);
		
		assertNotNull(inserted);
		assertEquals(toBeInserted, inserted);
	}
	
	@Test
	void testGetStudents() {
		String studentName = "Riccardo";
		
		Student toBeInserted = new Student();
		toBeInserted.setName(studentName);
		
		service.insertStudent(toBeInserted);
		student = toBeInserted;
		
		StudentSearchParams params = new StudentSearchParams(studentName, null);
		StudentSearchOutput result = service.getStudents(params, PageRequest.of(0, 3));
		
		assertNotNull(result);
		assertEquals(result.getTotalCount(), 1);
		assertEquals(result.getData().get(0).getName(), studentName);
	}
	
	@AfterEach
	void cleanupStudent() {
		service.deleteStudent(student);
	}
}
