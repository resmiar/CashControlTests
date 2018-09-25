package Maintenance;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Initialization.Browser;
import Pages.UserLoginPage;
import Pages.Maintenance.CashControlPage;
import Pages.Maintenance.GLAccountsPage;
import Pages.Maintenance.LocationsPage;

public class LocationsTest extends BaseTest {

	
	//Adding New AC
	@Test(priority=2)
	public void AddAC()
	{
		LocationsPage.AddAC();
		Assert.assertTrue(LocationsPage.isAdded(),"Not Added" );
		
	}
	//Editing AC
	@Test(priority=3)
	public void EditAc() throws Exception
	
	{
		LocationsPage.EditAC();
		Assert.assertTrue(LocationsPage.isEdited(),"Not Edited" );
		LocationsPage.SelectACAndScrollDown();
	}
	
	//Removing AC
	@Test(priority=6)
	public void RemoveAC() throws Exception 
	{
		LocationsPage.RemoveACConfirmErrorMsg();
		
		//LocationsPage.RemoveAC();
	}
	//Select Location Code
	@Test(priority=1)
	public void SelectLocationCode() throws Exception
	{
	LocationsPage.goTo();
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
	@Test(priority=8)
	public void DisableLocationActive() 
	{
		LocationsPage.DisableLocationActive();
		LocationsPage.exitPage();
		
}
	
	
	@Test(priority=9)
	public void SameACDifferentSalesCategory()
	{
		LocationsPage.AddAC();
		LocationsPage.SameACCodeDifferentSalesCategory();
	}
}
