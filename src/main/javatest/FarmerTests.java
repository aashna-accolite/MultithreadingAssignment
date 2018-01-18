package main.javatest;

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import main.java.model.Farmer;
import main.java.model.Market;

public class FarmerTests {

	@Test
	public void sell_WhenFull_Test() throws InterruptedException {
		Market tempMarket = new Market(50);
		tempMarket.availSpace = 0; // market full
		Farmer f1 = new Farmer(tempMarket);
		Thread t1 = new Thread(f1);
		t1.start();
		TimeUnit.SECONDS.sleep(1);

		assertEquals(Thread.State.WAITING, t1.getState());
	}

	@Test
	public void sell_MoreThanCapacity_Test() throws InterruptedException {
		Market tempMarket = new Market(0); // simulating market capacity insufficient
		Farmer f1 = new Farmer(tempMarket);
		Thread t1 = new Thread(f1);
		t1.start();
		TimeUnit.SECONDS.sleep(1);

		assertEquals(Thread.State.WAITING, t1.getState());
	}

	@Test
	public void sell_WhenAvailable_Test() throws InterruptedException {
		Market tempMarket = new Market(1000); // market capacity sufficient
		Farmer f1 = new Farmer(tempMarket);
		Thread t1 = new Thread(f1);
		t1.start();
		TimeUnit.SECONDS.sleep(1);

		assertEquals(f1.getAvailWithFarmer().get("Apple"), tempMarket.availFruits.get("Apple"));
		assertEquals(f1.getAvailWithFarmer().get("Orange"), tempMarket.availFruits.get("Orange"));
		assertEquals(f1.getAvailWithFarmer().get("Banana"), tempMarket.availFruits.get("Banana"));
		assertEquals(f1.getAvailWithFarmer().get("Grapes"), tempMarket.availFruits.get("Grapes"));
	}
}
