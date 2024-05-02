package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.ICourseFilterService;

@Controller
@RequestMapping("/course/filter")
public class CourseFilterController {
	
	@Autowired
	private ICourseFilterService courseService;
	
	@GetMapping("/cp/{param}")
	public String getCourseFilterByCp(@PathVariable("param") int cp, Model model) {
		try {
			model.addAttribute("mydata", courseService.selectCoursesByCP(cp));
			model.addAttribute("msg", "Courses filtered by creditpoints");
			return "course-all-show-page";
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/idS/{param}")
	public String getCourseFilterByStudentId(@PathVariable("param") int id, Model model) {
		try {
			model.addAttribute("mydata", courseService.selectCoursesByStudentId(id));
			model.addAttribute("msg", "Courses filtered by Student ID");
			return "course-all-show-page";
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/idP/{param}")
	public String getCourseFilterByProfessorId(@PathVariable("param") int id, Model model) {
		try {
			model.addAttribute("mydata", courseService.selectCoursesByProfessorId(id));
			model.addAttribute("msg", "Courses filtered by Professor ID");
			return "course-all-show-page";
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";
		}
	}
}
