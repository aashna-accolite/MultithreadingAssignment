package main.java.utility;

import java.util.HashMap;
import java.util.Random;

public class Utility {

	public void generateBag(HashMap<String, Integer> bag) {
		Random random = new Random();
		
		bag.put("Apple", random.nextInt(10));
		bag.put("Orange", random.nextInt(10));
		bag.put("Banana", random.nextInt(10));
		bag.put("Grapes", random.nextInt(10));
	}

	public int generateTotalReq(HashMap<String, Integer> bag) {
		int tempSum = 0;
		for (int temp : bag.values()) {
			tempSum += temp;
		}
		return tempSum;
	}
}
