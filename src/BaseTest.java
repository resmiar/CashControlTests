import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import Initialization.Browser;
import Pages.CashControlPage;
import Pages.DashBoardPage;
import Pages.UserLoginPage;

public class BaseTest {	
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(String browser) {
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
