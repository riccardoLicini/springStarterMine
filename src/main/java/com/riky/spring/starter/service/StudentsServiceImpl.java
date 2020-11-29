package com.riky.spring.starter.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.riky.spring.starter.StudentsService;
import com.riky.spring.starter.entity.Student;
import com.riky.spring.starter.model.EducationLevel;
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
	public StudentSearchOutput getStudents(StudentSearchParams params, PageRequest page) {
		String name = params.getName();
		EducationLevel educationLevel = params.getEducationLevel();
		
		Query query = new Query();
		if (name != null && !name.isEmpty())
			query.addCriteria(where("name").is(name));
		
		if (educationLevel != null)  {
			switch (educationLevel) {
			case MASTER: {
				query.addCriteria(where("education.master").ne(null));
				break;
			}
				
			case PHD: {
				query.addCriteria(where("education.phd").ne(null));
				break;
			}

			case ANY:
				break;
			}
		}

		query.with(page);
		List<Student> students = mongo.find(query, Student.class);
		
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
