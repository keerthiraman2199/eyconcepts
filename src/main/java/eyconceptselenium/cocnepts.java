package eyconceptselenium;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cocnepts {
	 public static void main(String[] args) throws IOException, InterruptedException {

	System.setProperty("webdriver.chrome.driver","C:\\Users\\keerthi\\Downloads\\chromedriver-win64 (6)\\chromedriver-win64\\chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://letcode.in/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	driver.findElement(By.id("testing")).click();
	String ul = driver.getTitle();
	System.out.println("first page name :"+ul);
	driver.navigate().refresh();
	driver.findElement(By.xpath("//a[text()='Edit']")).click();
	driver.findElement (By.xpath("//input[contains(@type,'text') and contains (@id,'fullName')]")).sendKeys("keerthi muthuraman");
	System.out.println("sendkeys working fine");
	WebElement d = driver.findElement(By.xpath("//input[@value='I am good']"));
			d.sendKeys(Keys.TAB);
			boolean display = d.isDisplayed();
	System.out.print(display);
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));	
	String ele = driver.findElement(By.id("getMe")).getAttribute("value");
	System.out.println(ele);
	WebElement s= driver.findElement(By.cssSelector("input#clearMe"));
	s.clear();
	File frstscr= driver.getScreenshotAs(OutputType.FILE);
	File dest= new File("./another/image.png");
	FileHandler.copy(frstscr,dest);
boolean dl = driver.findElement(By.cssSelector("#noEdit")).isDisplayed();
System.out.println(dl);
WebElement f= driver.findElement(By.cssSelector("input#dontwrite"));
boolean read = f.getAttribute("value")!=null;
if(read) {
	System.out.println("This text is readonly");
}
else {
	System.out.println("This text is not readonly");
}
driver.navigate().back();
/*****************************************************************************************/
driver.findElement(By.xpath("//a[.='Click']")).click();
driver.findElement(By.id("home")).click();
driver.navigate().back();
WebElement react = driver.findElement(By.xpath("//button[.='Find Location']"));
org.openqa.selenium.Point P= react.getLocation();
int x = P.getX();
int y =P.getY();
System.out.println("x=> vvalue of x"  + x +  "value of y :" +y);
WebElement kle = driver.findElement(By.id("color"));
String color= kle.getCssValue("background-color");
System.out.println("color of the button:"+color);
org.openqa.selenium.Rectangle rt = driver.findElement(By.cssSelector("button[class='button is-success']")).getRect();
System.out.print(+rt.getHeight());
System.out.print(+rt.getWidth());
boolean ff=driver.findElement(By.id("isDisabled")).isEnabled();
System.out.println("true or fales :"+ff);
WebElement kdri = driver.findElement(By.xpath("//h2[text()='Button Hold!']"));
Actions bu = new Actions(driver);
bu.clickAndHold(kdri).build().perform();
try {
	Thread.sleep(20000);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

driver.navigate().back();
driver.findElement(By.xpath("//a[text()='Drop-Down']")).click();
WebElement se= driver.findElement(By.id("fruits"));
se.click();
Select dio = new Select(se);
dio.selectByIndex(4);
WebElement h = driver.findElement(By.xpath("//div[@class='notification is-success']//child::p"));
String k = h.getText();
System.out.println("value of selected object" +k);
WebElement Mk = driver.findElement(By.id("lang"));
Select dios = new Select(Mk);
if(dios.isMultiple()) {
	dios.selectByIndex(3);
	System.out.println("the select valud is :" +dios);}
	else {
	    System.out.println("This drop-down does not allow multiple selections.");
	}
	WebElement options = driver.findElement(By.id("country"));
	Select ok = new Select(options);
	List<WebElement> ll= ok.getOptions();
	for (WebElement mkg:ll) {
		System.out.println(mkg.getText());
	}
	
	WebElement jjj= driver.findElement(By.id("superheros"));
	Select cc= new Select(jjj);
	 cc.selectByVisibleText("Aquaman");
	 Thread.sleep(2000);
	cc.getFirstSelectedOption();
	Thread.sleep(2000);
	
	driver.navigate().back();
	driver.findElement(By.xpath("//a[text()='Dialog']")).click();
	driver.findElement(By.id("accept")).click();
	Alert alert = driver.switchTo().alert();
     alert.accept();
     Thread.sleep(1000);
	driver.findElement(By.id("confirm")).click();
	Alert al= driver.switchTo().alert();
	al.dismiss();
	Thread.sleep(1000);
	driver.findElement(By.id("prompt")).click();
	Alert gy= driver.switchTo().alert();
	gy.sendKeys("keerthi");
	String text = gy.getText();
	System.out.println(text);
	gy.accept();
	String input =  driver.findElement(By.id("myName")).getText();
	System.out.println("value of the colum is " +input);
	Thread.sleep(1000);
	driver.navigate().back();
    driver.close();
    driver.quit();
	 }

}
