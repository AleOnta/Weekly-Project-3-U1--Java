package Dao;

import java.util.List;
import model.Loan;
import model.User;
import model.Article;
import model.Book;

public interface I_Library_Dao {
	
	public void addArticle(Article a);
	
	public void removeArticle(int id);
	
	public Article getByISBN(int id);
	
	public List<Article> getByRelease(Integer release);
	
	public List<Book> getByAuthor(String author);
	
	public List<Article> getByTitle(String title);
	
	public List<Article> getLoansByCardId(Long cardId);
	
	public List<Loan> getExpiredLoans();
	
	public List<User> getAllUsers();
}
