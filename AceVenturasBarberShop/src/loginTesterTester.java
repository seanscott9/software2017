import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class loginTesterTester {

	loginTester usrs;
	//i think thats how it works
	//you run this and it shows if there are errors
	
	@Before
	public void setUp() throws Exception {
		usrs = new loginTester();
	}

	@Test
	public final void testActionPerformed() {
		//TEST CASE 1
		usrs.usrName.setText("test@test");
		usrs.pwd.setText("toor");
		
		//TEST CASE 2
		//usrs.usrName.setText("admin");
		//usrs.pwd.setText("toor");
		
		fail("Not yet implemented");
	}

}
