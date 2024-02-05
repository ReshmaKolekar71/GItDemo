package Selenium.testcomponents;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	
	
	public void InitialiseBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madhukar Kolekar\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
	}
}
