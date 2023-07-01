package nicolamarino.com;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import nicolamarino.com.dao.UserDao;
import nicolamarino.com.model.User;

/**
 * Session Bean implementation class TestStateless
 */

@Stateless
@LocalBean
public class TestStateless {

	UserDao userDao = new UserDao();

	/**
	 * Default constructor.
	 */
	public TestStateless() {

	}

	public void insertNewUser(User u) {
		userDao.insertNewUser(u);
	}
	
	public User selectByIdMetodo1(Integer id) {
		User user = userDao.selectByIdMetodo1(id);
		return user;
	}

	public List<User> selectByIdMetodo2(Integer id) {
		List<User> user = userDao.selectByIdMetodo2(id);
		return user;
	}
	
	public List<User> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		return users;
	}
	
	public User updateUserMetodo1(Integer id, String nome, String cognome, int eta) {
		User user = userDao.updateUserMetodo1(id, nome, cognome, eta);
		return user;
	}
	
	public String updateUserMetodo2(Integer id, String nome, String cognome, int eta) {
		userDao.updateUserMetodo2(id, nome, cognome, eta);
		return "";
	}
	
	public String deleteUserByIdMetodo1(Integer id) {
		userDao.deleteUserByIdMetodo1(id);
		return "";
	}
	
	public String deleteUserByIdMetodo2(Integer id) {
		userDao.deleteUserByIdMetodo2(id);
		return "";
	}
	
	
	
	
//	@Override
//	public String helloEJBLocal() {
//		System.out.println("sono dentro il metodo helloEJBLocal Classe TestStateless ");
//		return "helloEJBLocal";
//	}
//
//	@Override
//	public String helloEJBRemote() {
//		System.out.println("sono dentro il metodo helloEJBRemote");
//		return "helloEJBRemote";
//	}
//
//	@Override
//	public String helloEJBRemote1() {
//		System.out.println("sono dentro il metodo helloEJBRemote1");
//		return "helloEJBRemote1";
//	}

}
