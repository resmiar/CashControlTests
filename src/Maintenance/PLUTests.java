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
import Pages.Maintenance.PLUsPage;

public class PLUTests extends BaseTest{
 
  //@Test
  public void addEditAndDeletePLU() {
	  PLUsPage.goTo();
	  PLUsPage.addNewPLU();
	  Assert.assertTrue(PLUsPage.checkIfAdded(), "Value not added");
	  PLUsPage.editPLU();
	  Assert.assertTrue(PLUsPage.checkIfEdited(), "Value not edited");
	  PLUsPage.deletePLU();
	  PLUsPage.close();
  }
  
  
  //@Test
  public void cannotRemoveLastTicketPart() {
	  PLUsPage.goTo();
	  PLUsPage.clickEdit();
	  PLUsPage.deleteTicketPart();
	  Assert.assertTrue(PLUsPage.checkTheMessage(), "Message not correct");
	  PLUsPage.cancelEditing(); 
	  PLUsPage.close();
  }
  
  //@Test
  public void cannotSaveDuplicatePLUs() {
	  PLUsPage.goTo();
	  PLUsPage.addNewPLU();
	  PLUsPage.addPLUAgain();
	  Assert.assertTrue(PLUsPage.verifyErrorMessage(), "Message not correct");
	  PLUsPage.close();
	  PLUsPage.goTo();
	  PLUsPage.deletePLU(); 
	  PLUsPage.close();
  }
  
  
  @Test
  public void verifyPerTicketValues() {
	  PLUsPage.goTo();
	  PLUsPage.clickAdd();
	  PLUsPage.setValuesForTaxAndRebate();
	  Assert.assertTrue(PLUsPage.checkCalculationForNoTax(), "Message not correct");
	  Assert.assertTrue(PLUsPage.checkCalculationForTaxIncluded(), "Message not correct");
	  Assert.assertTrue(PLUsPage.checkCalculationForPlusTax(), "Message not correct");
	  PLUsPage.cancelEditing();
	  PLUsPage.close();
  }

 

}
