package oneWaySearch.Emirates;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LowestPriceFlightNumber extends InvokeBrowser {
	public WebDriver driver;

	@Test
	public void oneWayFlightSearch() throws InterruptedException {

		driver.get(prop.getProperty("EmiratesURL"));
		PomOneWaySearch po = new PomOneWaySearch(driver);
		po.arrivalAirport().sendKeys(prop.getProperty("ArrivalStation"));
		po.arrivalAirport().sendKeys(Keys.DOWN, Keys.ENTER);
		try {
			Thread.sleep(1000);
			
			//Browser taking long time to load while using automation hence wait time increased
			WebDriverWait w = new WebDriverWait(driver, 10);
			DatePicker dp = new DatePicker();
			dp.datePicker(driver, prop.getProperty("Date"));
			po.oneWayCheckBox().click();
			po.submit().click();
			w.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_c_lnkContinue")));
			
			//best lowest price displayed in flight page
			System.out.println("Lowest Price is: " + po.lowestPrice().getText());
			
			//best price flight filtered hence same selected as best flight
			System.out.println("Lowest price filght number is: " + po.lowestPriceFlight().getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterTest
	public void tearDown() {
		driver.close();
		driver = null;
	}

	@BeforeTest
	public void tearUp() throws IOException, InterruptedException {
		driver = initializationTest();
	}

}
