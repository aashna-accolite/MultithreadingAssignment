package main.java.model;

import java.util.HashMap;

import main.java.utility.Utility;

public class Customer implements Runnable {

	private HashMap<String, Integer> requirements;
	private int reqQuantity;
	private int customerId;
	private Market market;
	private static int countCustomer;
	private Utility utility;

	public Customer(Market myMarket) {
		this.utility = new Utility();
		this.market = myMarket;
		countCustomer++;
		this.customerId = countCustomer;
		generateRequirements();
		this.reqQuantity = generateRequiredQuantity();
	}

	public void run() {
		try {
			market.buy(reqQuantity, requirements, customerId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void generateRequirements() {
		requirements = new HashMap<String, Integer>();
		utility.generateBag(requirements);
	}

	public int generateRequiredQuantity() {
		return utility.generateTotalReq(requirements);
	}
}