import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.CashControlPage;
import Pages.DashBoardPage;
import Pages.GLAccountsPage;
import Pages.ActivityCenterGroupsPage;
import Pages.UserLoginPage;

public class ACGroupsTests {
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(String browser) {
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
	}
	
	@Test(priority = 1)
	void addNewACGroup() 
	{
		System.out.println("This a test for add new functionality");
		ActivityCenterGroupsPage.goTo();
		ActivityCenterGroupsPage.addAsActiveAndOwnedACGroup();
		Assert.assertTrue(ActivityCenterGroupsPage.isAdded(), "New Region is not added");
		ActivityCenterGroupsPage.deleteLastAddedACGroup();
		//ActivityCenterGroupsPage.closeACGroup();
	}
	
	@Test(priority = 2)
	void editACGroup() 
	{
		System.out.println("This a test for edit functionality");
		ActivityCenterGroupsPage.goTo();
		ActivityCenterGroupsPage.addAsInactiveAndLeasedACGroup();
		ActivityCenterGroupsPage.editACGroup();
		System.out.println("About to do the isEdited check");
		Assert.assertTrue(ActivityCenterGroupsPage.isEdited(), "New Region is not updated");
		ActivityCenterGroupsPage.deleteLastAddedACGroup();
		//ActivityCenterGroupsPage.closeACGroup();
	}
	
	@Test(priority = 3)
	void cancelEditing() 
	{
		System.out.println("This a test for cancel functionality");
		ActivityCenterGroupsPage.goTo();
		ActivityCenterGroupsPage.addAsActiveAndOwnedACGroup();
		ActivityCenterGroupsPage.editAndCancelACGroup();
		ActivityCenterGroupsPage.deleteLastAddedACGroup();
		//ActivityCenterGroupsPage.closeACGroup();
	}
	@Test(priority = 5)
	void acGroupAlreadyExists() 
	{
		System.out.println("This a test for duplicate entry functionality");
		ActivityCenterGroupsPage.goTo();
		ActivityCenterGroupsPage.addAsActiveAndOwnedACGroup();
		ActivityCenterGroupsPage.addACGroupAgain();
		Assert.assertTrue(ActivityCenterGroupsPage.checkProperErrorMessageACGroup(), "Error message not displayed");
		ActivityCenterGroupsPage.deleteLastAddedACGroup();
		//ActivityCenterGroupsPage.closeACGroup();
	}
	
	@Test(priority = 4)
	void cannotDeleteACGroupInUse() 
	{
		//ActivityCenterGroupsPage.goTo();
		//ActivityCenterGroupsPage.addAsActiveAndOwnedACGroup();//add an AC Group for Dept 001
		//ActivityCenterGroupsPage.closeACGroup();
		//GLAccountsPage.goTo();
		//GLAccountsPage.updateAlternateACGroupAsNewlyEntered();
		//GLAccountsPage.close();
		ActivityCenterGroupsPage.goTo();
		Assert.assertTrue(ActivityCenterGroupsPage.checkProperDeleteErrorMessageACGroup(), "Error message not displayed");
		//GLAccountsPage.goTo();
		//GLAccountsPage.updateAlternateACGroupBackToOriginal();
		//GLAccountsPage.close();
		//ActivityCenterGroupsPage.deleteLastAddedACGroup();
		//ActivityCenterGroupsPage.closeACGroup();
	}
	
	@AfterMethod
	void closeForm() {
		ActivityCenterGroupsPage.closeACGroup();
	}
	
	@AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}
	
}


