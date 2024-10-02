package neotech.testbases;

import com.neotech.pages.AddEmployeePageElements;
import com.neotech.pages.PersonalDetailsPageElements;

import neotech.pages.DashboardPageElements;
import neotech.pages.LoginPageElements;

public class PageInitializer extends BaseClass {

	public static LoginPageElements loginPage;
	public static DashboardPageElements dashboardPage;
	public static AddEmployeePageElements addEmployeePage;
	public static PersonalDetailsPageElements personalDetailsPage;

	public static void initialize() {
		loginPage = new LoginPageElements();
		dashboardPage = new DashboardPageElements();
		addEmployeePage = new AddEmployeePageElements();
		personalDetailsPage = new PersonalDetailsPageElements();
	}

}
