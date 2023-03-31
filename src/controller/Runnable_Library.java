package controller;

import javax.persistence.EntityManager;
import utils.JpaUtil;
import model.Book;
import model.Magazine;
import model.E_Genre;
import model.E_Periodicity;

public class Runnable_Library {
	//public static EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	
	public static void main(String[] args) {
		Book b1 = new Book("JOJO", 2005, 550, "ale", E_Genre.BIOGRAPHY);
		Magazine m1 = new Magazine("JAJA", 2006, 654, E_Periodicity.MONTHLY);
		System.out.println(b1);
		System.out.println(m1);
	}
}
