package PrimeGenerator;

import java.util.concurrent.TimeUnit;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Launch the prime numbers generator
				Thread task=new PrimeGenerator();
				task.start();
				
				// Wait 5 seconds
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// Interrupt the prime number generator
				task.interrupt();
	}

}
