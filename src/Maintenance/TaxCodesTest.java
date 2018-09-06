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
import Pages.Maintenance.TaxCodesPage;

public class TaxCodesTest {
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(@Optional("Firefox")String browser) {
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
	} 
	
	@Test 
	void addNewRegion() 
	{
		TaxCodesPage.goTo();
		TaxCodesPage.addNew();
		Assert.assertTrue(TaxCodesPage.isAdded(), "New Region is not added");
		TaxCodesPage.deleteLastAdded();
		TaxCodesPage.close();
	}
	
	@Test 
	void editRegion() 
	{
		TaxCodesPage.goTo();
		TaxCodesPage.addNew();
		TaxCodesPage.close();
		TaxCodesPage.goTo();
		TaxCodesPage.editRegion();
		//Assert.assertTrue(TaxCodesPage.isEdited(), "New Region is not updated");
		TaxCodesPage.close();
		TaxCodesPage.goTo();
		TaxCodesPage.deleteLastAdded();
		TaxCodesPage.close();
	}
	
	@Test 
	void cancelEditing() 
	{
		TaxCodesPage.goTo();
		TaxCodesPage.addNew();
		TaxCodesPage.close();
		TaxCodesPage.goTo();
		TaxCodesPage.editAndCancelRegion();
		Assert.assertTrue(TaxCodesPage.isEdited(), "New Region is not updated");
		TaxCodesPage.deleteLastAdded();
		TaxCodesPage.close();
	}
	@Test 
	void regionAlreadyExists() 
	{
		TaxCodesPage.goTo();
		TaxCodesPage.addNew();
		TaxCodesPage.close();
		TaxCodesPage.goTo();
		TaxCodesPage.addRegionAgain();
		Assert.assertTrue(TaxCodesPage.checkProperErrorMessage(), "Error message not displayed");
		TaxCodesPage.deleteLastAdded();
		TaxCodesPage.close();
	}
	
	@Test 
	void invalidDescriptionAdd() 
	{
		TaxCodesPage.goTo();
		TaxCodesPage.addNewWithBlankDescription();
		Assert.assertTrue(TaxCodesPage.checkProperErrorMessage(), "Error message not displayed");
		TaxCodesPage.close();
	}
	
	@AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}
	
}

 
