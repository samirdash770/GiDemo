package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.base;

public class validateTitle extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=initilizeDriver();
		log.info("Driver is initilized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	@Test
	  public void validateAppTitle() throws IOException{
		  
		  LandingPage l=new LandingPage(driver);
		  Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");  
		  log.info("Sucessfully validated text message");
	  }
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
	
}
