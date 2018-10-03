package Maintenance;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Initialization.Browser;
import Pages.UserLoginPage;
import Pages.Maintenance.BagTypePage;
import Pages.Maintenance.CashControlPage;

public class BagTypeTests extends BaseTest{

	
	 @Test(priority=0)
	  public void AddBagTypeDetails(){
		BagTypePage.goTo();
		BagTypePage.AddBagTypeDetails();
		
	 }
	 @Test(priority=1)
	 public void VerifyBagValue()
	 {
		 BagTypePage.CheckBagValue();
			BagTypePage.VerifySum(); 
	 }
	 
	 

		 
		 
		 @Test(priority=2)
		 public void CreateBagId() throws Exception 
		 {
	 	
	 	 BagTypePage.CreateBagId();
	 	 BagTypePage.CreateduplicateBagIdVerify();
	 	 BagTypePage.CountBagBuilt();
	 	 BagTypePage.ConvertToBuilt();
	 	 BagTypePage.goTo();
	 	 BagTypePage.VerifyBagBuilt();
	 	 
	 
		 
		 }
		 
		 @Test(priority=3)
		 public void deleteAddedBag() {
			 BagTypePage.deleteAddedBag();
		 }
	 

 
 
		@Test(priority=4)
		public void AddNewBagTypeDesc() throws Exception
		{
		
		BagTypePage.NewBagTypeDescription();
	    Assert.assertTrue(BagTypePage.isAdded()," New description is not added");
				 
		}
	 
	 
	 @Test(priority=5)
	 public void EditBagTypeDescription()
	 {

	 BagTypePage.EditBagTypeDescription();
	 Assert.assertTrue(BagTypePage.isEdited(), "BagType Description is not edited");

	 }
	 
	 
	 @Test(priority=6)
	 public void DeleteBagTypeDescription()
	 {

	 BagTypePage.DeleteBagTypeDescription();

	 }
	 
	 
	 @Test(priority=7)
	 public void ExitBagType()
	 {

	 BagTypePage.ExitPage();
	 
	 
	  }
	 
	 

}

