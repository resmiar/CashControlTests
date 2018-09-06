package Maintenance;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Maintenance.TicketClassesPage;

public class TicketClassesTests extends BaseTest{
	@Test 
	//To verify that the edit attendance string functionality is working properly
	void checkEditingAttendanceAccount() 
	{
		TicketClassesPage.goTo();
		TicketClassesPage.editAttendanceString();
		Assert.assertTrue(TicketClassesPage.isEdited(), "Attendance String is not edited");
		TicketClassesPage.close();
	}
	
	@Test 
	//To verify that the edit attendance string functionality is working properly
	void checkEditingRevenueAccount() 
	{
		TicketClassesPage.goTo();
		TicketClassesPage.editRevenueString();
		Assert.assertTrue(TicketClassesPage.isEdited(), "Revenue String is not edited");
		TicketClassesPage.close();
	}
	
	@Test 
	//To verify that the cancel functionality is working properly
	void cancelEditing() 
	{
		TicketClassesPage.goTo();
		TicketClassesPage.editAndCancelClasses();
		Assert.assertTrue(TicketClassesPage.isEdited(), "Revenue String is edited");
		TicketClassesPage.close();
	}
}
