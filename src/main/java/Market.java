package main.java;

import java.util.HashMap;

public class Market {

	private HashMap<String, Integer> availFruits;
	private final int marketCapacity;
	private static int availSpace;
	private int numOfFruits;

	public int getMarketCapacity() {
		return marketCapacity;
	}

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
		this.availSpace = marketCapacity;
	}

	// synchronized produce
	public synchronized void sell(HashMap<String, Integer> availWithFarmer, int reqSlots) throws InterruptedException {

		if (availSpace >= reqSlots)
			availSpace -= reqSlots;
		else {
			while (availSpace < reqSlots) {
				wait();
				System.out.println("Farmer waiting");
			}
			if (availSpace >= reqSlots) {
				availSpace -= reqSlots;
			}
		}
		for (HashMap.Entry<String, Integer> entry : availWithFarmer.entrySet()) {
			if (availFruits.containsKey(entry.getKey())) {
				availFruits.put(entry.getKey(), entry.getValue() + availFruits.get(entry.getKey()));
			} else {
				availFruits.put(entry.getKey(), entry.getValue());
			}
		}
		notifyAll();
		System.out.println("Farmer added "+ reqSlots +" fruits to market.\n"+ availSpace +" slots empty in market:");
		display();

	}

	// synchronized consume
	public synchronized void buy(int reqQuantity, HashMap<String, Integer> requirements) throws InterruptedException {

		boolean flag = false;
		while (flag == false) {
			flag = true;
			for (HashMap.Entry<String, Integer> entry : requirements.entrySet()) {
				if (entry.getValue() > availFruits.get(entry.getKey())) {
					flag = false;
					// error
				}
			}
			if (flag == false) {
				wait();
				System.out.println("Customer waiting");
			} else {
				availSpace += reqQuantity;
				break;
			}
		}
		for (HashMap.Entry<String, Integer> entry : requirements.entrySet()) {
			if (availFruits.containsKey(entry.getKey())) {
				availFruits.put(entry.getKey(), availFruits.get(entry.getKey()) - entry.getValue());
			} else {
				availFruits.put(entry.getKey(), entry.getValue());
			}
		}
		notifyAll();
		System.out.println(
				"Customer bought " + reqQuantity + " fruits from market.\n" + availSpace + " slots empty in market:");
		display();

	}

	public synchronized void display() {
		for (HashMap.Entry<String, Integer> entry : availFruits.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}