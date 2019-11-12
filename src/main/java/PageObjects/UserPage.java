package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserPage {
	// declare WebDriver as global
	public WebDriver driver;

	// initialize parameterized constructor
	public UserPage(WebDriver driver) {
		this.driver = driver;
	}

	By username = By.xpath("//span[@class='fs-dropdown__login']");
	public WebElement getUserName() {
		return driver.findElement(username);
	}

}
