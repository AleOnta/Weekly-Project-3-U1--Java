package controller;
import model.User;
import model.Loan;
import javax.persistence.EntityManager;
import utils.JpaUtil;
import model.Article;
import model.Book;
import model.Magazine;
import model.E_Genre;
import model.E_Periodicity;
import Dao.Library_Dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Runnable_Library {
	
	public static Scanner input = new Scanner(System.in);
	public static Library_Dao lDao = new Library_Dao();
	
	public static void main(String[] args) {
		
		Article articleToAdd = lDao.getByISBN(4);
		List<User> usersList = lDao.getAllUsers();
		
		Loan l1 = new Loan(usersList.get(0), articleToAdd, LocalDate.of(2023, 04, 01), LocalDate.of(2023, 05, 01));
		
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(l1);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}
	
	public static void addToCatalogue() {
		System.out.println("Okay then, what kind of element would you like to add?");
		System.out.println("1 - a Book | 2 - a Magazine");
		int userPick = askFor();
		
		System.out.println("Okay, let's start building the new item:");
		System.out.println("Insert the title of the item");
		String title = input.next() + input.nextLine();
		System.out.println("Okay, now insert the year of release of the item:");
		int release = askFor(0);
		System.out.println("Okay, now insert the number of page of the item:");
		int numPage = askFor(0);
		
		switch (userPick) {
			case 1 -> {
				System.out.println("Insert the author of the item:");
				String auth = input.next() + input.nextLine();
				E_Genre genre = askForGenre();
				lDao.addArticle(new Book(title, release, numPage, auth, genre));
				System.out.println("Book correctly added to the catalogue");
			}
			case 2 -> {
				E_Periodicity period = askForPeriodicity();
				lDao.addArticle(new Magazine(title, release, numPage, period));
				System.out.println("Magazine correctly added to the catalogue");
			}
		}
	}
	
	public static int askFor() {
        boolean isRunning = true;
        int pick = 0;
        while (isRunning) {
            if (input.hasNextInt()) {
                pick = input.nextInt();
                if (pick < 1 || pick > 2) {
                    System.out.println("invalid value, insert again");
                    input.nextLine();
                    continue;
                }
            } else {
            	System.out.println("Unfit type of value, please insert an integer");
                input.nextLine();
                continue;
            }
            isRunning = false;
        }
        return pick;
    }
	
	// overload of the previous method to ask an integer
    public static int askFor(int i) {
        boolean isRunning = true;
        int pick = 0;
        while (isRunning) {
            if (input.hasNextInt()) {
                pick = input.nextInt();
            } else {
                System.out.println("Unfit type of value, please insert an integer");
                input.nextLine();
                continue;
            }
            isRunning = false;
        }
        return pick;
    }
    
	public static E_Genre askForGenre() {
		
		System.out.println("Insert the genre of the item, using the corresponding value:");
		String[] genres = {"Adventure", "Fantasy", "Romance", "Horror", "Thriller", "Biography", "Science", "Music", "Sport"};
		for(int i = 0; i < genres.length; i++) {
			System.out.println((i + 1) + " - " + genres[i]);
		}
		
		boolean isRunning = true;
        int pick = 0;
        while (isRunning) {
            if (input.hasNextInt()) {
                pick = input.nextInt();
                if (pick < 1 || pick > 9) {
                    System.out.println("invalid value, insert again");
                    input.nextLine();
                    continue;
                }
            } else {
            	System.out.println("Unfit type of value, please insert an integer");
                input.nextLine();
                continue;
            }
            isRunning = false;
        }
        
		E_Genre genre = E_Genre.ADVENTURE;
		switch (pick) {
			case 1 -> genre = E_Genre.ADVENTURE;
			case 2 -> genre = E_Genre.FANTASY;
			case 3 -> genre = E_Genre.ROMANCE;
			case 4 -> genre = E_Genre.HORROR;
			case 5 -> genre = E_Genre.THRILLER;
			case 6 -> genre = E_Genre.BIOGRAPHY;
			case 7 -> genre = E_Genre.SCIENCE;
			case 8 -> genre = E_Genre.MUSIC;
			case 9 -> genre = E_Genre.SPORT;
		}
		
		return genre;
	}
	
	public static E_Periodicity askForPeriodicity() {
		
		System.out.println("Insert the periodicity of the item, using the corresponding value:");
		String[] period = {"Weekly", "Monthly", "Half-Yearly"};
		for(int i = 0; i < period.length; i++) {
			System.out.println((i + 1) + " - " + period[i]);
		}
		
		boolean isRunning = true;
        int pick = 0;
        while (isRunning) {
            if (input.hasNextInt()) {
                pick = input.nextInt();
                if (pick < 1 || pick > 3) {
                    System.out.println("invalid value, insert again");
                    input.nextLine();
                    continue;
                }
            } else {
            	System.out.println("Unfit type of value, please insert an integer");
                input.nextLine();
                continue;
            }
            isRunning = false;
        }
        
		E_Periodicity per = E_Periodicity.WEEKLY;
		switch (pick) {
			case 1 -> per = E_Periodicity.WEEKLY;
			case 2 -> per = E_Periodicity.MONTHLY;
			case 3 -> per = E_Periodicity.HALF_YEARLY;
		}
		
		return per;
	}
}
