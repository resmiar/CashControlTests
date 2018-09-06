package Maintenance;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import Initialization.Browser;
import Pages.UserLoginPage;
import Pages.Maintenance.CashControlPage;
import Pages.Maintenance.DashBoardPage;

public class BaseTest {	
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(@Optional("Firefox")String browser){
		System.out.println("browser passed as :- " + browser);
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		Assert.assertTrue(CashControlPage.isAt());
		CashControlPage.loginToACCGroup();
		Assert.assertTrue(DashBoardPage.isAt());
	}
	
	@AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}
	
}
