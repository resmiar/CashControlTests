package TellerTransactions;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.TellerTransactions.AttendanceEntryPageAR;

public class AttendanceEntryTests {
	
	@Test(priority = 1)
	//Verify that the add new attendance batch feature is working properly
	void verifyAddingNewAttendanceBatchAndDeleting() {
		AttendanceEntryPageAR.goTo();
		AttendanceEntryPageAR.addNewBatch();
		Assert.assertTrue(AttendanceEntryPageAR.isBatchAdded(),"Batch is not added properly");
		AttendanceEntryPageAR.deleteLastAddedBatch();
		AttendanceEntryPageAR.close();
		
	}
	
	@Test(priority = 2)
	//Verify that the edit existing attendance batch feature is working properly
	void verifyEditingAttendanceBatch() {
		AttendanceEntryPageAR.goTo();
		AttendanceEntryPageAR.addNewBatch();
		AttendanceEntryPageAR.editLastAddedBatch();
		Assert.assertTrue(AttendanceEntryPageAR.isBatchEdited(),"Batch is not edited properly");
		AttendanceEntryPageAR.deleteLastAddedBatch();
		AttendanceEntryPageAR.close();
		
	}
	
	@Test(priority = 3)
	//Verify that the cancel button works fine for adding and editing attendance batches
	void verifyCancelWorksProperly() {
		AttendanceEntryPageAR.goTo();
		AttendanceEntryPageAR.addAndCancel();
		AttendanceEntryPageAR.addNewBatch();
		AttendanceEntryPageAR.editAndCancelBatch();
		Assert.assertTrue(AttendanceEntryPageAR.isBatchNotEdited(),"Batch is edited");
		AttendanceEntryPageAR.deleteLastAddedBatch();
		AttendanceEntryPageAR.close();
	}
	
	@Test(priority = 4)
	//Verify that the PLU's as loaded based on the PLU type selected
	void verifyPLUsAreLoaded() {
		
	}
	
	@Test(priority = 5)
	//Verify that the fields are enabled based on the Entry Type selected
	void verifyEntryModes() {
		AttendanceEntryPageAR.goTo();
		Assert.assertTrue(AttendanceEntryPageAR.checkEntryModeQtyOnly(), "Fields not enabled properly for Qty only entry mode");
		Assert.assertTrue(AttendanceEntryPageAR.checkEntryModeAll(), "Fields not enabled properly for 'All' entry mode");
		AttendanceEntryPageAR.close();
	}

	@Test(priority = 6)
	//Verify that add PLU button is working properly in add and edit mode
	void verifyAddPLUsButton() {
		AttendanceEntryPageAR.goTo();
		AttendanceEntryPageAR.clickAdd();
		Assert.assertTrue(AttendanceEntryPageAR.verifyAddEnabledForAdd(),"Add button not enabled when entering amount value");
		AttendanceEntryPageAR.createAndAddPLU();
		Assert.assertTrue(AttendanceEntryPageAR.verifyAddEnabledForEdit(),"Add button not enabled when entering amount value");
		AttendanceEntryPageAR.close();	
	}
	
	@Test(priority = 7)
	//Verify that remove PLU button is working properly in add and edit mode
	void verifyRemovePLUsButton() {
		AttendanceEntryPageAR.goTo();
		Assert.assertTrue(AttendanceEntryPageAR.verifyRemoveEnabledForAdd(),"Remove button not enabled when entering amount value");
		AttendanceEntryPageAR.createAndAddPLU();
		Assert.assertTrue(AttendanceEntryPageAR.verifyRemoveEnabledForEdit(),"Remove button not enabled when entering amount value");
		AttendanceEntryPageAR.close();
	}
	
	@Test(priority = 8)
	//Verify that clear PLU button is working properly in add and edit mode
	void verifyClearPLUsButton() {
		AttendanceEntryPageAR.goTo();
		Assert.assertTrue(AttendanceEntryPageAR.verifyClearButtonEnabled(),"Clear button not enabled");
		AttendanceEntryPageAR.close();
	}
	
	@Test(priority = 9)
	//Verify that calculation is proper for the Tax included PLU
	void verifyCalculationForTaxIncluded() {
		AttendanceEntryPageAR.goTo();
		AttendanceEntryPageAR.createAndAddPLU("TaxIncluded");
		Assert.assertTrue(AttendanceEntryPageAR.verifyTaxCalculation("TaxIncluded"),"Calculation Not proper for Tax included");
		AttendanceEntryPageAR.close();
	}
	
	@Test(priority = 10)
	//Verify that calculation is proper for the PlusTax PLU
	void verifyCalculationForPlusTax() {
		AttendanceEntryPageAR.goTo();
		AttendanceEntryPageAR.createAndAddPLU("PlusTax");
		Assert.assertTrue(AttendanceEntryPageAR.verifyTaxCalculation("PlusTax"),"Calculation Not proper for Plus Tax");
		AttendanceEntryPageAR.close();
	}
	
	@Test(priority = 10)
	//Verify that calculation is proper for the Not Taxable PLU
	void verifyCalculationForNotTaxable() {
		AttendanceEntryPageAR.goTo();
		AttendanceEntryPageAR.createAndAddPLU("NoTax");
		Assert.assertTrue(AttendanceEntryPageAR.verifyTaxCalculation("NoTax"),"Calculation Not proper for Not Taxable");
		AttendanceEntryPageAR.close();
	}
	
	@Test(priority = 11)
	//Verify that total is displayed correctly
	void verifyTotals() {
		AttendanceEntryPageAR.goTo();
		AttendanceEntryPageAR.createAndAddPLU();
		AttendanceEntryPageAR.addAPLUToGrid(); 
		Assert.assertTrue(AttendanceEntryPageAR.verifyTotalsAreCorrect(),"Totals are not correct");
		AttendanceEntryPageAR.close();
	}
	
	@Test(priority = 12)
	//Verify that save is disabled when there is no PLU added
	void verifySaveDisabledWhenNoPLU() {
		AttendanceEntryPageAR.goTo();
		AttendanceEntryPageAR.clickAdd();
		Assert.assertTrue(AttendanceEntryPageAR.verifySaveIsDisabled(),"Save button not disabled");
		AttendanceEntryPageAR.createAndAddPLU();
		AttendanceEntryPageAR.removePLU();
		Assert.assertTrue(AttendanceEntryPageAR.verifySaveIsDisabled(),"Save button not disabled");
		AttendanceEntryPageAR.close();
	}
}
