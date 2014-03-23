package ua.i.common;

import java.util.List;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	protected final FirefoxDriver driver;
	protected final WebDriverWait wait;
	private String message;

	public Base(FirefoxDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 120);
	}
		
	public void log(String message){
		System.out.println(message);
	}
	
	public Boolean compareExchangeRates(List<CurrencyRatesData> dataList,	double averagePurchaseValueDouble, double averageSaleValueDouble) {
		Boolean result = false;
		double averagePurchaseValueActual = 0;
		double averageSaleValueActual = 0;
		int countOfValues = 0;
		//find and rounding arithmetic mean of values 
		for (CurrencyRatesData data : dataList){
			averagePurchaseValueActual = averagePurchaseValueActual + data.getCurentRatesOfPurchase();
			averageSaleValueActual = averageSaleValueActual + data.getCurentRatesOfSale();
			countOfValues++;
		}
		averagePurchaseValueActual = Math.round((averagePurchaseValueActual/countOfValues)* 10000) / 10000.0d;
		averageSaleValueActual = Math.round((averageSaleValueActual/countOfValues)* 10000) / 10000.0d;		
		log( "Actual average values are: " + averagePurchaseValueActual + ",	" + averageSaleValueActual);
		//compare results
		message = (averagePurchaseValueActual == averagePurchaseValueDouble) ?
				"Average values of purchase are equals." : "Average values of purchase are not equals.";
		log(message);		
		message = (averageSaleValueActual == averageSaleValueDouble) ?
				"Average values of sale are equals." : "Average values of sale are not equals.";
		log(message);
		result = (averagePurchaseValueActual == averagePurchaseValueDouble && averageSaleValueActual == averageSaleValueDouble) ?
			true : false;
		return result;
	}
}
