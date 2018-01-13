package main.java;

import java.util.Random;

public class FruitMarket {
	public static void main(String args[]) {
		Market myMarket = new Market(50);

		Random random = new Random();

		for (int i = 0; i < 20; i++) {
			if (random.nextBoolean()) {
				Farmer f1 = new Farmer(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10),
						myMarket);
				Thread t1 = new Thread(f1);
				t1.start();
			} else {
				Customer c1 = new Customer(random.nextInt(10), random.nextInt(10), random.nextInt(10),
						random.nextInt(10), myMarket);
				Thread t4 = new Thread(c1);
				t4.start();
			}
		}
	}
}