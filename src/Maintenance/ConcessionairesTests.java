package Maintenance;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import Pages.Maintenance.ConcessionairesPage;

public class ConcessionairesTests extends BaseTest {
	@Test(priority = 0) 
	//To verify that the add region functionality is working properly
	void addNewRegion() 
	{
		ConcessionairesPage.goTo();
		ConcessionairesPage.addNew();
		Assert.assertTrue(ConcessionairesPage.isAdded(), "New Region is not added");
		ConcessionairesPage.deleteLastAdded();
		//ConcessionairesPage.close();
	}
	
	@Test(priority = 1) 
	//To verify that the edit region functionality is working properly
	void editRegion() 
	{
		ConcessionairesPage.goTo();
		ConcessionairesPage.addNew();
		ConcessionairesPage.editRegion();
		ConcessionairesPage.close();
		ConcessionairesPage.goTo();
		Assert.assertTrue(ConcessionairesPage.isEdited(), "New Region is not updated");
		ConcessionairesPage.deleteLastAdded();
		//ConcessionairesPage.close();
	}
	
	@Test(priority = 2) 
	//To verify that canceling modification is working properly
	void cancelEditing() 
	{
		ConcessionairesPage.goTo();
		ConcessionairesPage.addNew();
		ConcessionairesPage.editAndCancelRegion();
		Assert.assertTrue(ConcessionairesPage.isEdited(), "New Region is not updated");
		ConcessionairesPage.deleteLastAdded();
		//ConcessionairesPage.close();
	}
	
	@AfterMethod
	void closeForm() {
		ConcessionairesPage.close();
	}
}
