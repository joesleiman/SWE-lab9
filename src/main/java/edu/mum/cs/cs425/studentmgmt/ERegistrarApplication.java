package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;

@SpringBootApplication
public class ERegistrarApplication implements CommandLineRunner{

	@Autowired
	private StudentService studentService;
	
	public static void main(String[] args) {
		SpringApplication.run(ERegistrarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		create 5 students
		Student s1 = new Student(610721L, "Joe", "Sleiman", 3.78f, LocalDate.of(2019,11, 1), true);
		Student s2 = new Student(610722L, "Chady", "Sleiman", 3.28f, LocalDate.of(2019,11, 1), true);
		Student s3 = new Student(610723L, "Margot", "Sleiman", 3.88f, LocalDate.of(2019,11, 1), true);
		Student s4 = new Student(610724L, "Ghinwa", "Sleiman", 3.08f, LocalDate.of(2019,11, 1), true);
		Student s5 = new Student(610725L, "Sara", "Sleiman", 2.98f, LocalDate.of(2019,11, 1), false);
		
		Student[] students = {s1, s2, s3, s4, s5};
		for(Student s : students) {
			studentService.save(s);
		}
		
	}

}
