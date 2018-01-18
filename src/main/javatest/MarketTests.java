package main.javatest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import org.junit.Test;
import main.java.model.Market;

public class MarketTests {

	@Test
	public void updatedByFarmerTest() {
		Market tempMarket = new Market(50);
		tempMarket.availFruits.put("Apple", 10);
		tempMarket.availFruits.put("Orange", 15);
		tempMarket.availFruits.put("Banana", 5);
		tempMarket.availFruits.put("Grapes", 0);

		HashMap<String, Integer> tempMap = new HashMap<>();
		tempMap.put("Apple", 2);
		tempMap.put("Orange", 5);
		tempMap.put("Banana", 0);
		tempMap.put("Grapes", 20);

		tempMarket.updateMarket(tempMap, true);

		assertEquals(12, (int) tempMarket.availFruits.get("Apple"));
		assertEquals(20, (int) tempMarket.availFruits.get("Orange"));
		assertEquals(5, (int) tempMarket.availFruits.get("Banana"));
		assertEquals(20, (int) tempMarket.availFruits.get("Grapes"));
	}

	@Test
	public void updatedByCustomerTest() {
		Market tempMarket = new Market(50);
		tempMarket.availFruits.put("Apple", 10);
		tempMarket.availFruits.put("Orange", 15);
		tempMarket.availFruits.put("Banana", 5);
		tempMarket.availFruits.put("Grapes", 20);

		HashMap<String, Integer> tempMap = new HashMap<>();
		tempMap.put("Apple", 2);
		tempMap.put("Orange", 5);
		tempMap.put("Banana", 0);
		tempMap.put("Grapes", 10);

		tempMarket.updateMarket(tempMap, false);

		assertEquals(8, (int) tempMarket.availFruits.get("Apple"));
		assertEquals(10, (int) tempMarket.availFruits.get("Orange"));
		assertEquals(5, (int) tempMarket.availFruits.get("Banana"));
		assertEquals(10, (int) tempMarket.availFruits.get("Grapes"));
	}
}