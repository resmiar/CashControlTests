package TellerTransactions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.TellerTransactions.BagUsagePage;
import Pages.TellerTransactions.BuildBagsPage;
import Pages.Maintenance.CashControlPage;
import Pages.TellerTransactions.CheckInBagsPage;
import Pages.TellerTransactions.TenderEntryPage;
import Pages.UserLoginPage;

public class TenderEntryTest extends BaseTest{
	
	//Add a new Tender Entry by validating the dates
	//@Test(priority=1)
	public void AddEntry() throws Exception
	{
		TenderEntryPage.goTo();
		TenderEntryPage.Exit();
		//TenderEntryPage.AddEntryClosedCCDate();
		TenderEntryPage.NewCCDate();
		//TenderEntryPage.AddNewTenderEntry();
		TenderEntryPage.Exit();
	}
	
	//Verify All Calculations
	@Test(priority=2)
	public void VerifyCalculations() throws Exception
	{
		TenderEntryPage.checkOutBagForTrans();
		TenderEntryPage.goTo();
		TenderEntryPage.AddNewTenderEntry();
		TenderEntryPage.VerifyBillsandCoinsCalculations();
		TenderEntryPage.VerifyChecksandCCCalculations();
		TenderEntryPage.VerifyARandScripsCalculations();
		TenderEntryPage.FinalCalculations();
	}
	//Verify Bag Checkout and Employees Page is displayed or not
	@Test(priority=3)
	public void VerifyBagCheckoutAndEmployees() throws Exception
	{
		TenderEntryPage.VerifyEmployees();
		TenderEntryPage.VerifyBagCheckOut();
		
	}
	
	//Verify Existing Entries
	@Test(priority=4)
	public void VerifyExistingEntries() throws Exception
	{
		TenderEntryPage.VerifyExistingEntries();
	}
	
//Verify CheckIn Bag	
@Test(priority=5)
public void VerifyCheckin() throws Exception
{
	TenderEntryPage.Exit();
	CheckInBagsPage.goTo();
	CheckInBagsPage.CheckInBag();
	CheckInBagsPage.Exit();
}
//Verify Check In Date
@Test(priority=6)
public void VerifyCheckInDate() throws Exception
{
	TenderEntryPage.GetCurrentCCDate();
	BagUsagePage.goTo();
	BagUsagePage.VerifyCheckInDates();
}

//Edit And Verify Amount For Tender Entry
@Test(priority=7)
public void EditAndVerifyAmountForTenderEntry() throws Exception
{
	BagUsagePage.EditAmountForExistingTenderEntries();
	BagUsagePage.Exit();
	BagUsagePage.goTo();
	BagUsagePage.VerifyTenderAmount();
	BagUsagePage.Exit();
}
//Verify Empty Bag in Build Bags Page
@Test(priority=8)
public void VerifyEmptyBag() throws Exception
{
	BuildBagsPage.goTo();
	BuildBagsPage.VerifyEmptyBag();
	BuildBagsPage.ConvertToBuit();
	BuildBagsPage.Exit();
	
}
	
}

