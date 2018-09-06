package Maintenance;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Maintenance.TicketRebatesPage;

public class TicketRebatesTests extends BaseTest{
	
	@Test 
	//To verify that the add region functionality is working properly
	void addNewRebate() 
	{
	TicketRebatesPage.goTo();
	TicketRebatesPage.addNew();
	Assert.assertTrue(TicketRebatesPage.isAdded(), "New Region is not added");
	TicketRebatesPage.deleteLastAdded();
	TicketRebatesPage.close();
	}
	
	@Test 
	//To verify that the edit region functionality is working properly
	void editRebate() 
	{
	TicketRebatesPage.goTo();
	TicketRebatesPage.addNew();
	TicketRebatesPage.editRegion();
	Assert.assertTrue(TicketRebatesPage.isEdited(), "New Region is not updated");
	TicketRebatesPage.deleteLastAdded();
	TicketRebatesPage.close();
	}
	
	@Test 
	//To verify that canceling modification is working properly
	void cancelEditingRebate() 
	{
		TicketRebatesPage.goTo();
		TicketRebatesPage.addNew();
		TicketRebatesPage.editAndCancelRebate();
		TicketRebatesPage.deleteLastAdded();
		TicketRebatesPage.close();
	}
	
	@Test 
	//To verify that proper error message is displayed when a duplicate entry is made
	void checkGLAccountIsRequired() 
	{
		TicketRebatesPage.goTo();
		TicketRebatesPage.addWithoutGLAccount();
		Assert.assertTrue(TicketRebatesPage.checkProperErrorMessage(), "Error message not displayed");
		TicketRebatesPage.close();
	}
	
	@Test //To verify that proper error message is displayed when description is blank
		void invalidDescriptionAdd() 
		{
			TicketRebatesPage.goTo();
			TicketRebatesPage.addNewWithBlankDescription();
			Assert.assertTrue(TicketRebatesPage.checkProperErrorMessage(), "Error message not displayed");
			TicketRebatesPage.close();
		}
	}

