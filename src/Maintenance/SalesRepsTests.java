package Maintenance;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.UserLoginPage;
import Pages.Maintenance.CashControlPage;
import Pages.Maintenance.SalesRepsPage;

public class SalesRepsTests extends BaseTest {

	@Test 
	//To verify that the add region functionality is working properly
	void addNewRegion() 
	{
		SalesRepsPage.goTo();
		SalesRepsPage.addNew();
		Assert.assertTrue(SalesRepsPage.isAdded(), "New Region is not added");
		SalesRepsPage.deleteLastAdded();
		SalesRepsPage.close();
	}
	
	@Test 
	//To verify that the edit region functionality is working properly
	void editRegion() 
	{
		SalesRepsPage.goTo();
		SalesRepsPage.addNew();
		SalesRepsPage.close();
		SalesRepsPage.goTo();
		SalesRepsPage.editRegion();
		Assert.assertTrue(SalesRepsPage.isEdited(), "New Region is not updated");
		SalesRepsPage.deleteLastAdded();
		SalesRepsPage.close();
	}
	
	@Test 
	//To verify that canceling modification is working properly
	void cancelEditing() 
	{
		SalesRepsPage.goTo();
		SalesRepsPage.addNew();
		SalesRepsPage.close();
		SalesRepsPage.goTo();
		SalesRepsPage.editAndCancelRegion();
		Assert.assertTrue(SalesRepsPage.isEdited(), "New Region is not updated");
		SalesRepsPage.deleteLastAdded();
		SalesRepsPage.close();
	}
	
	}


