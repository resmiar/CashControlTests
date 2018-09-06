package TellerTransactions;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.TellerTransactions.AttendanceEntryPage;
import Pages.Maintenance.CashControlPage;
import Pages.Maintenance.OptionsPage;
import Pages.TellerTransactions.SalesEntryPage;
import Pages.UserLoginPage;

public class SalesEntryTests {
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(@Optional("Firefox")String browser) throws Exception  {
	//void testInitialize(@Optional("Chrome")String browser) {
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
}
	//Entry with Closed and New CC Date
	@Test(priority=1)
	public void ClosedCCDateandNewCCDate() throws Exception
	{
		SalesEntryPage.goTo();
		SalesEntryPage.ItemSelectionClosedCCDate();
		SalesEntryPage.ItemSelectionNewCCDate();
	}
	
	//Verify Calculations
	@Test(priority=2)
	public void VerifyCalculations() throws Exception
	{
		SalesEntryPage.NewCalculations();
		SalesEntryPage.RegisterVerifyCalculations();
		SalesEntryPage.ACDetailsAndActCenterDetailsCalculations();
		SalesEntryPage.CancelEntries();
	
	}
	
	//Add a new Entry
	@Test(priority=3)
	public void AddNewToExistingEntries() throws Exception
	{
		SalesEntryPage.AddNewtoExistingEntry();
		SalesEntryPage.NewCalculations();
		SalesEntryPage.RegisterVerifyCalculations();
		SalesEntryPage.ACDetailsAndActCenterDetailsCalculations();
		SalesEntryPage.SaveEntries();	
	}
	
	//Edit Entry Calculations
	@Test(priority=4)
	public void EditToExistingEntries() throws Exception
	{
		SalesEntryPage.EditExistingEntry();
		SalesEntryPage.EditedCalculations();
		SalesEntryPage.RegisterVerifyCalculations();
		SalesEntryPage.ACDetailsAndActCenterDetailsCalculations();
		SalesEntryPage.SaveEntries();	
	}
	//Verify Special Event
	@Test(priority=5)
	public void VerifySpecialEvent() throws Exception
	{
		
		SalesEntryPage.VerifySpecialEvent();
		Assert.assertTrue(SalesEntryPage.VerifyAdded("Special Event"), "Secondary Event is not Enabled from Calendar maintenance");
	}
	
	//Verify Exclusive used Location
	@Test(priority=6)
	public void AddExclusiveLocation() throws Exception
	{ 
		SalesEntryPage.VerifyExclusiveUsedLoc();
	}
	
	//Verify Auto Sales
	@Test(priority=7)
	public void VerifyAutoSales() throws Exception
	{ 
		SalesEntryPage.AutoSalesEnable();
		SalesEntryPage.VerifyAutoSales();
		
	}
	
	//Verify System Options
	@Test(priority=8)
	public void VerifySystemOptions() throws Exception
	{
		OptionsPage.goTo();
		OptionsPage.EnableTransactionsCheckboxes();
		SalesEntryPage.goTo();
		SalesEntryPage.VerifySystemOptions();
	}
					
}
