package tragetLocator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//Launch chrome driver
		ChromeDriver driver=new ChromeDriver();
		//load url
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//maximize the browser0
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement( By.xpath( "//a[text()='Merge Contacts']")).click();
		//cclicking  img tag  using xpath of img
	driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif']")).click();
	//printing current window
	String parent= driver.getWindowHandle();
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	//handle the window of creating set and list

	Set<String> windowC = driver.getWindowHandles();
	List<String> child=new ArrayList<String>(windowC);
	//switching the window to window
	driver.switchTo().window(child.get(1));
	System.out.println("switch method is done");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	//clicking the result 
	driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
	//get back to the window
	driver.switchTo().window(child.get(0));
	System.out.println("switch method is done");
	System.out.println(driver.getTitle());
	System.out.println(driver.getCurrentUrl());
	//clicking the widget by following xpath
	driver.findElement(By.xpath("((//td[@class='titleCell'])[2]//following::img)[1]")).click();
	//switch to opening window
	Set<String> window2 = driver.getWindowHandles();
	List<String> child2=new ArrayList<String>(window2);
	driver.switchTo().window(child2.get(1));
	System.out.println("switch method is done");
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
	driver.switchTo().window(child2.get(0));
	driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	//alert
	Alert alert= driver.switchTo().alert();
	alert.accept();
	Thread.sleep(5000);
	driver.quit();


	}

}
