package lv.venta.Repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer>{

}
