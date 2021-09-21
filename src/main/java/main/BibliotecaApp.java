package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import entidades.Autor;
import entidades.Domicilio;
import entidades.Libro;
import entidades.Localidad;
import entidades.Persona;


public class BibliotecaApp {

	public static void main(String[] args) {
		 EntityManagerFactory emf=Persistence.createEntityManagerFactory("BibliotecaPU");
		 EntityManager em=emf.createEntityManager();

		 
		 try {
			 em.getTransaction().begin();
			 Autor autor1 =Autor.builder().nombre("J.R.R").apellido("Tolkien")
					 .biografia("J. R. R. Tolkien o JRRT, fue un escritor, poeta, filólogo,lingüista y profesor universitario británico")
					 .build(); 
			 Libro libro1 =Libro.builder().fecha(12301923).genero("Fantasia").paginas(250).titulo("Las 2 torres").build();
			 Localidad localidad1 =Localidad.builder().Denominacion("Villa Nueva").build();
			 Domicilio domicilio1 =Domicilio.builder().calle("Los Andes").numero(2563).localidad(localidad1).build();
			
			 Persona persona1 =Persona.builder().nombre("Pablo").apellido("Ruiz").dni(23568989).domicilio(domicilio1).build();
			 
			 
             libro1.getAutores().add(autor1);
             persona1.getLibros().add(libro1);
             
             em.persist(autor1);
             em.persist(libro1);
             em.persist(localidad1);
             em.persist(domicilio1);
             em.persist(persona1);
             em.flush();
             em.getTransaction().commit();
		 }catch(Exception e) {
			 em.getTransaction().rollback();
			 JOptionPane.showConfirmDialog(null, e);
		 }
		 em.close();
		 emf.close();
	}

}
