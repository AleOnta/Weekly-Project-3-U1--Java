package model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "magazines")
@Getter @Setter
public class Magazine extends Article {
	
	@Enumerated(EnumType.STRING)
	private E_Periodicity periodicity;

	public Magazine() {
		super();
	}

	public Magazine(String title, Integer releaseYear, Integer numberOfPage, E_Periodicity periodicity) {
		super(title, releaseYear, numberOfPage);
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "Magazine [" + super.toString() + ", periodicity=" + periodicity + "]";
	}
	
	
	
}
