package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.google.common.io.Files;

public class base {
	public static WebDriver driver;
	public Properties prop;
	public WebDriver initilizeDriver() throws IOException
    
{
   prop = new Properties();
   FileInputStream fis=new FileInputStream("C:\\Users\\samer\\E2EProject\\src\\main\\java\\resources\\data.properties");
   prop.load(fis);
   String browsername=prop.getProperty("browser");
   System.out.println(browsername);
   
   if(browsername.equals("chrome"))
   {
	   System.setProperty("webdriver.chrome.driver", "D:\\workplace\\chromedriver.exe");
	driver=new ChromeDriver();
		
   }
   else if(browsername.equals("firefox"))
   {
	   System.setProperty("webdriver.gecko.driver", "D:\\workplace\\geckodriver.exe");
		 driver=new FirefoxDriver();
   }
   else if(browsername.equals("IE") )
   {
	   System.setProperty("webdriver.ie.driver","D:\\workplace\\MicrosoftWebDriver.exe");
	   driver=new InternetExplorerDriver();
   }
   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    return driver;
}
	public void getScreenshot(String result) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(src, new File("C:\\test\\"+result+"Screenshot.png"));
		
	}
}
	
	

