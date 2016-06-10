/*
 * This page lists the properties returned by the search  and 
 * orders the results depending on the value chosen in the 
 * Sort drop-down
 */

package HostelworldFramework.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PropertyListPage {
	
	WebElement sortMenu;
	WebElement sortListItem;
	WebElement propertyNameElement;
	WebElement priceElement;
	WebElement listingElement;
	
	String sortMenuXpath = ".//*[@id='pagebody']/div[1]/div/div/div[12]/div[4]/div/div/div/div/dl[1]/dd[2]";
	String listingsXpath = ".//*[@id='fabResultsContainer']/div";
	String listingPriceXpath = ".//*[@class='pricing no-bullet']/li";
	
	List<WebElement> listings;
	List<String> propertyNames;
	List<String> sortedPropertyNames;
	List<BigDecimal> prices;
	List<BigDecimal> sortedPrices;
	List<BigDecimal> listingPrices;
	List<WebElement> listingPriceElements; 
	
	Iterator<WebElement> listingsIterator;
	Iterator<WebElement> priceIterator; 
	
	WebDriver driver;
	WebDriverWait wait;
	
	boolean listsEqual;
	
	BigDecimal price;
	
	// Non-parameter constructor
	public PropertyListPage()
	{
		System.out.println("PropertyListPage default constructor");
	}
	
	// Constructor with parameter
	public PropertyListPage(WebDriver driver)
	{
		System.out.println("PropertyListPage constructor");
		this.driver = driver;
	}
	
	// Method finds Sort drop-down, expands it and clicks
	// item identified by value passed in as parameter
	public void selectSortOrder(String optionValue)
	{
		System.out.println("Method 'selectSortOrder' running");
		wait = new WebDriverWait(driver,5);
		sortMenu = driver.findElement(By.xpath(sortMenuXpath));
		sortMenu.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(optionValue)));
		sortListItem = driver.findElement(By.id(optionValue));
		sortListItem.click();
	}
	
	/*
	 * Method puts listings elements into a collection.  It then iterates through the collection
	 * and adds the property name to a collection of strings. Once the string collection is compiled
	 * a copy is made of it and the copy is sorted.  The two collections are then compared and if 
	 * they are the same the list is in alphabetical order. 
	 */
	public boolean sortByName()
	{
		listings = driver.findElements(By.xpath(listingsXpath));
		listingsIterator = listings.iterator();
		propertyNames = new ArrayList<String>();
		listsEqual = false;
		WebElement propertyNameElement;
		String propertyName;
		
		while(listingsIterator.hasNext())
		{
			listingElement = listingsIterator.next();
			propertyNameElement = listingElement.findElement(By.cssSelector("h2"));
			propertyName = propertyNameElement.getText();
			propertyNames.add(propertyName);
		}
		
		sortedPropertyNames = propertyNames;
		Collections.sort(sortedPropertyNames);
		
	    if(propertyNames.equals(sortedPropertyNames))
	    {
	    	listsEqual = true;
	    }
		
		return listsEqual;
	}
	
	/*
	 * Method puts listings elements into a collection.  It then iterates through the collection
	 * and for each listing it creates a collection of the prices in the listing, which may be 
	 * dorm and/or privates. The price for each listing is put into another collection.  If there
	 * is more than one price in a listing the lowest price is put into this collection.  This collection
	 * is then copied, and the copy sorted and compared with the original.  If the two collections are 
	 * the same then the property list is in price order.
	 */
	public boolean sortByPrice()
	{
		listings = driver.findElements(By.xpath(listingsXpath));
		listingsIterator = listings.iterator();
		prices = new ArrayList<BigDecimal>();
		listsEqual = false;

		while(listingsIterator.hasNext())
		{
			
			listingElement = listingsIterator.next();
			listingPrices = new ArrayList<BigDecimal>();
			listingPriceElements = listingElement.findElements(By.xpath(listingPriceXpath));
			priceIterator = listingPriceElements.iterator();
			String priceText;
			
			while(priceIterator.hasNext())
			{
				priceElement = priceIterator.next();
				priceText = priceElement.getText().replaceAll("[€a-zA-Z\\t\\s]+","");
				price = new BigDecimal(priceText);
				listingPrices.add(price);
			}
			prices.add(Collections.min(listingPrices));
		}
		
		sortedPrices = prices;
		Collections.sort(sortedPrices);
		
	    if(prices.equals(sortedPrices))
	    {
	    	listsEqual = true;
	    }
		
		return listsEqual;
	}
	
	
}
