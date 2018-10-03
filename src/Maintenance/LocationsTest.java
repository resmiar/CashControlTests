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
import Pages.Maintenance.DashBoardPage;
import Pages.Maintenance.GLAccountsPage;
import Pages.Maintenance.LocationsPage;

public class LocationsTest {

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
		LocationsPage.cleanup();
		Browser.instanceClose();
	}
	
	//Adding New AC
	@Test(priority=1)
	public void AddAC() throws Exception
	{
		GLAccountsPage.goTo();
		GLAccountsPage.ActivateACDescription();
		GLAccountsPage.Exit();
		LocationsPage.goTo();
		LocationsPage.createNewAC();
		Assert.assertTrue(LocationsPage.isAdded(),"Not Added" );
		
	}
	//Editing AC
	@Test(priority=2)
	public void EditAc() throws Exception
	
	{
		LocationsPage.EditAC();
		Assert.assertTrue(LocationsPage.isEdited(),"Not Edited" );
		LocationsPage.SelectACAndScrollDown();
	}
	
	//Removing AC
	@Test(priority=3)
	public void RemoveAC() throws Exception 
	{
		LocationsPage.AddAC();
		LocationsPage.RemoveACConfirmErrorMsg();
		
		//LocationsPage.RemoveAC();
	}
	//Select Location Code
	@Test(priority=4)
	public void SelectLocationCode() throws Exception
	{
		//LocationsPage.goTo();
		LocationsPage.SelectLocationCode();
	
	}
	//Add multiple Sales 
	//@Test(priority=4,invocationCount=7)
	//@Test(priority=4)
	public void AddMultipleSalesDesignations()
	{
		LocationsPage.AddMultipleSalesDesignations();
		
		}
	//Save Multiple Sales Designation
	@Test(priority=5)
	public void SaveMultipleSalesDesignations()
	{
		LocationsPage.ScrollUpAndSaveSalesDesignation();
		
		}
	//Moving Sales designation record to top
	@Test(priority=7)
	public void MoveToTop()
	{
		LocationsPage.MoveToTop();
	}
	//Disable the Location
	@Test(priority=9)
	public void DisableLocationActive() 
	{
		LocationsPage.DisableLocationActive();
		LocationsPage.exitPage();
		
}
	
	
	@Test(priority=8)
	public void SameACDifferentSalesCategory() throws Exception
	{
		//LocationsPage.AddAC();
		LocationsPage.SameACCodeDifferentSalesCategory();
		//LocationsPage.exitPage();
		
	}
}
