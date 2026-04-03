package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import utils.FormData;

public class Page1 {
    private WebDriver driver;

    public Page1(WebDriver driver) {
        this.driver = driver;
    }

    private By firstName = By.xpath("//input[@placeholder='First Name']");
    private By lastName = By.xpath("//input[@plaeholder='Last Name']");
    private By address = By.xpath("//div/textarea[@rows='3']");
    private By email = By.xpath("//input[@type='email']");
    private By phone = By.xpath("//input[@type='tel']");

    public void enterFirstName(String value) {
        WaitUtils.waitForVisibility(driver, firstName);
        driver.findElement(firstName).sendKeys(value);
    }

    public void enterLastName(String value) {
        WaitUtils.waitForVisibility(driver, lastName);
        driver.findElement(lastName).sendKeys(value);
    }

    public void enterAddress(String value) {
        WaitUtils.waitForVisibility(driver, address);
        driver.findElement(address).sendKeys(value);
    }

    public void enterEmail(String value) {
        WaitUtils.waitForVisibility(driver, email);
        driver.findElement(email).sendKeys(value);
    }

    public void enterPhone(String value) {
        WaitUtils.waitForVisibility(driver, phone);
        driver.findElement(phone).sendKeys(value);
    }

    public void fillForm(FormData data) {
        enterFirstName(data.firstName);
        enterLastName(data.lastName);
        enterAddress(data.address);
        enterEmail(data.email);
        enterPhone(data.phone);
    }

    public String getFirstNameValue() {
        return driver.findElement(firstName).getAttribute("value");
    }
    
    public String getPhoneValue() {
    	return driver.findElement(phone).getAttribute("value");
    }
}