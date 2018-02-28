import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.CashControlPage;
import Pages.RegistersPage;
import Pages.UserLoginPage;

public class RegistersTest {
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(String browser) {
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
	}
	
	@Test 
	void addNewRegion() 
	{
		RegistersPage.goTo();
		RegistersPage.addNew();
		Assert.assertTrue(RegistersPage.isAdded(), "New Region is not added");
		RegistersPage.close();
	}
	
	@Test 
	void editRegion() 
	{
		RegistersPage.goTo();
		RegistersPage.addNew();
		RegistersPage.editRegion();
		Assert.assertTrue(RegistersPage.isEdited(), "New Region is not updated");
		RegistersPage.close();
	}
	
	@Test 
	void cancelEditing() 
	{
		RegistersPage.goTo();
		RegistersPage.addNew();
		RegistersPage.editAndCancelRegister();
		Assert.assertTrue(RegistersPage.isEdited(), "New Region is not updated");
		RegistersPage.close();
	}
	@Test 
	void regionAlreadyExists() 
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


