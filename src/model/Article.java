package model;

import java.util.List;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "articles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "article_type", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name = "Article.getAll", query = "SELECT a FROM Article a")
@NamedQuery(name = "Article.byYear", query = "SELECT a FROM Article a WHERE a.releaseYear = :year ORDER BY a.releaseYear ASC")
@NamedQuery(name = "Article.byAuthor", query = "SELECT a FROM Article a WHERE LOWER(a.author) LIKE LOWER(:author)")
@NamedQuery(name = "Article.byTitle", query = "SELECT a FROM Article a WHERE LOWER(a.title) LIKE LOWER('%' || :title || '%')")

public class Article implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "isbncode")
	private Long ISBNCode;
	private String title;
	@Column(name = "release_year")
	private Integer releaseYear;
	@Column(name = "number_of_page")
	private Integer numberOfPage;
	@OneToMany(mappedBy = "articleOnLoan", cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	private List<Loan> loan;
	
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getNumberOfPage() {
		return numberOfPage;
	}

	public void setNumberOfPage(Integer numberOfPage) {
		this.numberOfPage = numberOfPage;
	}

	public Long getISBNCode() {
		return ISBNCode;
	}	
	
}
