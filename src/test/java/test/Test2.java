package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Base_class;
import page.Page1;
import utils.ExtentReportManager;

public class Test2 extends Base_class {
	@Test (priority = 2)
    public void new2() {
    	test = ExtentReportManager.createTest("newtest2");
    	Page1 p = new Page1(driver);
    	p.enterPhone("74834838");
    	test.info("phone number is displayed");
    	p.enterAddress("shsdsdnns,sdjssdjsdsn");
    	p.enterLastName("cdfsdsds");
    	String real =p.getPhoneValue();
    	Assert.assertEquals(real, "74834838");
    }

	@Test(priority = 1)
	public void SKill_Dropdown_check() throws InterruptedException {
		test = ExtentReportManager.createTest("It is a dropdown check");
		Page1 p =new Page1(driver);
		p.skills_dropdown("C++");
		
		p.country_dropdown("India");
		Thread.sleep(3000);
		Assert.assertEquals(p.selectedCountry_value(), "India");
	}
}
