<<<<<<< HEAD
/*
 * Page object class supporting operations on Homepage
 * Class is responsible for finding properties according to
 * location criteria.
 */

=======
>>>>>>> 9215f8baa6e2d0ee8475b4372cc4dfd04f066bf4
package HostelworldFramework.pageObjects;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage
//public class Homepage
{	
	WebDriver driver;
	WebDriverWait wait;
	
	String homePageUrl = "http://t.hostelworld.com";
	WebElement searchTextField;
	WebElement searchButton;
<<<<<<< HEAD
	WebElement cityName;
	WebElement search; 
=======
	WebElement startDatePicker;
	WebElement endDatePicker;
	WebElement cityName;
>>>>>>> 9215f8baa6e2d0ee8475b4372cc4dfd04f066bf4
	
	
	String searchTextFieldXpath =   ".//*[@id='home-search-keywords']";
	String searchButtonXpath = ".//*[@id='sb-search']/div[3]/div/button";
<<<<<<< HEAD
	String cityNameXpath = ".//*[@id='ui-id-3']/a";

	
	// Non-parameter page constructor
	public Homepage()
	{
		System.out.println("Homepage default constructor");
	}
	
	// Page constructor with paramater
=======
	String cityNameXpath = ".//*[@id='ui-id-15']/a";
	String startDatePickerXpath = ".//*[@id='P1195177706']";
	String endDatePickerXpath = ".//*[@id='P1175181954']";

	
	//  Default page constructor
	public Homepage()
	{
		System.out.println("Homepage default constructor");
		wait = new WebDriverWait(driver, 60);
	}
	
	// Page constructor
>>>>>>> 9215f8baa6e2d0ee8475b4372cc4dfd04f066bf4
	public Homepage(WebDriver driver)
	{
		System.out.println("Homepage constructor");
		this.driver = driver;
<<<<<<< HEAD
=======
		
>>>>>>> 9215f8baa6e2d0ee8475b4372cc4dfd04f066bf4
	}
	
	public String getHomepageUrl()
	{
		return homePageUrl;
	}
	
<<<<<<< HEAD
	/*
	 * This method puts the word 'dublin' into the input text field then clicks on 'Dublin, Ireland' in
	 * the predictive view.  It then clicks the 'Search' button
	 */
	public void propertySearch(String searchString)
	{
		System.out.println("Method 'propertySearch' running");
		wait = new WebDriverWait(driver,10);
=======
	public void propertySearch(String searchString)
	{
		System.out.println("Method 'propertySearch' running");
		wait = new WebDriverWait(driver, 60);
>>>>>>> 9215f8baa6e2d0ee8475b4372cc4dfd04f066bf4
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("home-search-keywords")));  // until input box is found
		searchTextField = driver.findElement(By.id("home-search-keywords"));
		searchTextField.click();
        searchTextField.sendKeys(searchString);
<<<<<<< HEAD
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cityNameXpath)));
        cityName = driver.findElement(By.xpath(cityNameXpath));
        cityName.click();
        search = driver.findElement(By.xpath(searchButtonXpath));
        search.click();
	}
=======
        cityName = driver.findElement(By.xpath(cityNameXpath));
        cityName.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("P1195177706")));
        startDatePicker = driver.findElement(By.id("P1195177706"));
        startDatePicker.sendKeys("08/06/2016");
        endDatePicker = driver.findElement(By.id("P1175181954"));
        endDatePicker.sendKeys("15/06/2016");
        WebElement search = driver.findElement(By.xpath(searchButtonXpath));
        search.click();
	}
	

>>>>>>> 9215f8baa6e2d0ee8475b4372cc4dfd04f066bf4
}
