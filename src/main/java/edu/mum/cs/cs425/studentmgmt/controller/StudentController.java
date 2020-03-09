package edu.mum.cs.cs425.studentmgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/eregistrar/student/list", method = RequestMethod.GET)
	public ModelAndView students() {
		List<Student> students = studentService.getAllStudents();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("students", students);
		modelAndView.setViewName("student/list");
		return  modelAndView;
	}
	
	 @GetMapping(value = {"eregistrar/student/new"})
	    public String displayNewStudentForm(Model model) {
	        model.addAttribute("student", new Student());
	        return "student/new";
	    }

	    @PostMapping(value = {"eregistrar/student/new"})
	    public String addNewBook(@Valid @ModelAttribute("student") Student student,
	                                     BindingResult bindingResult, Model model) {
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("errors", bindingResult.getAllErrors());
	            return "student/new";
	        }
	        student = studentService.save(student);
	        return "redirect:/eregistrar/student/list";
	    }

		@GetMapping(value = { "eregistrar/student/edit/{studentId}" })
		public String editStudent(@PathVariable Long studentId, Model model) {
			Student student = studentService.getStudentById((studentId));
			if (student != null) {
				model.addAttribute("student", student);
				return "student/edit";
			}
			return "student/list";
		}

		@PostMapping(value = { "/eregistrar/student/edit" })
		public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult,
				Model model) {
			if (bindingResult.hasErrors()) {
				model.addAttribute("errors", bindingResult.getAllErrors());
				return "student/edit";
			}
			student = studentService.save(student);
			return "redirect:/eregistrar/student/list";
		}

		@RequestMapping(value = "eregistrar/student/delete/{id}", method = RequestMethod.GET)
		public String delete(@PathVariable Long id, Model model) {
			studentService.delete(id);
			return "redirect:/eregistrar/student/list";
		}
}
