package main.java.model;

import java.util.HashMap;

import main.java.utility.Utility;

public class Farmer implements Runnable {

	private HashMap<String, Integer> availWithFarmer;
	private int reqSlots;
	public Market market;
	private int farmerId;
	static int countFarmer;
	private Utility utility;

	public Farmer(Market myMarket) {
		this.utility = new Utility();
		this.market = myMarket;
		this.farmerId = ++countFarmer;
		availWithFarmer = new HashMap<String, Integer>();
		generateSellingStock();
		this.reqSlots = generateRequiredSlots();
	}

	public void run() {
		try {
			market.sell(availWithFarmer, reqSlots, farmerId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void generateSellingStock() {
		utility.generateBag(availWithFarmer);
	}

	public int generateRequiredSlots() {
		return utility.generateTotalReq(availWithFarmer);
	}
	
	public HashMap<String, Integer> getAvailWithFarmer() {
		return availWithFarmer;
	}
}