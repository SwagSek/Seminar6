package lv.venta.Repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

}
