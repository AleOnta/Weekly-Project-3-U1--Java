package model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter @Setter
public class Book extends Article {
	
	private String author;
	@Enumerated(EnumType.STRING)
	private E_Genre genre;
	
	public Book() {
		super();
	}

	public Book(String title, Integer releaseYear, Integer numberOfPage, String author, E_Genre genre) {
		super(title, releaseYear, numberOfPage);
		this.author = author;
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [" + super.toString() + ", author=" + author + ", genre=" + genre + "]";
	}

}
