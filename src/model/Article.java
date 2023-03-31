package model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ISBNCode;
	@Setter
	private String title;
	@Setter
	private Integer releaseYear;
	@Setter
	private Integer numberOfPage;
	
	public Article() {
		super();
	}

	public Article(String title, Integer releaseYear, Integer numberOfPage) {
		super();
		this.title = title;
		this.releaseYear = releaseYear;
		this.numberOfPage = numberOfPage;
	}

	@Override
	public String toString() {
		return "ISBNCode=" + ISBNCode + ", title=" + title + ", releaseYear=" + releaseYear + ", numberOfPage="
				+ numberOfPage;
	}	
	
	
}
