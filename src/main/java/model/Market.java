package main.java.model;

import java.util.HashMap;

public class Market {

	public HashMap<String, Integer> availFruits;
	private final int marketCapacity;
	public int availSpace;
	
	public int getMarketCapacity() {
		return marketCapacity;
	}

	public Market(int marketCapacity) {
		availFruits = new HashMap<String, Integer>();
		availFruits.put("Apple", 0);
		availFruits.put("Orange", 0);
		availFruits.put("Banana", 0);
		availFruits.put("Grapes", 0);
		this.marketCapacity = marketCapacity;
		availSpace = marketCapacity;
	}

	// synchronized produce
	public synchronized void sell(HashMap<String, Integer> availWithFarmer, int reqSlots, int farmerId)
			throws InterruptedException {
		if (availSpace >= reqSlots)
			availSpace -= reqSlots;
		else {
			while (availSpace < reqSlots) {
				System.out.println("Farmer-" + farmerId + " waiting");
				wait();
			}
			if (availSpace >= reqSlots) {
				availSpace -= reqSlots;
			}
		}
		updateMarket(availWithFarmer, true);
		System.out.println("Farmer-" + farmerId + " added " + reqSlots + " fruits to market.\n" + availSpace
				+ " slots empty in market:\n");
		display();
		notifyAll();
	}

	// synchronized consume
	public synchronized void buy(int reqQuantity, HashMap<String, Integer> requirements, int customerId)
			throws InterruptedException {

		boolean flag = false;
		while (flag == false) {
			flag = true;
			for (HashMap.Entry<String, Integer> entry : requirements.entrySet()) {
				if (entry.getValue() > availFruits.get(entry.getKey())) {
					flag = false;
					break;
				}
			}
			if (flag == false) {
				System.out.println("Customer-" + customerId + " waiting");
				wait();
			} else {
				availSpace += reqQuantity;
				break;
			}
		}
		updateMarket(requirements, false);
		System.out.println("Customer-" + customerId + " bought " + reqQuantity + " fruits from market.\n" + availSpace
				+ " slots empty in market:\n");
		display();
		notifyAll();
	}

	public synchronized void display() {
		for (HashMap.Entry<String, Integer> entry : availFruits.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public synchronized void updateMarket(HashMap<String, Integer> map, boolean isFarmer) {
		for (HashMap.Entry<String, Integer> entry : map.entrySet()) {
			int tempValue = 0;
			if (availFruits.containsKey(entry.getKey())) {
				if (isFarmer)
					tempValue = entry.getValue() + availFruits.get(entry.getKey());
				else
					tempValue = availFruits.get(entry.getKey()) - entry.getValue();
				availFruits.put(entry.getKey(), tempValue);
			} else {
				availFruits.put(entry.getKey(), entry.getValue());
			}
		}
	}
}