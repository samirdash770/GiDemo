package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
		By signin=By.xpath("//span[contains(text(),'Login')]");
		By title=By.xpath("//h2[contains(text(),'Featured Courses')]");
		By navbar=By.xpath("//nav[@class='navbar-collapse collapse']");
	//By signin=By.cssSelector("a[href*=sign_in']");
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	

	public WebElement getLogin()
	{
	 return driver.findElement(signin);	
	}
	public WebElement getTitle()
	{
	 return driver.findElement(title);	
	}
	public WebElement getNavigatiobar()
	{
	 return driver.findElement(navbar);	
	}
	
}
