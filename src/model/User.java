package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@NamedQuery(name = "User.getAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	
	@Id 	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long cardId;
	private String name;
	private String lastname;
	private LocalDate birthdate;
	//@OneToMany(mappedBy = "onLoanTo", cascade = CascadeType.ALL)
	//private Set<Loan> userLoans;
	
	
	public User() {
		super();
	}
	
	public User(String name, String lastname, LocalDate birthdate) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	/*public Set<Loan> getUserLoans() {
		return userLoans;
	}

	public void setUserLoans(Set<Loan> userLoans) {
		this.userLoans = userLoans;
	}*/

	public Long getCardId() {
		return cardId;
	}
	
}
