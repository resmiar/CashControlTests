package TellerTransactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.Maintenance.BagTypePage;
import Pages.TellerTransactions.BuildBagsPage;
import Pages.TellerTransactions.CheckoutBagsPage;

public class BuildBagsTests extends BaseTest {

	@Test(priority = 1)
	//Verify that the details and bags are properly displayed for bag type
	void verifyBagTypeisDisplayed() {
		BagTypePage.goTo();
		BagTypePage.createBagTypeForTellerTransaction();
		BagTypePage.close();
		BuildBagsPage.goTo();
		BuildBagsPage.selectBagType();
		Assert.assertTrue(BuildBagsPage.isBagTypeDisplayed(),"Bag type is not displayed properly");
		Assert.assertTrue(BuildBagsPage.isBagMakeUpCorrect(),"Bag type is not displayed properly");
		BuildBagsPage.close();		
	}
	
	@Test(priority = 2)
	//Verify that bag status is updated as built after moving it to 'Built'  list and saving
	void verifyBagBuilt() {
		BuildBagsPage.goTo();
		BuildBagsPage.selectBagType();
		BuildBagsPage.buildOnebag();
		Assert.assertTrue(BuildBagsPage.isBagStatusUpdated(),"Bag status is not updated properly");
		BuildBagsPage.close();
	}

	@Test(priority = 3)
	//Verify that bag status is updated as empty after moving it to 'Empty' list and saving
	void verifyBagMadeEmpty() {
		BuildBagsPage.goTo();
		BuildBagsPage.selectBagType();
		BuildBagsPage.buildOnebag();
		BuildBagsPage.emptyOnebag();
		Assert.assertTrue(BuildBagsPage.isBagStatusUpdated(),"Bag status is not updated properly");
		BuildBagsPage.close();
	}
	
	@Test(priority = 4)
	//Verify that checked out bags are displayed in the 'Checked out'  list
	void verifyBagCheckedOut() throws InterruptedException {
		BuildBagsPage.goTo();
		BuildBagsPage.selectBagType();
		BuildBagsPage.buildOnebag();
		BuildBagsPage.close();
		Thread.sleep(3000);
		CheckoutBagsPage.goTo();
		BuildBagsPage.checkoutbagToCheckStatus();
		CheckoutBagsPage.close();
		BuildBagsPage.goTo();
		BuildBagsPage.selectBagType();
		Assert.assertTrue(BuildBagsPage.isCheckedOutBagDisplayed(),"Bag status is not updated properly");
		BuildBagsPage.close();
	}
	
	@Test(priority = 5)
	//Verify that cancel button is working properly
	void verifyCancelBuildBags() {
		BuildBagsPage.goTo();
		BuildBagsPage.selectBagType();
		BuildBagsPage.buildAndCancel();
		Assert.assertTrue(BuildBagsPage.isChangesNotSaved(),"Cancel is not proper");
		BuildBagsPage.close();
	}
}


