package Maintenance;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Maintenance.EmployeesPage;

public class EmployeesTests extends BaseTest{
	@Test 
	//To verify that the add region functionality is working properly
	void addNewEmployee() 
	{
		EmployeesPage.goTo();
		EmployeesPage.addNew();
		Assert.assertTrue(EmployeesPage.isAdded(), "New Region is not added");
		EmployeesPage.deleteLastAdded();
		EmployeesPage.close();
	}
	
	@Test 
	//To verify that the edit region functionality is working properly
	void editEmployee() 
	{
		EmployeesPage.goTo();
		EmployeesPage.addNew();
		EmployeesPage.close();
		EmployeesPage.goTo();
		EmployeesPage.editEmployees();
		Assert.assertTrue(EmployeesPage.isEdited(), "New Region is not updated");
		EmployeesPage.deleteLastAdded();
		EmployeesPage.close();
	}
	
	@Test 
	//To verify that canceling modification is working properly
	void cancelEditing() 
	{
		EmployeesPage.goTo();
		EmployeesPage.addNew();
		EmployeesPage.close();
		EmployeesPage.goTo();
		EmployeesPage.editAndCancelEmployee();
		Assert.assertTrue(EmployeesPage.isEdited(), "New Region is not updated");
		EmployeesPage.deleteLastAdded();
		EmployeesPage.close();
	}
	
	@Test 
	//To verify that proper error message is displayed when a duplicate entry is made
	void eIDAlreadyExists() 
	{
		EmployeesPage.goTo();
		EmployeesPage.addNew();
		EmployeesPage.close();
		EmployeesPage.goTo();
		EmployeesPage.addEmployeeAgain();
		Assert.assertTrue(EmployeesPage.checkProperErrorMessage(), "Error message not displayed");
		EmployeesPage.deleteLastAdded();
		EmployeesPage.close();
	}
	
	@Test //To verify that proper error message is displayed when description is blank
	void invalidDescriptionAdd() 
	{
		EmployeesPage.goTo();
		EmployeesPage.addNewWithBlankDescription();
		Assert.assertTrue(EmployeesPage.checkProperErrorMessage(), "Error message not displayed");
		EmployeesPage.close();
	}
	
	@Test //To verify that proper error message is displayed when description is blank
	void cannotSaveMoreThanOneActiveBadges() 
	{
		EmployeesPage.goTo();
		EmployeesPage.addNew();
		EmployeesPage.addBadgeAgain();
		Assert.assertTrue(EmployeesPage.checkProperErrorMessage(), "Error message not displayed");
		EmployeesPage.close();
	}
}
