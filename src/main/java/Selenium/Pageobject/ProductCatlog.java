package Selenium.Pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Selenium.Abstractcomponents.AbstractComponents;

public class ProductCatlog extends AbstractComponents{
	WebDriver driver;
	
	
public ProductCatlog(WebDriver driver)
{
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	


	// List<WebElement>products=driver.findElements(By.cssSelector(".mb-3"));
//Using pagefactory
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="[routerlink*='cart']")
	WebElement spinner;
	
	
	
	By productBy=By.cssSelector(".mb-3");
	By addTocart= By.cssSelector(".card-body button:last-of-type");
	By toast =By.cssSelector("#toast-container");
	
	
	
	public List<WebElement> getProductList()
	{
		waitForElementAppear(productBy);
		return products;
	}
	public WebElement getProductname(String productname)
	{
		 WebElement prod= getProductList().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productname))
			       .findFirst().orElse(null);
		 return prod;
	}
	
	public void addTocart(String productname) 
	{
		WebElement prod= getProductname( productname);
		prod.findElement(addTocart).click();
		waitForElementAppear(toast);
		waitForElementClickable(spinner);
		
		
		}
	
	
	
	
	
	
}
