package neotech.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import neotech.pages.DashboardPageElements;
import neotech.pages.LoginPageElements;
import neotech.utilities.CommonMethods;
import neotech.utilities.ConfigsReader;

public class LoginTest extends CommonMethods {

	@Test(groups = {"smoke","regression"})
	public void validLogin() {
		LoginPageElements login = new LoginPageElements();
		DashboardPageElements Dashboard = new DashboardPageElements();
		
		// send user name 
				sendText(login.username, ConfigsReader.getProperty("username"));
				// send password
				sendText(login.username, ConfigsReader.getProperty("password"));
		
		
		
		//click on login
				click(login.loginBtn);
				
				//verify that we are loggedin
				String expected = "Jacqualine White";
				String actual = Dashboard.accountName.getText();
		
	}

	@Test(groups = " smoke")
	public void emptypassword() {

		LoginPageElements login = new LoginPageElements();
		// send user name
		sendText(login.username, ConfigsReader.getProperty("username"));

		// leave the password empty
		// now click on loginF
		click(login.loginBtn);

		// assert that proper mesage is shown
		String expected = "password cannot be empty";
		String actual = login.passwordError.getText();
		AssertJUnit.assertEquals(actual, expected, "Error messages do not match!!!");
	}
		
		
		@Test   (groups = " regression")
		public void invalidPassword() {
			
			LoginPageElements login = new LoginPageElements();
			
			
			
			// send username 
			sendText(login.username, ConfigsReader.getProperty("username"));
			
			// send invalid password
			
			sendText(login.password, ConfigsReader.getProperty("paassword"));

			sendText(login.password, "wrong paassword");
			
			click(login.loginBtn);

			
		

		

	}

}
