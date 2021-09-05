package LearnframeAlerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame1=driver.findElementById("frame1");
		driver.switchTo().frame(frame1);
	    driver.findElementByXPath("//input[@type='text']").sendKeys("Myname is Sri");
	    //driver.switchTo().frame(frame1);
	    WebElement frame=driver.findElementById("frame3");
	    driver.switchTo().frame(frame);
	    driver.findElementById("a").click();
	    driver.switchTo().defaultContent();
	    WebElement frame2= driver.findElementById("frame2");
	    driver.switchTo().frame(frame2);
	    driver.findElementByXPath("//option[@value='big baby cat']").click();
	    
		

	}

}
