package nicolamarino.com;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nicolamarino.com.model.User;
/**
 * Servlet implementation class TestEJBSrv
 */
@WebServlet("/testejb")
public class TestEJBSrv extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// nome risorsa remota da cui fare inj, viene preso dalle Loggate di WindFly
	@Resource(mappedName = "java:global/MyProjectEJBStateless/TestStateless!nicolamarino.com.TestStateless")
	// Inj Interface Remota che richiama EJB Classe
	//@EJB(mappedName = "java:global/MyProjectEJBStateless/TestStateless!nicolamarino.com.TestStateless")
	private TestStateless ejbUser;

//	UserDao userDao = new UserDao();
	User user = new User();
	
	
	
	public TestEJBSrv() {
		super();

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		user.setNome("Michele");
//		user.setCognome("Marino");
//		user.setEta(40);
//		ejbUser.insertNewUser(user);
//		response.getWriter().append("Inserimento Utente OK");
		
//		Integer id =  2;
//		User user = ejbUser.selectByIdMetodo1(id);
		
//		Integer id =  2;
//		List<User> user= ejbUser.selectByIdMetodo2(id);
		
//		List<User> user= ejbUser.getAllUsers();
		
//		Integer id =2;
//		String nome = "Pippo";
//		String cognome = "Marrore";
//		int eta = 22;
		
//		User user = ejbUser.updateUserMetodo1(id, nome, cognome, eta);
//		response.getWriter().append("Utente modificato senza HQL: " + user);
		
//		ejbUser.updateUserMetodo2(id, nome, cognome, eta);
//		response.getWriter().append("Utente modificato con seccesso con HQL");
		
		Integer id =6;
//		ejbUser.deleteUserByIdMetodo1(id);
//		response.getWriter().append("Utente eliminato con seccesso");
		
		ejbUser.deleteUserByIdMetodo2(id);
		response.getWriter().append("Utente eliminato con seccesso con QUERY HQL");
		
//		response.getWriter().append(bsLocal.helloEJBLocal()).append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
