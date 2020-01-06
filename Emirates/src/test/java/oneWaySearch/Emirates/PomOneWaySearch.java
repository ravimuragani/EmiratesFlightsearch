package oneWaySearch.Emirates;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomOneWaySearch {
	


	public WebDriver driver;

	public PomOneWaySearch(WebDriver driver)

	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='Arrival airport']")
	private WebElement arrivalAirport;

	@FindBy(css = "input[class*='js-one-way']")
	private WebElement oneWayCheckBox;

	@FindBy(xpath = "//button[contains(@class,'js-widget-submit')]")
	private WebElement submit;

	@FindBy(xpath = "//span[@class='summary-curr-only']")
	private WebElement lowestPrice;

	@FindBy(className = "ts-fip__aircraft")
	private WebElement lowestPriceFlight ;

	@FindBy(css = "a[aria-label*='Jan 20']")
	private WebElement Save;

	public WebElement arrivalAirport() {
		return arrivalAirport;
	}

	public WebElement oneWayCheckBox() {
		return oneWayCheckBox;
	}

	public WebElement submit() {
		return submit;
	}

	public WebElement lowestPrice() {
		return lowestPrice;
	}

	public WebElement lowestPriceFlight() {
		return lowestPriceFlight;
	}


}
