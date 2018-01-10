package main.java;

import java.util.HashMap;

public class Farmer implements Runnable {

	private HashMap<String, Integer> availability;
	private int reqSlots;
	public Market market;

	public Farmer(int numOfApples, int numOfBananas, int numOfOranges, int numOfGrapes, Market myMarket) {
		this.market = myMarket;
		availability = new HashMap<String, Integer>();
		availability.put("Apple", numOfApples);
		availability.put("Orange", numOfOranges);
		availability.put("Banana", numOfBananas);
		availability.put("Grapes", numOfGrapes);
		reqSlots = numOfApples + numOfOranges + numOfBananas + numOfGrapes;
	}

	public void run() {
		// produce
	}
}