package nicolamarino.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import nicolamarino.com.model.User;

public class UserDao {

	private EntityManagerFactory emf;
	private EntityManager em;

	public UserDao() {
		// passo come argomento il nome della persistence-unit "JpaHibernate" preso dal
		// File XML
		this.emf = Persistence.createEntityManagerFactory("JpaHibernate");
		this.em = emf.createEntityManager();
	}

	/* Metodi CRUD nativi e with HQL */

	// Insert New User
	public void insertNewUser(User u) {

		System.out.println("Inizio la transizione...........");

		em.getTransaction().begin();
		em.persist(u);
		System.out.println("Nuovo utente inserito correttamente: " + u);
		em.getTransaction().commit();
		em.close();

		System.out.println("Chiudo la transazione...............");

	}

	// Get User by id with Metodo Hibernate JPA
	public User selectByIdMetodo1(Integer id) {

		System.out.println("Eseguo primo tipo di FIND: selectByIdMetodo1");
		User user = em.find(User.class, id);
		System.out.println("Utente trovato: " + user);
		return user;
	}

	// Get All User with QueryHQL
	public List<User> getAllUsers() {

		System.out.println("Eseguo primo tipo di FIND: getAllUsers");
		System.out.println("Eseguo la Query sul BD........");
		Query query = em.createQuery("FROM User");
		List<User> user = query.getResultList();
		System.out.println("Utenti trovati: " + user);
		return user;
	}

	// Get User by id with QueryHQL
	public List<User> selectByIdMetodo2(Integer id) {
		System.out.println("Eseguo la Query SELECT sul BD........");
		Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :id");
		query.setParameter("id", id);
		List<User> user = query.getResultList();
		System.out.println("Utenti trovati: " + user);
		return user;
	}

	// Update User with with Metodo Hibernate JPA
	public User updateUserMetodo1(Integer id, String nome, String cognome, int eta) {
		User user = selectByIdMetodo1(id);
		user.setNome(nome);
		user.setCognome(cognome);
		user.setEta(eta);
		System.out.println("Inizio la transizione per la modifica utente...........");
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
//		em.close();
		System.out.println("salvo Utente con le nuove modifiche........" + user);
		System.out.println("Chiudo la transazione...............");
		return user;
	}

	// Update User with QueryHQL
	public String updateUserMetodo2(Integer id, String nome, String cognome, int eta) {

		// bisogna startare e committare la commsione anche con query HQL
		em.getTransaction().begin();
		System.out.println("Inizio la transizione...........");

		Query update = em
				.createQuery("UPDATE User u set u.cognome = :cognome, u.eta = :eta, u.nome = :nome WHERE u.id = :id");
		update.setParameter("cognome", cognome);
		update.setParameter("nome", nome);
		update.setParameter("eta", eta);
		update.setParameter("id", id);
		
		// parametro che esegue update della Query
		update.executeUpdate();

		System.out.println("Chiudo la transazione...............");
		em.getTransaction().commit();
		return "Utente modificato con seccesso con HQL";
	}

	// Delete User by id
	public String deleteUserByIdMetodo1(Integer id) {
		System.out.println("dentro il metodo deleteUserByIdMetodo1");
		System.out.println("Inizio la transizione...........");
		em.getTransaction().begin();
		User userFind = selectByIdMetodo1(id);
		em.remove(userFind);
		em.getTransaction().commit();
		System.out.println("Utente rimosso correttamente");
		System.out.println("Chiudo la transazione...............");
		return "";
	}

	// Delete User by id with query HQL
	public String deleteUserByIdMetodo2(Integer id) {
		System.out.println("Inizio la transizione...........");
		em.getTransaction().begin();

		Query delete = em.createQuery("DELETE FROM User u WHERE u.id = :id");
		delete.setParameter("id", id);
		delete.executeUpdate();

		em.getTransaction().commit();
		System.out.println("Utente rimosso correttamente con QUERY HQL");
		System.out.println("Chiudo la transazione...............");
		return "";
	}
}
