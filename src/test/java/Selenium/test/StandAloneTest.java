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
import Selenium.Pageobject.ProductCatlog;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String productname="ZARA COAT 3";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madhukar Kolekar\\OneDrive\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
        LandingPage landingpage = new LandingPage(driver);
        landingpage.goTo();
        landingpage.loginPage("varadkolekar@gmail.com", "Varad@12345");
        ProductCatlog productcatlog = new ProductCatlog(driver);
        List<WebElement>products=productcatlog.getProductList();
        productcatlog.addTocart(productname);
        productcatlog.goTocartPage();
        
       
       
       
       
     
     
      
      //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
      //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
       // wait .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("[routerlink*='cart']"))));
        //wait.until(ExpectedConditions.presenceOfElementLocated(driver.findElement(By.cssSelector("[routerlink*='cart']"))));
        //driver.switchTo().alert().accept();
        Thread.sleep(5000);
     
      
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
