package EODTransactions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.UserLoginPage;
import Pages.EODTransactions.DepositEntryPage;

public class DepositEntryTests extends BaseTest {
	
	//Add a new Deposit Entry by validating the dates
	//@Test(priority=1)
	public void AddEntry() throws Exception
	{
		DepositEntryPage.goTo();
		DepositEntryPage.addNewEntry();
		DepositEntryPage.saveEntry();
		DepositEntryPage.close();
		//DepositEntryPage.cleanupDepositEntries();		
	}
		
	//Verify All Calculations
	//@Test(priority=2)		
	public void VerifyCalculations() throws Exception
	{
		DepositEntryPage.goTo();
		DepositEntryPage.addNewEntry();
		DepositEntryPage.VerifyBillsandCoinsCalculations();
		DepositEntryPage.VerifyChecksandCCCalculations();
		DepositEntryPage.FinalCalculations();
		DepositEntryPage.close();
	}
		
		
	//Verify Existing Entries
	@Test(priority=3)
	public void VerifyExistingEntries() throws Exception
	{
		DepositEntryPage.goTo();
		DepositEntryPage.addNewEntry();
		DepositEntryPage.saveEntry();
		DepositEntryPage.VerifyExistingEntries();
		DepositEntryPage.close();
		//DepositEntryPage.cleanupDepositEntries();
	}
		

	//Edit And Verify Amount For Deposit Entry
	//@Test(priority=4)
	public void EditAndVerifyAmountForDepositEntry() throws Exception
	{
		DepositEntryPage.goTo();
		DepositEntryPage.EditAmountForExistingEntries();
		DepositEntryPage.VerifyTenderAmount();
		DepositEntryPage.close();
	}
	
	@AfterMethod
	//@Test
	public static void cleanup() {
		DepositEntryPage.cleanupDepositEntries();
	}

}
