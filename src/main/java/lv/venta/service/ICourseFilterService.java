package lv.venta.service;

import java.util.ArrayList;

import lv.venta.model.Course;

public interface ICourseFilterService {
	public ArrayList<Course> selectCoursesByCP(int cp) throws Exception;
	public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception;
	public ArrayList<Course> selectCoursesByProfessorId(int id) throws Exception;
}
