package Maintenance;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import Initialization.Browser;
import Pages.UserLoginPage;
import Pages.Maintenance.CashControlPage;
import Pages.Maintenance.TaxSchedulesPage;

public class TaxSchedulesTests {
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(@Optional("Firefox")String browser) {
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
	} 
	
	@Test 
	void addNewTaxSchedule() 
	{
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNew();
		Assert.assertTrue(TaxSchedulesPage.isAdded(), "New Region is not added");
		TaxSchedulesPage.deleteLastAdded();
		TaxSchedulesPage.close();
	}
	
	@Test 
	void editTaxSchedule() 
	{
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNew();
		TaxSchedulesPage.editRegion();
		TaxSchedulesPage.close();
		TaxSchedulesPage.goTo();
		Assert.assertTrue(TaxSchedulesPage.isEdited(), "New Region is not updated");
		TaxSchedulesPage.deleteLastAdded();
		TaxSchedulesPage.close();
	}
	
	@Test 
	void cancelEditing() 
	{
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNew();
		TaxSchedulesPage.editAndCancelRegion();
		Assert.assertTrue(TaxSchedulesPage.isEdited(), "New Region is not updated");
		TaxSchedulesPage.deleteLastAdded();
		TaxSchedulesPage.close();
	}
	@Test 
	void noTaxCodesAdded() 
	{
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addTaxScheduleWithoutTaxCode();
		Assert.assertTrue(TaxSchedulesPage.checkProperErrorMessage(), "Error message not displayed");
		TaxSchedulesPage.close();
	}
	
	@Test 
	void invalidDescriptionAdd() 
	{
		TaxSchedulesPage.goTo();
		TaxSchedulesPage.addNewWithBlankDescription();
		Assert.assertTrue(TaxSchedulesPage.checkProperErrorMessage(), "Error message not displayed");
		TaxSchedulesPage.close();
	}
	
	@AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}
	
}

 




