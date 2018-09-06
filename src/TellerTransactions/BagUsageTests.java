package TellerTransactions;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.TellerTransactions.BagUsagePage;
import Pages.TellerTransactions.BuildBagsPage;
import Pages.TellerTransactions.BuildBagsPage;


public class BagUsageTests {
	@Test(priority = 1)
	//Verify that returning bags is working properly
	void verifyReturnBags() {
		BagUsagePage.checkoutBag();
		BagUsagePage.goTo();
		BagUsagePage.returnBag();
		BagUsagePage.close();
		BagUsagePage.checkReturnedStatus();
	}
	
	@Test(priority = 2)
	//Verify that editing and saving is working properly
	void verifyEditAndSave() {
		BagUsagePage.checkoutBag();
		BagUsagePage.goTo();
		BagUsagePage.editAndSaveBag();
		Assert.assertTrue(BagUsagePage.isBagUpdated(),"Bag status is not updated properly");
		BagUsagePage.returnBag();
		BagUsagePage.close();
	}
	
	@Test(priority = 3)
	//Verify that cancel is working properly after editing
	void verifyCancelEditing() {
		BagUsagePage.checkoutBag();
		BagUsagePage.goTo();
		BagUsagePage.editAndCancelBag();
		Assert.assertTrue(BagUsagePage.isBagUpdated(),"Bag status is not updated properly");
		BagUsagePage.returnBag();
		BagUsagePage.close();
	}
	
}
