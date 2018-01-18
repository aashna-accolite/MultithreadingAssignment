package main.javatest;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import main.java.model.Customer;
import main.java.model.Market;

public class CustomerTests {

	@Test
	public void buy_WhenEmpty_Test() throws InterruptedException {
		Market tempMarket = new Market(50);
		tempMarket.availSpace = 50; // market empty
		Customer c1 = new Customer(tempMarket);
		Thread t1 = new Thread(c1);
		t1.start();
		TimeUnit.SECONDS.sleep(1);

		assertEquals(Thread.State.WAITING, t1.getState());
	}

	@Test
	public void buy_MoreThanAvailable_Test() throws InterruptedException {
		Market tempMarket = new Market(50);
		tempMarket.availFruits.put("Apple", 1); // fruit unavailable
		Customer c1 = new Customer(tempMarket);
		c1.getRequirements().put("Apple", 5);
		Thread t1 = new Thread(c1);
		t1.start();
		TimeUnit.SECONDS.sleep(1);

		assertEquals(Thread.State.WAITING, t1.getState());
	}

	@Test
	public void buy_WhenAvailable_Test() throws InterruptedException {
		Market tempMarket = new Market(50);
		tempMarket.availFruits.put("Apple", 5); // fruit available
		Customer c1 = new Customer(tempMarket);
		c1.getRequirements().put("Apple", 1);
		c1.getRequirements().put("Orange", 0);
		c1.getRequirements().put("Banana", 0);
		c1.getRequirements().put("Grapes", 0);
		Thread t1 = new Thread(c1);
		t1.start();
		TimeUnit.SECONDS.sleep(1);

		assertEquals(4, (int) tempMarket.availFruits.get("Apple")); // apple bought
	}
}