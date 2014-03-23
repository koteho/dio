package ua.i.finance;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AverageExchangeRatesTest extends AverageExchangeRatesFlow {

	private FirefoxDriver driver;

	@Before
	public void beforeTests() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void teaeDown() {
		driver.close();
	}

	@Test
	public void checkAverageExchangeRates() throws InterruptedException {
		checkAverageExchangeRates(driver);
	}

}
