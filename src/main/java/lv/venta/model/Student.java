package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Table(name = "StudentTable")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student extends Person{
	
	@Column(name = "IdS")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idS;
	
	@OneToMany(mappedBy = "student")
	@ToString.Exclude
	public Collection<Grade> grade;
	
	public Student(String name, String surname) {
		super(name, surname);
	}
}
