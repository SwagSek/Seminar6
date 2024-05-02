package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.Repo.ICourseRepo;
import lv.venta.Repo.IGradeRepo;
import lv.venta.Repo.IStudentRepo;
import lv.venta.model.Grade;
import lv.venta.service.IGradeFilterService;

@Service
public class GradeFilterServiceImpl implements IGradeFilterService{

	@Autowired
	IGradeRepo gradeRepo;
	
	@Autowired
	IStudentRepo studentRepo;
	
	@Autowired
	ICourseRepo courseRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentID(int id) throws Exception {
		if(id <= 0) throw new Exception("Invalid ID");
		if(!studentRepo.existsById(id)) throw new Exception("Student with given ID does not exist.");
		
		ArrayList<Grade> result = gradeRepo.findByStudentIdS(id);
		if(result.isEmpty()) throw new Exception("Student with given ID has no grades.");
		return result;
	}

	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {
		ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
		if(result.isEmpty()) throw new Exception("No failed grades found.");
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseByID(int id) throws Exception {
		if(id <= 0) throw new Exception("Invalid ID");
		if(!courseRepo.existsById(id)) throw new Exception("Course with given ID does not exist.");
	
		float result = gradeRepo.calculateAvgGradeByIdCFromDB(id);
		if (result == 0) throw new Exception("There are no grades in this course.");
		return result;
	}

	
}
