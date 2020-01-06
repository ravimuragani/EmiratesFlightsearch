package oneWaySearch.Emirates;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DatePicker {
	public static WebDriver driver;
	
	public WebDriver datePicker(WebDriver driver,String date) {
		List<WebElement> dates = driver.findElements(By.cssSelector("a[aria-label*='Jan 20']"));
		int count = dates.size();
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.cssSelector("a[aria-label*='Jan 20']")).get(i).getText();
			if (text.equalsIgnoreCase(date)) {
				driver.findElements(By.cssSelector("a[aria-label*='Jan 20']")).get(i).click();
				break;
			}

		}
		return driver;
	}

}
