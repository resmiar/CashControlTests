package Maintenance;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Maintenance.TicketGroupsPage;

public class TicketGroupsTests extends BaseTest {
	@Test 
	//To verify that the add group functionality is working properly
	void addNewRegion() 
	{
		TicketGroupsPage.goTo();
		TicketGroupsPage.addNew();
		Assert.assertTrue(TicketGroupsPage.isAdded(), "New Region is not added");
		TicketGroupsPage.deleteLastAdded();
		TicketGroupsPage.close();
	}
	
	@Test 
	//To verify that the edit group functionality is working properly
	void editRegion() 
	{
		TicketGroupsPage.goTo();
		TicketGroupsPage.addNew();
		TicketGroupsPage.close();
		TicketGroupsPage.goTo();
		TicketGroupsPage.editRegion();
		Assert.assertTrue(TicketGroupsPage.isEdited(), "New Region is not updated");
		TicketGroupsPage.deleteLastAdded();
		TicketGroupsPage.close();
	}
	
	@Test 
	//To verify that canceling modification is working properly
	void cancelEditing() 
	{
		TicketGroupsPage.goTo();
		TicketGroupsPage.addNew();
		TicketGroupsPage.close();
		TicketGroupsPage.goTo();
		TicketGroupsPage.editAndCancelGroups();
		//Assert.assertTrue(TicketGroupsPage.isEdited(), "New Region is not updated");
		TicketGroupsPage.deleteLastAdded();
		TicketGroupsPage.close();
	}
	
	@Test 
	//To verify that proper error message is displayed when a duplicate entry is made
	void regionAlreadyExists() 
	{
		TicketGroupsPage.goTo();
		TicketGroupsPage.addNew();
		TicketGroupsPage.close();
		TicketGroupsPage.goTo();
		TicketGroupsPage.addGroupAgain();
		Assert.assertTrue(TicketGroupsPage.checkProperErrorMessage(), "Error message not displayed");
		TicketGroupsPage.deleteLastAdded();
		TicketGroupsPage.close();
	}
	
	@Test //To verify that proper error message is displayed when description is blank
	void invalidDescriptionAdd() 
	{
		TicketGroupsPage.goTo();
		TicketGroupsPage.addNewWithBlankDescription();
		Assert.assertTrue(TicketGroupsPage.checkProperErrorMessage(), "Error message not displayed");
		TicketGroupsPage.close();
	}
}
