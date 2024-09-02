package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumMethods {

	public static void main(String[] args) throws InterruptedException, IOException {

		System.setProperty("webdriver.chrome.driver", "D:\\Srikanth\\Automation\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(1000);
		String x=driver.getTitle();
		System.out.println(x);
		if(x.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"))
		{
			System.out.println("test passed");
		}
		
		/*  Dropdown
		WebElement dropdown=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
		Select s=new Select(dropdown);
		s.selectByIndex(2);
		*/
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("apple",Keys.ENTER);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions a=new Actions(driver);
		WebElement iphone=driver.findElement(By.xpath("//span[text()='Apple iPhone 13 (128GB) - Starlight']"));
		WebElement addToCart=driver.findElement(By.xpath("(//button[text()='Add to cart'])[7]"));
		wait.until(ExpectedConditions.visibilityOf(iphone));
		//    JS  Scroll Down
		//js.executeScript("arguments[0].scrollIntoView(true);", iphone);
		driver.manage().window().maximize();
		Thread.sleep(4000);
		a.moveToElement(addToCart).build().perform();
		Thread.sleep(2000);
		a.click(iphone).build().perform();
		Thread.sleep(2000);
		// SwithToWindow
		/*
		Set<String> windowhandles=driver.getWindowHandles();
		System.out.println(windowhandles);
		driver.switchTo().window("13B7C40C60ED72531C8C79D09DA1A8DA");
		*/
		File Src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\\\Srikanth\\\\Automation\\\\ScreenShots\\\\ss1.png");
		FileUtils.copyDirectory(Src, dest);
		a.dragAndDrop(iphone, addToCart);
		
		//Updated comments
		
		
		
		
		
		
		
		

	}

}
