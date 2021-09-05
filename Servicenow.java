package LearnframeAlerts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Servicenow {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://dev113545.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement frame=driver.findElementByXPath("(//div[@class='navpage-main-left ng-isolate-scope'])/iframe");
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("w6hnF2FRhwLC");
        driver.findElement(By.id("sysverb_login")).click();
        WebElement we=driver.findElement(By.xpath("//input[@id='filter']"));
        we.sendKeys("incident",Keys.PAGE_DOWN);
        //WebElement we1=driver.findElementByXPath("//div[@id='nav_west_center']");
        /*JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("we1.scrollBy(0,400)"," ");*/
        driver.findElement(By.xpath("(//div[@class='sn-widget-list-title' and text()='All'])[2]")).click();
        WebElement frame1=driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
        driver.switchTo().frame(frame1);
        
         driver.findElement(By.xpath("//button[text()='New']")).click();
         //driver.switchTo().frame(frame1);
         Thread.sleep(2000);
           driver.findElement(By.xpath("(//span[@class='input-group-btn'])[1]")).click();
           Thread.sleep(3000);
           Set<String> windowhandleset=driver.getWindowHandles();
           List<String> windowhandlelist = new ArrayList<String>(windowhandleset);
           driver.switchTo().window(windowhandlelist.get(1));
           Thread.sleep(3000);
           driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
           
        
           Thread.sleep(3000);
           driver.switchTo().window(windowhandlelist.get(0));
           driver.switchTo().frame(frame1);
           String num=driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("Value");
           System.out.println("The incident no is: "+num);
           /*JavascriptExecutor js=(JavascriptExecutor) driver;
           js.executeScript("window.scrollBy(0,600)");*/
           driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Test");
           driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
           WebElement num1=driver.findElement(By.xpath("//input[@class='form-control'][1]"));
           num1.sendKeys(num,Keys.ENTER);
           String srhnum=driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
           
           if (srhnum.equals(num))
           {
        	   System.out.println("The number is same and the incident is created");
           }
           else
           {
        	   System.out.println("The number is not same and the incident is created");
           }
           
           File src1=driver.getScreenshotAs(OutputType.FILE);
   		File dst=new File("./snaps/incident.png");
   		FileUtils.copyFile(src1, dst);
	
           driver.close();
           
           
           
           



        
        
        //driver.findElement(By.xpath("//b[text()='All']")).click();
        
	}

}
