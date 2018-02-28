import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import Initialization.Browser;
import Pages.CashControlPage;
import Pages.TaxSchedulesPage;
import Pages.UserLoginPage;

public class TaxSchedulesTests {
	
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
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNew();
		Assert.assertTrue(TaxSchedulesPage.isAdded(), "New Region is not added");
		TaxSchedulesPage.deleteLastAdded();
		TaxSchedulesPage.close();
	}
	
	@Test 
	void editRegion() 
	{
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNew();
		TaxSchedulesPage.close();
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.editRegion();
		Assert.assertTrue(TaxSchedulesPage.isEdited(), "New Region is not updated");
		TaxSchedulesPage.deleteLastAdded();
		TaxSchedulesPage.close();
	}
	
	@Test 
	void cancelEditing() 
	{
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNew();
		TaxSchedulesPage.close();
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.editAndCancelRegion();
		Assert.assertTrue(TaxSchedulesPage.isEdited(), "New Region is not updated");
		TaxSchedulesPage.deleteLastAdded();
		TaxSchedulesPage.close();
	}
	//@Test 
	void regionAlreadyExists() 
	{
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNew();
		TaxSchedulesPage.close();
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNew();
		Assert.assertTrue(TaxSchedulesPage.checkProperErrorMessage(), "Error message not displayed");
		TaxSchedulesPage.deleteLastAdded();
		TaxSchedulesPage.close();
	}
	
	//@Test 
	void invalidDescriptionAdd() 
	{
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNewWithBlankDescription();
		Assert.assertTrue(TaxSchedulesPage.checkProperErrorMessage(), "Error message not displayed");
		TaxSchedulesPage.close();
	}
	
}

 




