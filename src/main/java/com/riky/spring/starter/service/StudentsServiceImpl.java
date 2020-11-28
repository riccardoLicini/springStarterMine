package com.riky.spring.starter.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.riky.spring.starter.StudentsService;
import com.riky.spring.starter.entity.Student;
import com.riky.spring.starter.model.StudentSearchOutput;
import com.riky.spring.starter.model.StudentSearchParams;

@Service
public class StudentsServiceImpl implements StudentsService {
	
	@Autowired
	private MongoTemplate mongo;

	@Override
	public Student insertStudent(Student student) {
		mongo.insert(student);
		return student;
	}

	@Override
	public StudentSearchOutput getStudents(StudentSearchParams params) {
		String nome = params.getName();
		List<Student> students = mongo.find(query(where("name").is(nome)), Student.class);
		
		StudentSearchOutput output = new StudentSearchOutput();
		output.setData(students);
		output.setTotalCount(students.size());
		return output;
	}

	@Override
	public Student deleteStudent(Student student) {
		mongo.remove(student);
		
		return student;
	}

}
