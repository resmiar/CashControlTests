import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.CashControlPage;
import Pages.SalesRepsPage;
import Pages.UserLoginPage;

public class SalesRepsTests {
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(String browser) {
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
	} 
	
	@Test 
	//To verify that the add region functionality is working properly
	void addNewRegion() 
	{
		SalesRepsPage.goTo();
		SalesRepsPage.addNew();
		Assert.assertTrue(SalesRepsPage.isAdded(), "New Region is not added");
		SalesRepsPage.deleteLastAdded();
		SalesRepsPage.close();
	}
	
	@Test 
	//To verify that the edit region functionality is working properly
	void editRegion() 
	{
		SalesRepsPage.goTo();
		SalesRepsPage.addNew();
		SalesRepsPage.close();
		SalesRepsPage.goTo();
		SalesRepsPage.editRegion();
		Assert.assertTrue(SalesRepsPage.isEdited(), "New Region is not updated");
		SalesRepsPage.deleteLastAdded();
		SalesRepsPage.close();
	}
	
	@Test 
	//To verify that canceling modification is working properly
	void cancelEditing() 
	{
		SalesRepsPage.goTo();
		SalesRepsPage.addNew();
		SalesRepsPage.close();
		SalesRepsPage.goTo();
		SalesRepsPage.editAndCancelRegion();
		Assert.assertTrue(SalesRepsPage.isEdited(), "New Region is not updated");
		SalesRepsPage.deleteLastAdded();
		SalesRepsPage.close();
	}
	
	@Test 
	//To verify that proper error message is displayed when a duplicate entry is made
	void regionAlreadyExists() 
	{
		SalesRepsPage.goTo();
		SalesRepsPage.addNew();
		SalesRepsPage.close();
		SalesRepsPage.goTo();
		SalesRepsPage.addRegionAgain();
		Assert.assertTrue(SalesRepsPage.checkProperErrorMessage(), "Error message not displayed");
		SalesRepsPage.deleteLastAdded();
		SalesRepsPage.close();
	}
	
	@Test //To verify that proper error message is displayed when description is blank
	void invalidDescriptionAdd() 
	{
		SalesRepsPage.goTo();
		SalesRepsPage.addNewWithBlankDescription();
		Assert.assertTrue(SalesRepsPage.checkProperErrorMessage(), "Error message not displayed");
		SalesRepsPage.close();
	}
	
	@AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}
	
}


