package Maintenance;
import org.testng.annotations.Test;
import Pages.Maintenance.GLAccountsPage;

public class GLAccountsTests extends BaseTest{
	
	@Test
	  public void editAndSaveGLCompany() {
		  GLAccountsPage.goTo();
		  GLAccountsPage.editAndSaveCompany();
		  GLAccountsPage.Exit();
		  
	  }

	@Test
	  public void openImportform() {
		  GLAccountsPage.goTo();
		  GLAccountsPage.openImportForm();
		  GLAccountsPage.Exit();
		  
	  }
	  
	  @Test
	  public void editAndCancelGLCompany() {
		  GLAccountsPage.goTo();
		  GLAccountsPage.editAndCancelCompany();
		  GLAccountsPage.Exit();  
		  
	  }
	@Test
	  public void viewDepartment() {
		  GLAccountsPage.goTo();
		  GLAccountsPage.viewDepartment();
		  GLAccountsPage.Exit();
		  
	  }
	@Test
	  public void viewActivityCenter() {
		  GLAccountsPage.goTo();
		  GLAccountsPage.viewActivityCenter();
		  GLAccountsPage.Exit();
		  
	  }
}
