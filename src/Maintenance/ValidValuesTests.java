package Maintenance;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.UserLoginPage;
import Pages.Maintenance.CashControlPage;
import Pages.Maintenance.ValidValuesPage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ValidValuesTests {
 
  @BeforeTest
	@Parameters({ "Browser" })
	void testInitialize(@Optional("Firefox")String browser) {
		Browser.initialize(browser);
		UserLoginPage.goTo();
		UserLoginPage.loginWithValidCredentials();
		CashControlPage.loginToACCGroup();
	}
  
  @Test
  public void editActivityType() {
	  ValidValuesPage.goTo();
	  ValidValuesPage.selectFieldName("ActivityType");
	  ValidValuesPage.editValue();
	  ValidValuesPage.close();
	  ValidValuesPage.goTo();
	  ValidValuesPage.selectFieldName("ActivityType");
	  Assert.assertTrue(ValidValuesPage.checkIfEdited(), "Value not edited");
	  ValidValuesPage.close();
  }
  
  @Test
  public void addBagTime() {
	  ValidValuesPage.goTo();
	  ValidValuesPage.selectFieldName("BagTime");
	  ValidValuesPage.addBagTimeValue();
	  ValidValuesPage.close();
	  ValidValuesPage.goTo();
	  ValidValuesPage.selectFieldName("BagTime");
	  Assert.assertTrue(ValidValuesPage.checkIfAdded(), "Value not edited");
	  ValidValuesPage.close();
  }

  @AfterTest
	void browserClose()
	{
		Browser.instanceClose();
	}

}
