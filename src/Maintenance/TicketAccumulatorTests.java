package Maintenance;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Maintenance.TicketAccumulatorsPage;

public class TicketAccumulatorTests extends BaseTest {
	@Test 
	//To verify that the add group functionality is working properly
	void addNewRegion() 
	{
		TicketAccumulatorsPage.goTo();
		TicketAccumulatorsPage.addNew();
		Assert.assertTrue(TicketAccumulatorsPage.isAdded(), "New Region is not added");
		TicketAccumulatorsPage.deleteLastAdded();
		TicketAccumulatorsPage.close();
	}
	
	@Test 
	//To verify that the edit group functionality is working properly
	void editRegion() 
	{
		TicketAccumulatorsPage.goTo();
		TicketAccumulatorsPage.addNew();
		TicketAccumulatorsPage.close();
		TicketAccumulatorsPage.goTo();
		TicketAccumulatorsPage.editAccumulator();
		Assert.assertTrue(TicketAccumulatorsPage.isEdited(), "New Region is not updated");
		TicketAccumulatorsPage.deleteLastAdded();
		TicketAccumulatorsPage.close();
	}
	
	@Test 
	//To verify that canceling modification is working properly
	void cancelEditing() 
	{
		TicketAccumulatorsPage.goTo();
		TicketAccumulatorsPage.addNew();
		TicketAccumulatorsPage.close();
		TicketAccumulatorsPage.goTo();
		TicketAccumulatorsPage.editAndCancelAccumulator();
		//Assert.assertTrue(TicketAccumulatorsPage.isEdited(), "New Region is not updated");
		TicketAccumulatorsPage.deleteLastAdded();
		TicketAccumulatorsPage.close();
	}
	
	@Test 
	//To verify that proper error message is displayed when a duplicate entry is made
	void regionAlreadyExists() 
	{
		TicketAccumulatorsPage.goTo();
		TicketAccumulatorsPage.addNew();
		TicketAccumulatorsPage.close();
		TicketAccumulatorsPage.goTo();
		TicketAccumulatorsPage.addAccumulatorAgain();
		Assert.assertTrue(TicketAccumulatorsPage.checkProperErrorMessage(), "Error message not displayed");
		TicketAccumulatorsPage.deleteLastAdded();
		TicketAccumulatorsPage.close();
	}
	
	@Test //To verify that proper error message is displayed when description is blank
	void invalidDescriptionAdd() 
	{
		TicketAccumulatorsPage.goTo();
		TicketAccumulatorsPage.addNewWithBlankDescription();
		Assert.assertTrue(TicketAccumulatorsPage.checkProperErrorMessage(), "Error message not displayed");
		TicketAccumulatorsPage.close();
	}
}
