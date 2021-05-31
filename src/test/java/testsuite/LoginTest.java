package testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest {
	WebDriver driver;
		
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "D:\\Full Stack\\Java Workspace\\TestngProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "D:\\Full Stack\\Java Workspace\\WebDriverProject\\drivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize(); // to maximize the browser window.
		
//		wait time before executing any of the other command
//		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
	}
	
////	@Parameters({"username","passward"})
	@Test
	public void loginpage() {
		
		WebElement loginLink = driver.findElement(By.className("login"));
		loginLink.click();

		WebElement tbEmail = driver.findElement(By.name("user_login"));
		tbEmail.sendKeys("omkar@gmail.com");
		
		WebElement pwdElement = driver.findElement(By.name("user_pwd"));
		pwdElement.sendKeys("12345");
		
		WebElement rmElement = driver.findElement(By.className("rememberMe"));
		rmElement.click();
		
		WebElement btnLogin = driver.findElement(By.name("btn_login"));
		btnLogin.click();
		
		  WebElement error = driver.findElement(By.id("msg_box"));
	        
	        String actMsg = error.getText();
	        String expMsg = "The email or password you have entered is invalid.";
	        
	        Assert.assertEquals(expMsg, actMsg);

	}
//	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
