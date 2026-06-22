package com.qa.testscripts;

import java.util.Map;

import org.testng.annotations.Test;

import com.qa.page.ParaBankRegisterPage;
import com.qa.utility.ReadExcel;

public class ParaBankRegisterTest extends TestBase {

    @Test
	public void registerUsers() throws InterruptedException {
	
	    ReadExcel excel =new ReadExcel();
	    excel.loadExcel("C:\\Users\\Abhi\\Downloads\\Parabank_Register_TestData_100Records.xlsx\\");
	    ParaBankRegisterPage registerPage =new ParaBankRegisterPage(driver);
	
	    int rowCount =
	            excel.getRowCount("Register");
	
	    for(int i=1;
	        i<=rowCount;
	        i++) {
	
	        Map<String,String> data =excel.getRowData("Register",i);
	
	        if(data.get("Register").equalsIgnoreCase("Yes")) {
	
	            registerPage.registerUser(data);
	            
	            
	            String actualMessage = registerPage.getRegistrationSuccessMessage();
	            
	            
	            if(actualMessage.contains("Welcome")) {
	            	System.out.println("Registration Successfull for User: "+data.get("Username"));
	            	Thread.sleep(2000);
	            	registerPage.logout();
	            	driver.get("https://parabank.parasoft.com/parabank/register.htm");
	            }else {
	            	System.out.println("Registration failed for User: "+data.get("Username"));
	
	            }
	
	            System.out.println("Registered User : "+ data.get("Username"));
	
	        } else {
	
	            //System.out.println("Skipped User : "+ data.get("Username"));
	        }
	    }
	
	    excel.closeWorkbook();
	}
}