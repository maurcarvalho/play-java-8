package br.com.mjcarvalho.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.mjcarvalho.model.User;

public class MethodsReferenceTest {

	List<User> users;

	@Before
	public void prepareFixture() {
		users = new ArrayList();
		users.add(new User("User 3 ", 1, false));
		users.add(new User("User 2 ", 5, false));
		users.add(new User("User 1 ", 3, false));
		users.add(new User("User 4 ", 101, true));
		users.forEach(u -> System.out.println("Earlier:" + u.getName() + " - master?: " + u.isMaster()));
	}

	@After
	public void afterPrint() {
		users.forEach(u -> System.out.println("After:" + u.getName() + " - master?: " + u.isMaster()));
	}
	
	@Test
	public void setAllUserMasterAttrUsingMethodsRefereceTest(){
		/*		
		 * User::setMaster generate an functional interface (Consumer)
		 * Ex: Consumer<User> consumer = User::isMaster  is equals then:
		 *     Consumer<User> comsumer = u -> u.isMaster();
		 *     So we can do something like below:
		 */
		users.forEach(User::setMaster);
	}
}