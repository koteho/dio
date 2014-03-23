package ua.i.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	protected final FirefoxDriver driver;
	protected final WebDriverWait wait;

	public Base(FirefoxDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 120);
	}
	
	public boolean isElementPresent(WebDriver driver, By by){
		try{
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e){
			return false;
		}
	}
	
	
	public Boolean compareExchangeRates(List<CurrencyRatesData> dataList,	double averagePurchaseValueDouble, double averageSaleValueDouble) {
		Boolean result = false;
		double averagePurchaseValueActual = 0;
		double averageSaleValueActual = 0;
		int countOfValues = 0;
		for (CurrencyRatesData data : dataList){
			averagePurchaseValueActual = averagePurchaseValueActual + data.getCurentRatesOfPurchase();
			averageSaleValueActual = averageSaleValueActual + data.getCurentRatesOfSale();
			countOfValues++;
		}		
		averagePurchaseValueActual = Math.round((averagePurchaseValueActual/countOfValues)* 10000) / 10000.0d;
		averageSaleValueActual = Math.round((averageSaleValueActual/countOfValues)* 10000) / 10000.0d;
				
		System.out.println( "Actual average values are: " + averagePurchaseValueActual + ",	" + averageSaleValueActual + "\n" );
		
		if(averagePurchaseValueActual == averagePurchaseValueDouble) {
			System.out.println( "Average values of purchase are equals.\n");
			result = true;
		} else{
			System.out.println( "Average values of purchase are not equals.\n");
			result = false;
		}
		if(averageSaleValueActual == averageSaleValueDouble) {
			System.out.println( "Average values are equals.\n");
			result = true;
		} else{
			System.out.println( "Average values are not equals.\n");
			result = false;
		}
		
		return result;
	}

}
