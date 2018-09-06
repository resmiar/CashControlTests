package TellerTransactions;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.TellerTransactions.AttendanceEntryPage;
import Pages.Maintenance.CashControlPage;
import Pages.UserLoginPage;

public class AttendanceEntryTest {
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(@Optional("Firefox")String browser) throws Exception  {
	//void testInitialize(@Optional("Chrome")String browser) {
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
}
	@Test(priority=1)
	public void CloseandReopenCCDay() throws Exception
	{
		AttendanceEntryPage.goTo();
		AttendanceEntryPage.ClosedCCDay();
		AttendanceEntryPage.ReOpenCCDay();
		
	}
	@Test(priority=2)	
	public void AddNewAttendanceAndVerifyCalculations() throws Exception
	{
		AttendanceEntryPage.NewAttendanceEntry();
		AttendanceEntryPage.VerifyCalculations();
		AttendanceEntryPage.AddtoGrid();
		AttendanceEntryPage.AddmultiplePLUandVerifyCalculationsGrid();
	
	}
	@Test(priority=3)
	public void RemovePLUFromGrid()
	{
		AttendanceEntryPage.RemovePLUFromGrid();
	}
	
//		@Test(priority=4)
//		public void EditPLUFromGrid() throws Exception
//	{
//		AttendanceEntryPage.EditPLU();
//		
//	}
	
	@Test(priority=5)
	public void DeleteAttendanceBatch() throws Exception
	{
		AttendanceEntryPage.DeleteAttendanceBatch();
	}
	@Test(priority=6)
	public void VerifySpecialEvent() throws Exception
	{
		AttendanceEntryPage.VerifySpecialEvent();
		Assert.assertTrue(AttendanceEntryPage.VerifyAdded("Special Event"), "Secondary Event is not Enabled from Calendar maintenance");
		
	}
	@Test(priority=7)
	public void EntryModeAll() throws Exception
	{
		AttendanceEntryPage.EntryModeAll();
		
	}
	
	
}
