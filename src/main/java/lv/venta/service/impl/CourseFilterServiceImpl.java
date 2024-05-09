package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.Repo.ICourseRepo;
import lv.venta.Repo.IProfessorRepo;
import lv.venta.Repo.IStudentRepo;
import lv.venta.model.Course;
import lv.venta.service.ICourseFilterService;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService{

	@Autowired
	private ICourseRepo courseRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Autowired
	private IStudentRepo studentRepo;
	
	@Override
	public ArrayList<Course> selectCoursesByCP(int cp) throws Exception {
		if(cp < 0 || cp > 20) throw new Exception("Invalid CP amount.");
		
		ArrayList<Course> result = courseRepo.findByCp(cp);
		if(result.isEmpty()) throw new Exception("Courses with given CP amount not found.");
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception {
		if(id <= 0) throw new Exception("Invalid ID.");
		if(!studentRepo.existsById(id)) throw new Exception("Student with given ID not found");
		
		ArrayList<Course> result = courseRepo.findByGradesStudentIdS(id);
		if(result.isEmpty()) throw new Exception("There are no courses for this student.");
		return result;
		
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(int id) throws Exception {
		if(id <= 0) throw new Exception("Invalid ID.");
		if(!profRepo.existsById(id)) throw new Exception("Professor with given ID not found");
		
		ArrayList<Course> result = courseRepo.findByProfessorsIdP(id);
		if(result.isEmpty()) throw new Exception("There are no courses for this professor.");
		return result;
	}

}
