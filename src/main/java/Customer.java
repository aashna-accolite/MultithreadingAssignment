package main.java;

import java.util.HashMap;
import java.util.Random;

public class Customer implements Runnable {

	private HashMap<String, Integer> requirements;
	private int reqQuantity;
	private int customerId;
	private Market market;
	private static int countCustomer;

	public Customer(Market myMarket) {
		this.market = myMarket;
		countCustomer++;
		this.customerId=countCustomer;
		generateRequirements();
		reqQuantity = generateRequiredQuantity(requirements);
	}

	public void run() {
		try {
			market.buy(reqQuantity, requirements, customerId);
		} catch (

		InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void generateRequirements() {
		Random random = new Random();
		requirements = new HashMap<String, Integer>();
		requirements.put("Apple", random.nextInt(10));
		requirements.put("Orange", random.nextInt(10));
		requirements.put("Banana", random.nextInt(10));
		requirements.put("Grapes", random.nextInt(10));
	}

	public int generateRequiredQuantity(HashMap<String, Integer> requirements) {
		int tempSum = 0;
		for (int temp : requirements.values()) {
			tempSum += temp;
		}
		return tempSum;
	}
}