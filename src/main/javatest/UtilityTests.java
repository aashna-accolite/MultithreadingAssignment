package main.javatest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.HashMap;
import org.junit.Test;
import main.java.utility.Utility;

public class UtilityTests {
	
	@Test
	public void generateTotalReqTest()
	{
		Utility tempUtil = new Utility();
		HashMap<String, Integer> tempBag = new HashMap<>();
		tempBag.put("Sample1", 5);
		tempBag.put("Sample2", 3);
		tempBag.put("Sample3", 2);
		
		int tempTotal = tempUtil.generateTotalReq(tempBag);	
		assertEquals(10, tempTotal);
	}
	
	@Test
	public void generateBagTest()
	{
		Utility tempUtil = new Utility();
		HashMap<String, Integer> tempBag = new HashMap<>();
		tempUtil.generateBag(tempBag);
		
		assertTrue(tempBag.containsKey("Apple"));
		assertTrue(tempBag.containsKey("Orange"));
		assertTrue(tempBag.containsKey("Banana"));
		assertTrue(tempBag.containsKey("Grapes"));

		assertTrue(tempBag.get("Apple") < 10 && tempBag.get("Apple") >=0);
		assertTrue(tempBag.get("Orange") < 10 && tempBag.get("Orange") >=0);
		assertTrue(tempBag.get("Banana") < 10 && tempBag.get("Banana") >=0);
		assertTrue(tempBag.get("Grapes") < 10 && tempBag.get("Grapes") >=0);
	}
}
