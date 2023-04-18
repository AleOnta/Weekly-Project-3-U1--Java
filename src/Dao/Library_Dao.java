package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Article;
import model.Book;
import model.Loan;
import model.User;
import utils.JpaUtil;

public class Library_Dao implements I_Library_Dao {
	public EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();

	@Override
	public void addArticle(Article a) {
		
		try {
			em.getTransaction().begin();
			em.persist(a);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
	}

	@Override
	public void removeArticle(int id) {

		try {
			em.getTransaction().begin();
			em.remove(Long.valueOf(id));
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			System.out.println("Article correctly deleted");
		}

	}

	@Override
	public Article getByISBN(int id) {
		
		Article art = null;
		try {
			em.getTransaction().begin();
			art = em.find(Article.class, Long.valueOf(id));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return art;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getByRelease(Integer release) {
		
		
		Query q = em.createNamedQuery("Article.byYear");
		q.setParameter("year", release);

		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getByAuthor(String author) {
		
		Query q = em.createNamedQuery("Article.byYear");
		q.setParameter("author", author);

		return q.getResultList();
	}

	@Override
	public List<Article> getByTitle(String title) {
		
		
		Query q = em.createNamedQuery("Article.byYear");
		q.setParameter("title", title);
		
		return q.getResultList();
	}

	@Override
	public List<Article> getLoansByCardId(Long cardId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> getExpiredLoans() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		
		Query q = em.createNamedQuery("Article.getAll");
		
		return q.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		
		Query q = em.createNamedQuery("User.getAll");
		
		return q.getResultList();
	}
	
	public void addUser(User u) {
		try {
			em.getTransaction().begin();
			em.persist(u);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}
	
	public User getUserById(Long id) {
		User u = null;
		try {
			em.getTransaction().begin();
			u = em.find(User.class, Long.valueOf(id));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public void addLoan(Loan l) {
		try {
			em.getTransaction().begin();
			em.persist(l);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}
		
	}
	
	

}
