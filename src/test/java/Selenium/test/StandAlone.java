package Selenium.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Selenium.Pageobject.LandingPage;

public class StandAlone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productname="ZARA COAT 3";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madhukar Kolekar\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
        driver.findElement(By.id("userEmail")).sendKeys("varadkolekar@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Varad@12345");
        LandingPage landingpage = new LandingPage(driver);
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
       List<WebElement>products=driver.findElements(By.cssSelector(".mb-3"));
      WebElement prod= products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname))
       .findFirst().orElse(null);
      prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
    //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
      driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		List<WebElement>cartproducts=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		//Boolean match=cartproducts.stream().anyMatch(cartproducts -> cartproducts.getText().equalsIgnoreCase(productname));
		driver.findElement(By.xpath("//li[@class='totalRow']/button")).click();
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
		Thread.sleep(5000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@class='ta-results list-group ng-star-inserted']")));
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
		driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
		String confirmMsg=driver.findElement(By.cssSelector("td[align='center'] h1")).getText();
		System.out.println(confirmMsg);
	    Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
		
		
	}

}
