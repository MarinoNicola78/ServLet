package nicolamarino.com;

import javax.ejb.Local;

@Local
public interface TestStatelessLocal {

	public String helloEJBLocal();
	
	
}
