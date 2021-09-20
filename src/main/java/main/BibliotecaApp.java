package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BibliotecaApp {

	public static void main(String[] args) {
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("BibliotecaPU");
		 EntityManager em=emf.createEntityManager();

	}

}
