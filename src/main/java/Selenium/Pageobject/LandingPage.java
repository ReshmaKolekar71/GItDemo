package Selenium.Pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium.Abstractcomponents.AbstractComponents;

public class LandingPage extends AbstractComponents {
	WebDriver driver;
	
	
public LandingPage(WebDriver driver)

{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	


	//WebElement useremail=driver.findElement(By.id("userEmail"));
//driver.findElement(By.id("userPassword"))
//Using pagefactory
	
	@FindBy(id="userEmail")
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	public void loginPage(String emial,String password)
	{
		useremail.sendKeys(emial);
		passwordEle.sendKeys(password);
		submit.click();
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
}
