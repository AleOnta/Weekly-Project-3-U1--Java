package model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("Article-Book")
public class Book extends Article {
	
	@Column(name = "b_author")
	private String author;
	@Enumerated(EnumType.STRING)
	@Column(name = "b_genre")
	private E_Genre genre;
	
	public Book() {
		super();
	}

	public Book(String title, Integer releaseYear, Integer numberOfPage, String author, E_Genre genre) {
		super(title, releaseYear, numberOfPage);
		this.author = author;
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public E_Genre getGenre() {
		return genre;
	}

	public void setGenre(E_Genre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [Title=" + getTitle() + ", ReleaseYear="+ getReleaseYear() + ", NumberOfPage=" + getNumberOfPage() 
		+ ", ISBNCode=" + getISBNCode() + ", author=" + author + ", genre=" + genre + "]";
	}

	
		
}
