package oneWaySearch.Emirates;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class InvokeBrowser {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializationTest() throws IOException, InterruptedException {
		prop = new Properties();

		FileInputStream fil = new FileInputStream(
				System.getProperty("user.dir") + "\\resources\\Data.properties");
		prop.load(fil);

		String browser = prop.getProperty("Browser");

		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\resources\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} 

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(1000);

		return driver;

	}

}
