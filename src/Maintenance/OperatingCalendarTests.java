package Maintenance;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pages.Maintenance.OperatingCalendarPage;

public class OperatingCalendarTests extends BaseTest{


	  @Test(priority = 1)
	  public void editCCDay() {
		  OperatingCalendarPage.goTo();
		  OperatingCalendarPage.editDate();
		  Assert.assertTrue(OperatingCalendarPage.checkIfEdited(), "Value not edited");
		 // OperatingCalendarPage.close();
	  }
	  
	  @Test (priority = 2)
	  public void editandCancelCCDay() {
		  OperatingCalendarPage.goTo();
		  OperatingCalendarPage.editAndCancel();
		  Assert.assertTrue(OperatingCalendarPage.checkNotEdited(), "Value not edited");
		 // OperatingCalendarPage.close();
	  }
	  
	  @Test(priority = 3)
	  public void cannotDeleteDate() {
		  OperatingCalendarPage.goTo();
		  OperatingCalendarPage.deleteCCDay();
		  Assert.assertTrue(OperatingCalendarPage.checkProperErrorMessage(), "Error message not displayed");
		 // OperatingCalendarPage.close();
	  }
	
	  @Test(priority = 4)
	  public void ccDayAlreadyExists() {
		  OperatingCalendarPage.goTo();
		  OperatingCalendarPage.addDateAgain();
		  Assert.assertTrue(OperatingCalendarPage.checkProperErrorMessage(), "Error message not displayed");
		 // OperatingCalendarPage.close();
	  }
	  
	  @AfterMethod
	  public void closeForm() {
		  OperatingCalendarPage.close();
	  }
}
