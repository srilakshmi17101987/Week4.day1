package LearnframeAlerts;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class framesandscreenshots {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		File src1=driver.getScreenshotAs(OutputType.FILE);
		File dst=new File("./snaps/set.png");
		FileUtils.copyFile(src1, dst);
		List<WebElement> list=driver.findElements(By.xpath("//div[@id='wrapframe']"));
		int size= list.size();
		System.out.println("The no of outer frames: "+size);
		List<WebElement> list1=driver.findElements(By.xpath("//div[@id='wrapframe']/iframe[@src='default.html']"));
		int size1= list1.size();
		System.out.println("is the no of nested frame"+size1);
		List<WebElement> list2=driver.findElements(By.xpath("//div[@id='wrapframe']/iframe[@src='countframes.html']"));
		int size2= list2.size();
		System.out.println("is the no of nested frame"+size2);
		

	}

}
