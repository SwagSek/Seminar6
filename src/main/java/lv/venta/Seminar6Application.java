package lv.venta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.venta.Repo.ICourseRepo;
import lv.venta.Repo.IGradeRepo;
import lv.venta.Repo.IProfessorRepo;
import lv.venta.Repo.IStudentRepo;
import lv.venta.model.Course;
import lv.venta.model.Degree;
import lv.venta.model.Grade;
import lv.venta.model.Professor;
import lv.venta.model.Student;

@SpringBootApplication
public class Seminar6Application {

	public static void main(String[] args) {
		SpringApplication.run(Seminar6Application.class, args);
	}

	
	@Bean
	public CommandLineRunner testDatabaseLayer(IProfessorRepo profRepo, IStudentRepo stuRepo, ICourseRepo courseRepo, IGradeRepo grRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Student st1 = new Student("Janis", "Berzins");
				Student st2 = new Student("Baiba", "Jauka");
				stuRepo.save(st1);
				stuRepo.save(st2);
				
				Professor p1 = new Professor("Karina", "Skirmante", Degree.mg);
				Professor p2 = new Professor("Vairis", "Caune", Degree.phd);
				profRepo.save(p1);
				profRepo.save(p2);
				
				Course c1 = new Course("JAVA", 4, p1);
				Course c2 = new Course("Algoritmu Teorija", 4, p2);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				grRepo.save(new Grade(st1, c1, 8));
				grRepo.save(new Grade(st1, c2, 3));
				grRepo.save(new Grade(st2, c1, 9));
			}
		};
	}
}
