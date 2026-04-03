package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base_class;
import page.Page1;
import utils.ExcelUtils;
import utils.ExtentReportManager;
import utils.FormData;

public class Test1 extends Base_class {

    @DataProvider(name = "formData" )
    public Object[][] getFormData() throws IOException {
        String filePath = System.getProperty("user.dir")
                + "/test_data/formdata.xlsx";

        ExcelUtils.loadExcel(filePath, "Sheet1");

        int rowCount = ExcelUtils.getRowCount();
        Object[][] data = new Object[rowCount - 1][1];

        for (int i = 1; i < rowCount; i++) {
            utils.FormData form = new utils.FormData();

            form.firstName = ExcelUtils.getCellData(i, 0);
            form.lastName = ExcelUtils.getCellData(i, 1);
            form.address = ExcelUtils.getCellData(i, 2);
            form.email = ExcelUtils.getCellData(i, 3);
            form.phone = ExcelUtils.getCellData(i, 4);
            data[i - 1][0] = form;
        }

        ExcelUtils.closeExcel();
        return data;
    }

    @Test(dataProvider = "formData")
    public void registerUser(FormData form) {
        Page1 p = new Page1(driver);
        test = ExtentReportManager.createTest("multi Column Data Driven Test");

        p.fillForm(form);

        Assert.assertEquals(p.getFirstNameValue(), form.firstName);
    }
    
    @Test(groups = {"smoke" , "regression"})
    public void new1() {
        test = ExtentReportManager.createTest("Smoke Test - Name Entry");

        Page1 p = new Page1(driver);
        p.enterFirstName("hellooo");
        p.enterLastName("yess ss");
        String actual = p.getFirstNameValue();
        System.out.println("Actual first name = " + actual);
        Assert.assertEquals(actual, "yess ss");
    }
    
    
    @Test
    public void new2() {
    	test = ExtentReportManager.createTest("newtest2");
    	Page1 p = new Page1(driver);
    	p.enterPhone("74834838");
    	test.info("phone number is displayed");
    	String real =p.getPhoneValue();
    	Assert.assertEquals(real, "74834838");
    }
}