package main.java.app;

import java.util.Random;
import main.java.model.Customer;
import main.java.model.Farmer;
import main.java.model.Market;

public class FruitMarket {
	public static void main(String args[]) {
		Market myMarket = new Market(100);

		Random random = new Random();

		for (int i = 0; i < 20; i++) {
			if (random.nextBoolean()) {
				Farmer f1 = new Farmer(myMarket);
				Thread t1 = new Thread(f1);
				t1.start();
			} else {
				Customer c1 = new Customer(myMarket);
				Thread t4 = new Thread(c1);
				t4.start();
			}
		}
	}
}