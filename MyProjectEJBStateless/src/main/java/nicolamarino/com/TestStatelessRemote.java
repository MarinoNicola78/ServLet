package nicolamarino.com;

import javax.ejb.Remote;

@Remote
public interface TestStatelessRemote {

	public String helloEJBRemote();
	
	public String helloEJBRemote1();
	
	
	

}
