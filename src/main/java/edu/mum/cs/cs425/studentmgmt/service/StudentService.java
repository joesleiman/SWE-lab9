package edu.mum.cs.cs425.studentmgmt.service;

import java.util.List;

import edu.mum.cs.cs425.studentmgmt.model.Student;

public interface StudentService {
	List<Student> getAllStudents();
	Student save(Student s);
	Student getStudentById(long id);
	void delete(Long id);
}
