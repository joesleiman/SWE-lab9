package edu.mum.cs.cs425.studentmgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.studentmgmt.Repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll(); 
	}

	@Override
	public Student save(Student s) {
		return studentRepository.save(s);
	}

	@Override
	public Student getStudentById(long id) {
	return studentRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);
		
	}
	
}
