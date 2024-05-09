package lv.venta.Repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

	ArrayList<Course> findByCp(int cp);

	ArrayList<Course> findByProfessorsIdP(int id);

	ArrayList<Course> findByGradesStudentIdS(int id);

}
