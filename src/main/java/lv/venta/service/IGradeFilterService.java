package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Grade;

public interface IGradeFilterService {
	public ArrayList<Grade> selectGradesByStudentID(int id) throws Exception;
	public ArrayList<Grade> selectFailedGrades() throws Exception;
	public float calculateAVGGradeInCourseByID(int id) throws Exception;
}
