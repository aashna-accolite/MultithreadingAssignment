package main.java.model;

import java.util.HashMap;

import main.java.utility.Utility;

public class Customer implements Runnable {

	public HashMap<String, Integer> requirements;
	private int reqQuantity;
	private int customerId;
	private Market market;
	private static int countCustomer;
	private Utility utility;

	public Customer(Market myMarket) {
		this.utility = new Utility();
		this.market = myMarket;
		this.customerId = ++countCustomer;
		requirements = new HashMap<String, Integer>();
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
		utility.generateBag(requirements);
	}

	public int generateRequiredQuantity() {
		return utility.generateTotalReq(requirements);
	}

	public HashMap<String, Integer> getRequirements() {
		return requirements;
	}
}