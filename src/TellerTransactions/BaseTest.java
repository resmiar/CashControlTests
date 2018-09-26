package TellerTransactions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import Initialization.Browser;
import Initialization.DatabaseConnection;
import Pages.UserLoginPage;
import Pages.Maintenance.BagTypePage;
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
		BagTypePage.goTo();
		BagTypePage.createBagTypeForTellerTransaction();
		BagTypePage.close();
	}
	
	@AfterTest
	void browserClose()
	{
		DatabaseConnection.cleanupTrans();
		DatabaseConnection.deleteBagType();
		Browser.instanceClose();
	}
	
}