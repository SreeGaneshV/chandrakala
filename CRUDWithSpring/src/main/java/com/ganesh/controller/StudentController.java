package main.java.com.ganesh.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import main.java.com.ganesh.model.Student;
import main.java.com.ganesh.service.StudentService;

   //hdsbjbcvbvc

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map){
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam int action, Map<String, Object> map)
	{
		Student studentResult = new Student();
		switch(action)
		{	
		//only in Java7 you can put String in switch
		case 1:
			studentService.add(student);
			studentResult = student;
			break;
		case 2:
			studentService.edit(student);
			studentResult = student;
			break;
		case 3:
			studentService.delete(student.getStudentId());
			studentResult = new Student();
			break;
		case 4:
			Student searchedStudent = studentService.getStudent(student.getStudentId());
			studentResult = searchedStudent!=null ? searchedStudent : new Student();
			break;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
}
