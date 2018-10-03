package TellerTransactions;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Initialization.DatabaseConnection;
import Pages.TellerTransactions.AttendanceEntryPage;
import Pages.Maintenance.BagTypePage;
import Pages.Maintenance.CashControlPage;
import Pages.Maintenance.DashBoardPage;
import Pages.UserLoginPage;

public class AttendanceEntryTest {
	
	@BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(@Optional("Firefox")String browser){
		System.out.println("browser passed as :- " + browser);
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		Assert.assertTrue(CashControlPage.isAt());
		CashControlPage.loginToACCGroup();
		Assert.assertTrue(DashBoardPage.isAt());
	}
	
	@AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}
	
	//@Test(priority=1)
	public void CloseandReopenCCDay() throws Exception
	{
		AttendanceEntryPage.goTo();
		AttendanceEntryPage.ClosedCCDay();
		AttendanceEntryPage.ReOpenCCDay();
		
	}
	@Test(priority=2)	
	public void AddNewAttendanceAndVerifyCalculations() throws Exception
	{
		AttendanceEntryPage.goTo();
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
	
		@Test(priority=4)
		public void EditPLUFromGrid() throws Exception
	{
		AttendanceEntryPage.EditPLU();
		
	}
	
	@Test(priority=5)
	public void DeleteAttendanceBatch() throws Exception
	{
		AttendanceEntryPage.DeleteAttendanceBatch();
	}

	@Test(priority=7)
	public void EntryModeAll() throws Exception
	{
		AttendanceEntryPage.EntryModeAll();
		
	}
	
	
}
