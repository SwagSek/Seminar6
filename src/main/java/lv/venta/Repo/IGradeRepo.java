package lv.venta.Repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer>{

	ArrayList<Grade> findByStudentIdS(int id);

	ArrayList<Grade> findByGrvalueLessThan(int i);
	
	@Query(nativeQuery = true, value = "SELECT AVG(GRVALUE) FROM GRADE_TABLE WHERE IDC?=1")
	float calculateAvgGradeByIdCFromDB(int idC);

}
