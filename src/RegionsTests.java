import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.CashControlPage;
import Pages.RegionsPage;
import Pages.UserLoginPage;

public class RegionsTests {
	@BeforeTest
	void testInitialize() {
		Browser.initialize();
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
	}
	
	@Test 
	void addNewRegion() 
	{
	RegionsPage.goTo();
	RegionsPage.addNew();
	Assert.assertTrue(RegionsPage.isAdded(), "New Region is not added");
	RegionsPage.deleteLastAdded();
	RegionsPage.close();
	}
	
	@Test 
	void editRegion() 
	{
	RegionsPage.goTo();
	RegionsPage.addNew();
	RegionsPage.close();
	RegionsPage.goTo();
	RegionsPage.editRegion();
	Assert.assertTrue(RegionsPage.isEdited(), "New Region is not updated");
	RegionsPage.deleteLastAdded();
	RegionsPage.close();
	}
	
	@Test 
	void cancelEditing() 
	{
		RegionsPage.goTo();
		RegionsPage.addNew();
		RegionsPage.close();
		RegionsPage.goTo();
		RegionsPage.editRegion();
		Assert.assertTrue(RegionsPage.isEdited(), "New Region is not updated");
		RegionsPage.deleteLastAdded();
		RegionsPage.close();
	}
	//@Test 
	void invalidDescriptionAdd() 
	{
		RegionsPage.goTo();
		RegionsPage.addNew();
		RegionsPage.close();
		RegionsPage.goTo();
		RegionsPage.editRegion();
		Assert.assertTrue(RegionsPage.isEdited(), "New Region is not updated");
		RegionsPage.deleteLastAdded();
		RegionsPage.close();
	}
	
	//@Test 
		void regionAlreadyExists() 
		{
			RegionsPage.goTo();
			RegionsPage.addNew();
			RegionsPage.close();
			RegionsPage.goTo();
			RegionsPage.editRegion();
			Assert.assertTrue(RegionsPage.isEdited(), "New Region is not updated");
			RegionsPage.deleteLastAdded();
			RegionsPage.close();
		}
	
}
