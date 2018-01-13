package main.java;

import java.util.Random;

public class FruitMarket {
	public static void main(String args[]) {
		Market myMarket = new Market(50);

		Random random = new Random();

		Farmer f1 = new Farmer(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10),
				myMarket);
		Thread t1 = new Thread(f1);

		Farmer f2 = new Farmer(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10),
				myMarket);
		Thread t2 = new Thread(f2);
		//
		Farmer f3 = new Farmer(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10),
				myMarket);
		Thread t3 = new Thread(f3);

		Farmer f4 = new Farmer(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10),
				myMarket);
		Thread t7 = new Thread(f4);

		Farmer f5 = new Farmer(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10),
				myMarket);
		Thread t8 = new Thread(f5);

		Customer c1 = new Customer(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10),
				myMarket);
		Thread t4 = new Thread(c1);

		Customer c2 = new Customer(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10),
				myMarket);
		Thread t5 = new Thread(c2);

		Customer c3 = new Customer(random.nextInt(10), random.nextInt(10), random.nextInt(10), random.nextInt(10),
				myMarket);
		Thread t6 = new Thread(c3);

		t5.start();
		t1.start();
		t2.start();
		t4.start();
		t3.start();
		t6.start();
		t7.start();
		t8.start();

	}
}
