package LearnframeAlerts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/selectable.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		Actions builder=new Actions(driver);
		WebElement src=driver.findElement(By.xpath("//li[text()='Item 1']"));
		
		
		builder.moveToElement(src).perform();
		builder.click().perform();
		
		List<WebElement> list=driver.findElements(By.className("ui-widget-content ui-selectee"));
        System.out.println(list.size());
		
	}

}
