package main.java;

import java.util.HashMap;
import java.util.Random;

public class Farmer implements Runnable {

	private HashMap<String, Integer> availWithFarmer;
	private int reqSlots;
	public Market market;
	private int farmerId;
	static int countFarmer;

	public Farmer(Market myMarket) {
		this.market = myMarket;
		countFarmer++;
		this.farmerId = countFarmer;
		generateSellingStock();
		reqSlots = generateRequiredSlots(availWithFarmer);
	}

	public void generateSellingStock() {
		Random random = new Random();
		availWithFarmer = new HashMap<String, Integer>();
		availWithFarmer.put("Apple", random.nextInt(10));
		availWithFarmer.put("Orange", random.nextInt(10));
		availWithFarmer.put("Banana", random.nextInt(10));
		availWithFarmer.put("Grapes", random.nextInt(10));
	}

	public int generateRequiredSlots(HashMap<String, Integer> availWithFarmer) {
		int tempSum = 0;
		for (int temp : availWithFarmer.values()) {
			tempSum += temp;
		}
		return tempSum;
	}

	public void run() {
		try {
			market.sell(availWithFarmer, reqSlots, farmerId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}