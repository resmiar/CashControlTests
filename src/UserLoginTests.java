/*
*UserLoginTests
*
*Version 1.00
*/
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.CashControlPage;
import Pages.DashBoardPage;
import Pages.UserLoginPage;

public class UserLoginTests {
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(String browser) {
		Browser.initialize(browser);
	}
	
	@Test 
	void validLoginTest() 
	{
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		Assert.assertTrue(CashControlPage.isAt(), "Cash Control Login screen not displayed");
		CashControlPage.loginToACCGroup();
		DashBoardPage.checkLoginUserName();	
		DashBoardPage.logOut();
	}
	
	@Test
	void validDomainLoginTest() 
	{
		
	}
	
	@AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}

}
