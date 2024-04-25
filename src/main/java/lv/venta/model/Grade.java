package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "GradeTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Grade {
	
	@Column(name = "IdG")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	public int idG;
	
	@Column(name = "Gralue")
	@Min(0)
	@Max(10)
	public int gralue;
	
	@ManyToOne
	@JoinColumn(name = "IdS")
	public Student student;
	
	@ManyToOne
	@JoinColumn(name="IdC")
	public Course course;
	
	public Grade(Student student, Course course, int grvalue) {
		setStudent(student);
		setCourse(course);
		setGralue(grvalue);
	}
}
