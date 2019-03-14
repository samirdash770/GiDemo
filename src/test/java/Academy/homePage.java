package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class homePage extends base {
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initilize() throws IOException
	{
		driver=initilizeDriver();
		
	}
  @Test(dataProvider="getdata")
  public void validateAppHomePage(String username,String password) throws IOException{
	 
	  driver.get(prop.getProperty("url"));
	  //inheritance
	  //creating object to that class and invoke method to it
	   
	  LandingPage l=new LandingPage(driver);
	  l.getLogin().click();
	  
	  LoginPage lp= new LoginPage(driver);
	  lp.getemail().sendKeys(username);
	  lp.getpassword().sendKeys(password);
	  lp.getlogin().click();
	  log.info("Invalid credential should be displayed");
  }
  @DataProvider
  public Object[][] getdata(){
	  //row stands for how many different test data should run
	  //column stands for how many values for each test
	  Object[][] data=new  Object[2][2];
	  //0th row
	  data[0][0]="sam@gmail.com";
	  data[0][1]="123456";
      //1st row
      data[1][0]="Rahul@gmail.com";
	  data[1][1]="56789";
	  
	  return data;
  }
  @AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
  
}
