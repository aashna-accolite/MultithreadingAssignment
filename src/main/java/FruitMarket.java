package main.java;

public class FruitMarket {
	public static void main(String args[]) {
		Market myMarket = new Market(10);

		// generate farmer and consumer threads randomly

		// generate number of fruits randomly

		Farmer f1 = new Farmer(2, 2, 1, 0, myMarket);
		Thread t1 = new Thread(f1);

		Farmer f2 = new Farmer(1, 2, 1, 2, myMarket);
		Thread t2 = new Thread(f2);

		Farmer f3 = new Farmer(2, 2, 2, 2, myMarket);
		Thread t3 = new Thread(f3);

		Customer c1 = new Customer(1, 1, 1, 1, myMarket);
		Thread t4 = new Thread(c1);

		Customer c2 = new Customer(2, 4, 0, 1, myMarket);
		Thread t5 = new Thread(c2);

		t2.start();
		t1.start();
		t4.start();
		t5.start();
		t3.start();

	}
}
