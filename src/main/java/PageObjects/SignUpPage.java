package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPage {
	//declare WebDriver as global
		public WebDriver driver;

		//initialize parameterized constructor
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	    By close=By.xpath("//div[@class='fs-tooltip__ui']//i[@class='c-icon c-icon--plus']");
		By email=By.xpath("//div[@class='registration-form']//input[@name='email']");
		By contbtn=By.xpath("//div[@class='m-form__group']//button[text()='Continue']");
		By firstName=By.name("firstName");
		By lastName=By.name("lastName");
		By phone=By.name("phone");
		By password=By.xpath("//div[@class='registration-form']//input[@name='password']");
		//List<WebElement> checkBoxes=driver.findElements(By.xpath("//span[@class='c-checkbox-filter__checkmark']"));
		By promotion=By.xpath("//div[@class='m-form__group'][2]/div/label/span[@class='c-checkbox-filter__checkmark']");
		By terms=By.xpath("//div[@class='m-form__group'][3]/div/label/span[@class='c-checkbox-filter__checkmark']");
		By submitBtn=By.xpath("//button[text()='Create account']");
		
		public WebElement getClose() {
			return driver.findElement(close);
		}
		public WebElement getEmail() {
			return driver.findElement(email);
		}
		public WebElement getContinueBtn() {
			return driver.findElement(contbtn);
		}
		public WebElement getFirstName() {
			return driver.findElement(firstName);
		}
		public WebElement getLastName() {
			return driver.findElement(lastName);
		}
		public WebElement getPhone() {
			return driver.findElement(phone);
		}
		public WebElement getPassword() {
			return driver.findElement(password);
		}
		public WebElement getPromotion() {
			return driver.findElement(promotion);
		}
		public WebElement getTerms() {
			return driver.findElement(terms);
		}
		public WebElement getSubmitBtn() {
			return driver.findElement(submitBtn);
		}
		
		
}
