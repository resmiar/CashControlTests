package EODTransactions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.Maintenance.CashControlPage;
import Pages.EODTransactions.CloseOrReopenCCDayPage;
import Pages.EODTransactions.CreateJournalFilePage;
import Pages.Maintenance.OperatingCalendarPage;
import Pages.UserLoginPage;
import Pages.TellerTransactions.WeatherEntryPage;

public class CloseOrReopenCCDayTest extends BaseTest{

	//Get required dates from create journal for verifying the status of dates
	@Test(priority=1)
	public void getDaysBetweenDatesForCreateJournal() throws Exception 
	{
		
		CreateJournalFilePage.goTo();
		CreateJournalFilePage.getDaysBetweenDates();
		CreateJournalFilePage.Exit();
		
	}
	//Verify status of dates
	@Test(priority=2)
	public void VerifyDateStatus() throws Exception
	{
		OperatingCalendarPage.goTo();
		OperatingCalendarPage.CheckStatusofDates();
		OperatingCalendarPage.Exit();
	}
	
	//Add weather Entry to open dates and close those open dates
	@Test(priority=3)
	public void EnableWeatherEntryandCloseCCDay() throws Exception
	{
		WeatherEntryPage.AddnewWeatherEntries();
		CloseOrReopenCCDayPage.goTo();
		//CloseOrReopenCCDayPage.CloseCCDay();
		CloseOrReopenCCDayPage.CloseCCDaysInaWeek();
		CloseOrReopenCCDayPage.Exit();
		}
	
	//Generate Journal file 
	@Test(priority=4)
	public void GenerateJournalFile() throws Exception
	{
		CreateJournalFilePage.goTo();
		CreateJournalFilePage.generateJournalFile();
		CreateJournalFilePage.Exit();
	
		
		
	}
		
	//Verify whether date is able to reopen after create journal is sent
	@Test(priority=5)
	public void VerifyReopenDate() throws Exception 
	{
	
		CloseOrReopenCCDayPage.goTo();
		CloseOrReopenCCDayPage.ReopenCCDay();
		CloseOrReopenCCDayPage.Exit();
		
		CreateJournalFilePage.RevertChanges();

		CloseOrReopenCCDayPage.goTo();
		CloseOrReopenCCDayPage.ReopenCCDay();
	}
}