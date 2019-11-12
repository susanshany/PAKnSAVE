package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaknSaveHomePage {
	// declare WebDriver as global
	public WebDriver driver;

	// initialize parameterized constructor
	public PaknSaveHomePage(WebDriver driver) {
		// initialize local driver with parameter
		this.driver = driver;
	}

	// initialize LogInOrRegister with cssLocator
	By logInOrRegister = By.cssSelector("span[class*='login']");

	By signUp = By.xpath("//a[text()='Sign up']");
	By close = By.xpath("//div[@class='fs-tooltip__ui']//i[@class='c-icon c-icon--plus']");
	By email = By.xpath("//form[@class='login-form__body login-form m-form']//input[@name='email']");
	By password = By.xpath("//form[@class='login-form__body login-form m-form']//input[@name='password']");
	By loginBtn = By.xpath("//button[text()='Login']");

	// method to send WebElement of LogIn or Register
	public WebElement getLogInOrRegister() {
		return driver.findElement(logInOrRegister);
	}

	//
	public WebElement getSignUp() {
		return driver.findElement(signUp);
	}

	public WebElement getClose() {
		return driver.findElement(close);
	}

	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogInBtn() {
		return driver.findElement(loginBtn);
	}
}
