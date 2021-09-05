package LearnframeAlerts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mergecontacts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		driver.findElement(By.xpath("(//img[@src=\"/images/fieldlookup.gif\"])[1]")).click();
		Set<String> windowhandleset = driver.getWindowHandles();
		List<String> windowhandlelist = new ArrayList<String>(windowhandleset);
		driver.switchTo().window(windowhandlelist.get(1));
		System.out.println(driver.getTitle());

		driver.findElementByXPath("//input[@name='firstName']").sendKeys("sri");
		driver.findElementByXPath("//button[text()='Find Contacts']").click();
		driver.findElementByXPath("(//a[text()='Srilakshmi'])[1]").click();
		driver.switchTo().window(windowhandlelist.get(0));
		driver.findElement(By.xpath("(//img[@src=\"/images/fieldlookup.gif\"])[2]")).click();
		Set<String> windowhandleset1 = driver.getWindowHandles();
		List<String> windowhandlelist1 = new ArrayList<String>(windowhandleset1);
		driver.switchTo().window(windowhandlelist1.get(1));
		System.out.println(driver.getTitle());
		driver.findElementByXPath("//input[@name='firstName']").sendKeys("sri");
		driver.findElementByXPath("//button[text()='Find Contacts']").click();
		driver.findElementByXPath("(//a[text()='Srilakshmi'])[2]").click();
		driver.switchTo().window(windowhandlelist1.get(0));
		Thread.sleep(2000);
		driver.findElementByXPath("(//a[contains(text(),'Merge')])[2]").click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.getTitle());

	}

}
