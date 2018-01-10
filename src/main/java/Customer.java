package main.java;

import java.util.HashMap;

public class Customer implements Runnable {

	private HashMap<String, Integer> requirements;
	private int reqQuantity;
	private Market market;

	public Customer(int numOfApples, int numOfBananas, int numOfOranges, int numOfGrapes, Market myMarket) {
		this.market = myMarket;
		requirements = new HashMap<String, Integer>();
		requirements.put("Apple", numOfApples);
		requirements.put("Orange", numOfOranges);
		requirements.put("Banana", numOfBananas);
		requirements.put("Grapes", numOfGrapes);
		reqQuantity = numOfApples + numOfOranges + numOfBananas + numOfGrapes;
	}

	public void run() {
		// consume
	}
}