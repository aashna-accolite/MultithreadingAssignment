package main.java;

import java.util.HashMap;

public class Market {

	private HashMap<String, Integer> availFruits;
	private int marketCapacity;
	private int availQuantity;
	private int numOfFruits;

	public int getNumOfFruits() {
		return numOfFruits;
	}

	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	public Market(int marketCapacity) {
		availFruits = new HashMap<String, Integer>();
		availFruits.put("Apple", 0);
		availFruits.put("Orange", 0);
		availFruits.put("Banana", 0);
		availFruits.put("Grapes", 0);
		this.marketCapacity = marketCapacity;
	}

	// synchronized produce
	public synchronized void sell() {
		// add logic
	}

	// synchronized consume
	public synchronized void buy() {
		// add logic
	}
}