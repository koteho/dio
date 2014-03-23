package ua.i.finance;

import org.openqa.selenium.firefox.FirefoxDriver;

public class AverageExchangeRatesFlow {

	private FinanceStartPage financeStartPage;
	FirefoxDriver driver;
	static final String webPagePath = "http://finance.i.ua";

	public void checkAverageExchangeRates(FirefoxDriver driver) throws InterruptedException {
		financeStartPage = startFinancePage(driver);
		financeStartPage.goToEUR();
		financeStartPage.checkAverageExchangeRates();
	}

	private FinanceStartPage startFinancePage(FirefoxDriver driver) {
		driver.get(webPagePath);
		return new FinanceStartPage(driver);
	}

}
