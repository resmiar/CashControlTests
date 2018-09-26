package TellerTransactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.Maintenance.BagTypePage;
import Pages.TellerTransactions.BuildBagsPage;
import Pages.TellerTransactions.CheckoutBagsPage;

public class CheckoutBagsTests extends BaseTest{
	@Test(priority = 1)
	//Verify that checkout is working properly for Park assigned bags
	void verifyCheckoutForParkAssignedBags() {
		CheckoutBagsPage.BuildBagForCheckout();
		CheckoutBagsPage.goTo();
		CheckoutBagsPage.selectBadgeAndLoc();
		CheckoutBagsPage.selectBag();
		CheckoutBagsPage.saveCheckout();
		Assert.assertTrue(CheckoutBagsPage.isBagCheckedOut(),"Bag is not checked out properly");
		CheckoutBagsPage.close();
	}
	
	@Test(priority = 2)
	//Verify that checkout is working properly for system created bags
	void verifyCheckoutForSystemBags() {
		CheckoutBagsPage.goTo();
		CheckoutBagsPage.selectBadgeAndLoc();
		CheckoutBagsPage.selectSystemBag(1);
		CheckoutBagsPage.saveCheckout();
		Assert.assertTrue(CheckoutBagsPage.isBagCheckedOut(),"Bag is not checked out properly");
		CheckoutBagsPage.close();
	}
	
	@Test(priority = 3)
	//Verify that checkout is working properly with recent location
	void verifyCheckoutWithRecentLocation() {
		CheckoutBagsPage.goTo();
		CheckoutBagsPage.selectBadgeAndRecentLoc();
		CheckoutBagsPage.selectSystemBag(1);
		CheckoutBagsPage.saveCheckout();
		Assert.assertTrue(CheckoutBagsPage.isBagCheckedOut(),"Bag is not checked out properly");
		CheckoutBagsPage.close();
	}
	
	@Test(priority = 4)
	//Verify that checkout of multiple bags
	void verifyMultipleBagsCheckout() {
		CheckoutBagsPage.goTo();
		CheckoutBagsPage.selectBadgeAndLoc();
		CheckoutBagsPage.selectSystemBag(2);
		CheckoutBagsPage.saveCheckout();
		Assert.assertTrue(CheckoutBagsPage.isBagCheckedOut(),"Bag is not checked out properly");
		CheckoutBagsPage.close();
	}	
}
