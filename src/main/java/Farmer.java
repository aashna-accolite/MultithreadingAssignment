package main.java;

import java.util.HashMap;

public class Farmer implements Runnable {

	private HashMap<String, Integer> availWithFarmer;
	private int reqSlots;
	public Market market;

	public Farmer(int numOfApples, int numOfOranges, int numOfBananas, int numOfGrapes, Market myMarket) {
		this.market = myMarket;
		availWithFarmer = new HashMap<String, Integer>();
		availWithFarmer.put("Apple", numOfApples);
		availWithFarmer.put("Orange", numOfOranges);
		availWithFarmer.put("Banana", numOfBananas);
		availWithFarmer.put("Grapes", numOfGrapes);
		reqSlots = numOfApples + numOfOranges + numOfBananas + numOfGrapes;
	}

	public void run() {
		try {
			// produce
			market.sell(availWithFarmer, reqSlots);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}