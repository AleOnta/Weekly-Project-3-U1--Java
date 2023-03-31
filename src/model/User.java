package model;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter 
public class User {
	
	@Setter
	private String name;
	@Setter
	private String lastname;
	@Setter
	private LocalDate birthdate;
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_generator")
	@SequenceGenerator(name = "card_generator", sequenceName = "card_seq", allocationSize = 50)
	@Column(name = "user_card_id")
	private Long cardId;
	
	public User() {
		super();
	}
	
	public User(String name, String lastname, LocalDate birthdate) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}
	
}
