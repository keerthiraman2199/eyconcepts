package eyconceptselenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandleing {

	 public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/windows");
		String windowhandle = driver.getWindowHandle();
		System.out.println("false window");
		driver.findElement(By.xpath("//button[text()='Open Home Page']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getCurrentUrl());
		Set<String> windowHandles2 = driver.getWindowHandles();
	    list.clear();
	    list.addAll(windowHandles2);
	    driver.switchTo().window(list.get(1));
	    String current = driver.getCurrentUrl();
	    System.out.println(current);
	    driver.close();
	    driver.quit();
	 }
}
