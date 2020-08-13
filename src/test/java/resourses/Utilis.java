package resourses;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utilis {
	
	static RequestSpecification   req;
	
	public static RequestSpecification requestSpecification() throws Exception
	{
		if(req==null) {
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
		

		  req =new RequestSpecBuilder().setBaseUri(getGlobalData("baseURI")).addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
	}
	
	public static String getGlobalData(String key) throws  Exception
	{
		FileInputStream fi = new FileInputStream("E:\\Selenium_Practice\\APITesting\\src\\test\\java\\resourses\\global.properties");
		Properties prop=new Properties();
		prop.load(fi);
	return	prop.getProperty(key);
		
	}
	
	public static String getJsonPath(Response response, String key)
	{
		String responseString=response.asString();
    	JsonPath js=new JsonPath(responseString);
    	return js.get(key).toString();
	}

}
