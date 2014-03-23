package ua.i.common;

public class CurrencyRatesData {

	private String bank;
	private double curentRatesOfPurchase;
	private double curentRatesOfSale;

	public CurrencyRatesData(String bank, double curentRatesOfPurchase,
			double curentRatesOfSale) {
		super();
		this.bank = bank;
		this.curentRatesOfPurchase = curentRatesOfPurchase;
		this.curentRatesOfSale = curentRatesOfSale;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public double getCurentRatesOfPurchase() {
		return curentRatesOfPurchase;
	}

	public void setCurentRatesOfPurchase(double curentRatesBuy) {
		this.curentRatesOfPurchase = curentRatesBuy;
	}

	public double getCurentRatesOfSale() {
		return curentRatesOfSale;
	}

	public void setCurentRatesOfSale(double curentRatesSell) {
		this.curentRatesOfSale = curentRatesSell;
	}

}
