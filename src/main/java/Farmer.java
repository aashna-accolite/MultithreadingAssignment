package main.java;

import java.util.HashMap;

public class Farmer implements Runnable {

	private HashMap<String, Integer> availWithFarmer;
	private int reqSlots;
	public Market market;
	private int farmerId;
	static int countFarmer;

	public Farmer(int numOfApples, int numOfOranges, int numOfBananas, int numOfGrapes, Market myMarket) {
		this.market = myMarket;
		countFarmer++;
		this.farmerId = countFarmer;
		availWithFarmer = new HashMap<String, Integer>();
		availWithFarmer.put("Apple", numOfApples);
		availWithFarmer.put("Orange", numOfOranges);
		availWithFarmer.put("Banana", numOfBananas);
		availWithFarmer.put("Grapes", numOfGrapes);
		reqSlots = numOfApples + numOfOranges + numOfBananas + numOfGrapes;
	}

	public void run() {
		try {
			market.sell(availWithFarmer, reqSlots, farmerId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}