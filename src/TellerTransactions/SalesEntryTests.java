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

public class SalesEntryTests extends BaseTest{

	//Entry with Closed and New CC Date
	//@Test(priority=1)
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
		SalesEntryPage.checkoutBag();
		SalesEntryPage.goTo();
		SalesEntryPage.selectBag();
		SalesEntryPage.NewCalculations();
		SalesEntryPage.RegisterVerifyCalculations();
		SalesEntryPage.ACDetailsAndActCenterDetailsCalculations();
		SalesEntryPage.CancelEntries();
	
	}
	
	//Add a new Entry
	@Test(priority=3)
	public void AddNewToExistingEntries() throws Exception
	{
		SalesEntryPage.selectBag();
		SalesEntryPage.NewCalculations();
		SalesEntryPage.SaveNewEntries();
		SalesEntryPage.AddNewtoExistingEntry();
		SalesEntryPage.NewCalculations();
		SalesEntryPage.SaveNewEntries();	
	}
	
	//Edit Entry Calculations
	@Test(priority=4)
	public void EditToExistingEntries() throws Exception
	{
		SalesEntryPage.EditExistingEntry();
		SalesEntryPage.EditedCalculations();
		SalesEntryPage.ACDetailsAndActCenterDetailsCalculations();
		SalesEntryPage.SaveEntries();	
	}
	
}
