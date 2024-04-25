package lv.venta.Repo;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Professor;

public interface IProfessorRepo extends CrudRepository<Professor, Integer>{

}
