package lv.venta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.service.IGradeFilterService;

@Controller
@RequestMapping("/grade/filter")
public class GradeFilterController {

	@Autowired
	IGradeFilterService gradeService;
	
	@GetMapping("/idS/{param}")
	public String getGradesFilterByStudentId(@PathVariable("param") int id, Model model) {
		try {
			model.addAttribute("mydata", gradeService.selectGradesByStudentID(id));
			model.addAttribute("msg", "Grades filtered by Student ID");
			return "grade-all-show-page";
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/failed")
	public String getGradesFilterByFailed(Model model) {
		try {
			model.addAttribute("mydata", gradeService.selectFailedGrades());
			model.addAttribute("msg", "Grades filtered by failed");
			return "grade-all-show-page";
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";
		}
	}
	
	@GetMapping("/avg/{param}")
	public String getAvgGradeInCourse(@PathVariable("param") int id, Model model) {
		try {
			model.addAttribute("mydata", gradeService.calculateAVGGradeInCourseByID(id));
			model.addAttribute("msg", "Average grade for course");
			return "display-value";
		} catch (Exception e) {
			model.addAttribute("errormsg", e.getMessage());
			return "error-page";
		}
	}
}
