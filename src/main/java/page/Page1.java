package page;

import java.nio.channels.SelectableChannel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import utils.WaitUtils;
import utils.FormData;

public class Page1 {
    private WebDriver driver;

    public Page1(WebDriver driver) {
        this.driver = driver;
    }

    private By firstName = By.xpath("//input[@placeholder='First Name']");
    private By lastName = By.xpath("//input[@placeholder='Last Name']");
    private By address = By.xpath("//div/textarea[@rows='3']");
    private By email = By.xpath("//input[@type='email']");
    private By phone = By.xpath("//input[@type='tel']");
    private By skills = By.xpath("//select[@id='Skills']");
    private By countrydrop = By.xpath("//span[@role='combobox']");
    private By countrydrop_type = By.xpath("//input[@type='search']");
	
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
    
    public void skills_dropdown(String value_indropdown) {
    	WaitUtils.waitForVisibility(driver, skills);
    	WebElement drElement = driver.findElement(skills);
    	Select drop =new Select(drElement);
    	drop.selectByValue(value_indropdown);
    	drop.selectByIndex(2);	
	}
    
    public void country_dropdown(String nameofCountry) {
        WebElement dropdown = driver.findElement(countrydrop);

        // scroll to dropdown properly
        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);

        // actions click works better for select2
        new org.openqa.selenium.interactions.Actions(driver)
                .moveToElement(dropdown).click().perform();

        By searchBox = By.xpath("//input[@type='search']");
        WaitUtils.waitForVisibility(driver, searchBox);

        driver.findElement(searchBox).sendKeys(nameofCountry);

        By countryPrinted = By.xpath("//li[contains(text(),'" + nameofCountry + "')]");
        WaitUtils.waitForVisibility(driver, countryPrinted);
        driver.findElement(countryPrinted).click();
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
    
    public String selectedCountry_value() {
    	return driver.findElement(countrydrop).getText();
    }
}