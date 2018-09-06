package TellerTransactions;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Initialization.Browser;
import Pages.Maintenance.CashControlPage;
import Pages.UserLoginPage;
import Pages.TellerTransactions.WeatherEntryPage;

public class WeatherEntryTest extends BaseTest{
	
	
	//Edit the weather and verifying the selected weather is correct or not
	@Test(priority=1)
	public void EditWeather() throws Exception
	{
		WeatherEntryPage.goTo();
		WeatherEntryPage.EditWeather();
	
	}
	
	//Edit the temperature and verifying the selected temperature is correct or not
	@Test(priority=2)
	public void EditTemperature() throws Exception
	{
		
	WeatherEntryPage.Temp();
}
	
	//Exiting the page
	@Test(priority=3)
	public void Exit()
	{
		WeatherEntryPage.Exit();
	}
}

