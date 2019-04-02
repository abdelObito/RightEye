import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage {
	
	WebDriver driver;
	
	
  @Test
  public void successfulLogin () throws InterruptedException {
	  driver.findElement(By.name("email")).sendKeys("coddin@project.com");
	  driver.findElement(By.name("pw")).sendKeys("Coding@123");
	  driver.findElement(By.name("loginButton")).click();
	  String msg=driver.switchTo().alert().getText();
	  
	  Assert.assertEquals(msg,"You have logged in succesfully");
	  driver.switchTo().alert().accept();
	  driver.findElement(By.name("email")).clear();
	  driver.findElement(By.name("pw")).clear();
	  Thread.sleep(2000);
  }
  
  @Test
  public void unsuccessfulLoginIncorrectEmail () throws InterruptedException {
	  driver.findElement(By.name("email")).sendKeys("coddin@project.");
	  driver.findElement(By.name("pw")).sendKeys("somepw");
	  driver.findElement(By.name("loginButton")).click();
	  String msg=driver.switchTo().alert().getText();
	  
	  Assert.assertEquals(msg,"Wrong email adress");
	  driver.switchTo().alert().accept();
	  driver.findElement(By.name("email")).clear();
	  driver.findElement(By.name("pw")).clear();
	  Thread.sleep(2000);
  }
  
  @Test(invocationCount=2)
  public void unsuccessfulLoginIncorrectPw () throws Exception {
	  driver.findElement(By.name("email")).sendKeys("coddin@project.com");
	  driver.findElement(By.name("pw")).sendKeys("somepw");
	  driver.findElement(By.name("loginButton")).click();
	  String msg=driver.switchTo().alert().getText();
	  
	  Assert.assertEquals(msg,"Email adress and password doesn't match");
	  driver.switchTo().alert().accept();
	  driver.findElement(By.name("email")).clear();
	  driver.findElement(By.name("pw")).clear();
	  Thread.sleep(2000);
  }
  
  @Test
  public void unsuccessfulLoginIncorrectPw3Times() throws InterruptedException {
	  driver.findElement(By.name("email")).sendKeys("coddin@project.com");
	  driver.findElement(By.name("pw")).sendKeys("somepw");
	  driver.findElement(By.name("loginButton")).click();
	  String msg=driver.switchTo().alert().getText();
	  
	  Assert.assertEquals(msg,"Email adress and password doesn't match. You only have one more chance. Please contact RightEye Support at 800-301-0803");
	  driver.switchTo().alert().accept();
	  driver.findElement(By.name("email")).clear();
	  driver.findElement(By.name("pw")).clear();
	  Thread.sleep(2000);
  }
  
  @Test
  public void unsuccessfulLoginIncorrectPw4Times() throws InterruptedException {
	  driver.findElement(By.name("email")).sendKeys("coddin@project.com");
	  driver.findElement(By.name("pw")).sendKeys("somepw");
	  driver.findElement(By.name("loginButton")).click();
	  String msg=driver.switchTo().alert().getText();
	  
	  Assert.assertEquals(msg,"your Email is locked and invalid. Please contact RightEye Support at 800-301-0803");
	  driver.switchTo().alert().accept();
	  driver.findElement(By.name("email")).clear();
	  driver.findElement(By.name("pw")).clear();
	  Thread.sleep(2000);
  }
  
  @BeforeMethod
	public void beforeMethod() throws Exception {
/*		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://C:/Users/abdel/OneDrive/Bureau/Right%20Eyes/Login.html?email=coddin%40project.com&pw=fgh&login=Login#");
		Thread.sleep(3000);*/
	}

	@AfterMethod
	public void afterMethod() {
		
	}

	@BeforeTest
	public void beforeTest() throws Exception {
	//	System.setProperty("webdriver.chrome.driver", "C:\\Jars\\chromedriver.exe");
	}

	@AfterTest
	public void afterTest() {

	}
	
	@BeforeClass
	public void Initialize() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Jars\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file://C:/Users/abdel/OneDrive/Bureau/Right%20Eyes/Login.html?email=coddin%40project.com&pw=fgh&login=Login#");
		Thread.sleep(3000);
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
