package ua.i.finance;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import ua.i.common.Base;
import ua.i.common.CurrencyRatesData;

public class FinanceStartPage extends Base{
	
	@FindBy (how = How.XPATH, using = ".//*[@id='feMain2']/ul/li[2]/i/a")
	private WebElement EUR;	
	@FindBy (how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[2]/big")
	private WebElement averagePurchaseValue;	
	@FindBy (how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div[2]/div[2]/div[3]/table/tbody/tr[3]/td[3]/big")
	private WebElement averageSaleValue;
	
	private String banksListPath = ".//*[@id='feMain2']/table/tbody/tr[not (@class)]";

	
	public FinanceStartPage(FirefoxDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}	
	public void goToEUR () throws InterruptedException{
		EUR.click();
	}	
	public void checkAverageExchangeRates() {		
		List<CurrencyRatesData> dataList = new ArrayList<CurrencyRatesData>();
		
		String averagePurchaseValueString = averagePurchaseValue.getText();
		double averagePurchaseValueCurrent = Double.parseDouble(averagePurchaseValueString);
		
		String averageSaleValueString = averageSaleValue.getText();
		double averageSaleValueCurrent = Double.parseDouble(averageSaleValueString);
		
		List<WebElement> resultTable = driver.findElements(By.xpath(banksListPath));
		
		int bankListSize= resultTable.size();
        System.out.println(resultTable.size());
        
        //Parse list of results
        for (int i=0; i < bankListSize; i++) {
        	String dataOutNotParsed = resultTable.get(i).getText();
            System.out.println(i + ". " + dataOutNotParsed);
           
            if (i != 0 && i != bankListSize -1 ){
            	
            	String delims = " ";
            	
            	String saleRatesListOutString = dataOutNotParsed.substring(dataOutNotParsed.lastIndexOf(delims)+1);
            	double saleRatesListOutDouble = Double.parseDouble(saleRatesListOutString);
            	
            	String dataOutNotParsedCuted = dataOutNotParsed.substring(0, dataOutNotParsed.lastIndexOf(delims));
            	String purchaseRatesListOutString = dataOutNotParsedCuted.substring(dataOutNotParsedCuted.lastIndexOf(delims)+1);
            	double purchaseRatesListOutDouble = Double.parseDouble(purchaseRatesListOutString);
            	
            	String bankListOut = dataOutNotParsedCuted.substring(0, dataOutNotParsedCuted.lastIndexOf(delims));                    	            	
            	
            	CurrencyRatesData data = new CurrencyRatesData(bankListOut, purchaseRatesListOutDouble, saleRatesListOutDouble);
    			dataList.add(data);    			
            }          
        }
        System.out.print( "\nAverage values are: " + averagePurchaseValueCurrent + ",	" + averageSaleValueCurrent + "\n" );
        compareExchangeRates(dataList, averagePurchaseValueCurrent, averageSaleValueCurrent);        
	}

	
					
}

