package model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Article-Mag")
public class Magazine extends Article {
	
	@Enumerated(EnumType.STRING)
	@Column(name = "m_periodicity")
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

	public E_Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(E_Periodicity periodicity) {
		this.periodicity = periodicity;
	}
	
}
