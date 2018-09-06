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
import Pages.Maintenance.TendersPage;

public class TendersTests extends BaseTest{
	
  
  @Test
  public void addNewTenderToAR() {
	  TendersPage.goTo();
	  TendersPage.addNewTenderToAR();
	  TendersPage.viewNewlyAddedTender();
	  TendersPage.editTenderInAR();
	  Assert.assertTrue(TendersPage.checkIfEdited(), "Value not edited");
	  TendersPage.deleteTenderFromAR();
	  TendersPage.close();
  }
  
  @Test
  public void addAnExchangeRate() {
	  TendersPage.goTo();
	  TendersPage.selectUSDollar();
	  TendersPage.openExchangeRateForm();
	  TendersPage.addNewRate();
	  Assert.assertTrue(TendersPage.checkIfRateAdded(), "Value not added");
	  TendersPage.closeRateForm();
	  TendersPage.close();
  }


}

