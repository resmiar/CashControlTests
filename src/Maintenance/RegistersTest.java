package Maintenance;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.UserLoginPage;
import Pages.Maintenance.CashControlPage;
import Pages.Maintenance.RegistersPage;

public class RegistersTest {
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(@Optional("Firefox")String browser) {
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
	}
	
	@Test 
	void addNewRegister() 
	{
		RegistersPage.goTo();
		RegistersPage.addNew();
		//Assert.assertTrue(RegistersPage.isAdded(), "New Region is not added");
		RegistersPage.close();
	}
	
	@Test 
	void editRegister() 
	{
		RegistersPage.goTo();
		RegistersPage.addNew();
		RegistersPage.editRegion();
		RegistersPage.close();
		RegistersPage.goTo();
		//Assert.assertTrue(RegistersPage.isEdited(), "New Region is not updated");
		RegistersPage.close();
	}
	
	@Test 
	void cancelEditing() 
	{
		RegistersPage.goTo();
		RegistersPage.addNew();
		RegistersPage.editAndCancelRegister();
		RegistersPage.close();
		RegistersPage.goTo();
		//Assert.assertTrue(RegistersPage.isEdited(), "New Region is not updated");
		RegistersPage.close();
	}
	@Test 
	void registerAlreadyExists() 
	{
		RegistersPage.goTo();
		RegistersPage.addNew();
		RegistersPage.close();
		RegistersPage.goTo();
		RegistersPage.addRegisterAgain();
		Assert.assertTrue(RegistersPage.checkProperErrorMessage(), "Error message not displayed");
		RegistersPage.close();
	}
	
	@Test 
	void invalidDescriptionAdd() 
	{
		RegistersPage.goTo();
		RegistersPage.addNewWithBlankDescription();
		Assert.assertTrue(RegistersPage.checkProperErrorMessage(), "Error message not displayed");
		RegistersPage.close();
	}
	
	@AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}
}


