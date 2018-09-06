package Maintenance;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Maintenance.SalesRepsPage;
import Pages.Maintenance.TicketCategoriesPage;

public class TicketCategoriesTests extends BaseTest{
	@Test 
	//To verify that the edit attendance string functionality is working properly
	void checkEditingAttendanceAccount() 
	{
		TicketCategoriesPage.goTo();
		TicketCategoriesPage.editAttendanceString();
		Assert.assertTrue(TicketCategoriesPage.isEdited(), "Attendance String is not edited");
		TicketCategoriesPage.close();
	}
	
	@Test 
	//To verify that the edit attendance string functionality is working properly
	void checkEditingRevenueAccount() 
	{
		TicketCategoriesPage.goTo();
		TicketCategoriesPage.editRevenueString();
		Assert.assertTrue(TicketCategoriesPage.isEdited(), "Revenue String is not edited");
		TicketCategoriesPage.close();
	}
	
	@Test 
	//To verify that the cancel functionality is working properly
	void cancelEditing() 
	{
		TicketCategoriesPage.goTo();
		TicketCategoriesPage.editAndCancelCategory();
		Assert.assertTrue(TicketCategoriesPage.isEdited(), "Revenue String is edited");
		TicketCategoriesPage.close();
	}
    }

