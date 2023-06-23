package testNGMethods;

import org.testng.annotations.DataProvider;

public class DataproviderMethod {
	
	@DataProvider(name="loginData")
    public static Object[][] getDataFromDataprovider(){
	    Object [] [] loginCredentials =  
	    	{
	            { "sampletest@test.com", "Test123" },
	            { "sampletest774@test.com", "Test123" },
	            { "sampletest934@test.com", "Test123" }
	        };
	    return loginCredentials;

    }
}
