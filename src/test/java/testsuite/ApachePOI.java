package testsuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApachePOI {
	WebDriver driver;
	XSSFWorkbook wBook;
	XSSFSheet sheet;
	
	@BeforeMethod
	public void setUp() throws IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Full Stack\\Java Workspace\\TestngProject\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
//		System.setProperty("webdriver.gecko.driver", "D:\\Full Stack\\Java Workspace\\WebDriverProject\\drivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();
		
		
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize(); // to maximize the browser window.
		
		//wait time before executing any of the other command
//		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		FileInputStream fis = new FileInputStream("exceldata.xlsx");
		wBook = new XSSFWorkbook(fis);
		sheet = wBook.getSheet("data");
	}
	
	
	@Test
	public void login() {
		WebElement loginLink = driver.findElement(By.className("login"));
		loginLink.click();
	
		
		String Username1 = sheet.getRow(0).getCell(0).getStringCellValue();
		String Passward1 = sheet.getRow(0).getCell(1).getStringCellValue();
		System.out.println(Username1);
		
		WebElement tbEmail = driver.findElement(By.name("user_login"));
		tbEmail.sendKeys(Username1);
		
		WebElement pwdElement = driver.findElement(By.name("user_pwd"));
		pwdElement.sendKeys(Passward1);
		
		WebElement rmElement = driver.findElement(By.className("rememberMe"));
		rmElement.click();
		
		WebElement btnLogin = driver.findElement(By.name("btn_login"));
		btnLogin.click();
		
		  WebElement error = driver.findElement(By.id("msg_box"));
	        
	        String actMsg = error.getText();
	        String expMsg = "The email or password you have entered is invalid.";
	        
	        Assert.assertEquals(expMsg, actMsg);


	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
