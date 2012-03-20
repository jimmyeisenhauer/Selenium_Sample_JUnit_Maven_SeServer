package twitter;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.*;

public class TwitterSearchTest {

	public WebDriver driver;
	
	@Before
	public void setUp() throws Exception  {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		// implicit time out searching for all elements will try for 20 seconds
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    // And now use this to visit twitter
        driver.get("http://twitter.com/#!/search-home");
        
	}

	@After
	public void tearDown()  {
		// ends the session
		 driver.quit();
		 
	}

	@Test
	public void testTwitterRegenceSearch() {
		 // Find the text input element by its name
        WebElement searchBox = driver.findElement(By.name("q"));

        // Enter something to search for
        searchBox.sendKeys("Regence");

        // Now submit the form. WebDriver will find the form for us from the element
        searchBox.submit();

        // Find the text element that contains the search title
        WebElement searchResult = driver.findElement(By.className("js-tweet-text"));
        		
        // Output the Search Title content on the page
        System.out.println("The first tweet on the page says: " + searchResult.getText());
        
        
        // Output the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
       // assert that Results for Regence contains regence
       // if it doesn't show the test would fail.
       // try changing the search term above or the expected text below to watch it fail
        
         Assert.assertTrue("Search result should contain regence",searchResult.getText().toLowerCase().contains("regence"));
		
	}
	
	@Test
	public void testTwitterSearchFail() {
		 // Find the text input element by its name
        WebElement searchBox = driver.findElement(By.name("q"));

        // Enter something to search for
        searchBox.sendKeys("Cambia");

        // Now submit the form. WebDriver will find the form for us from the element
        searchBox.submit();

        // Find the text element that contains the search title
        WebElement searchResult = driver.findElement(By.className("js-tweet-text"));
        		
        // Output the Search Title content on the page
        System.out.println("The first tweet on the page says: " + searchResult.getText());
        
        
        // Output the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
       // assert that Results for Regence contains regence
       // if it doesn't show the test would fail.
       // try changing the search term above or the expected text below to watch it fail
        
         Assert.assertTrue("Search result should contain cambia",searchResult.getText().toLowerCase().contains("cambia"));
		
	}

}
