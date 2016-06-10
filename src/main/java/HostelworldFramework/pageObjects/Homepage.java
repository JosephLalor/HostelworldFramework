/*
 * Page object class supporting operations on Homepage
 * Class is responsible for finding properties according to
 * location criteria.
 */

package HostelworldFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Homepage
{	
	WebDriver driver;
	WebDriverWait wait;
	
	String homePageUrl = "http://t.hostelworld.com";
	WebElement searchTextField;
	WebElement searchButton;
	WebElement cityName;
	WebElement search; 
	WebElement startDatePicker;
	WebElement endDatePicker;
	
	
	String searchTextFieldXpath =   ".//*[@id='home-search-keywords']";
	String searchButtonXpath = ".//*[@id='sb-search']/div[3]/div/button";
	String cityNameXpath = ".//*[@id='ui-id-3']/a";

	
	// Non-parameter page constructor
	public Homepage()
	{
		System.out.println("Homepage default constructor");
	}
	
	// Page constructor with paramater
	public Homepage(WebDriver driver)
	{
		System.out.println("Homepage constructor");
		this.driver = driver;
	}
	
	public String getHomepageUrl()
	{
		return homePageUrl;
	}
	
	/*
	 * This method puts the word 'dublin' into the input text field then clicks on 'Dublin, Ireland' in
	 * the predictive view.  It then clicks the 'Search' button
	 */
	public void propertySearch(String searchString)
	{
		System.out.println("Method 'propertySearch' running");
		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("home-search-keywords")));  // until input box is found
		searchTextField = driver.findElement(By.id("home-search-keywords"));
		searchTextField.click();
        searchTextField.sendKeys(searchString);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(cityNameXpath)));
        cityName = driver.findElement(By.xpath(cityNameXpath));
        cityName.click();
        search = driver.findElement(By.xpath(searchButtonXpath));
        search.click();
	}

}
