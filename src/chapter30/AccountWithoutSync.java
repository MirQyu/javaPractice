package chapter30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 100; i++) {
			executor.execute(new AddAPennyTask());
		}
		executor.shutdown();
		
		while (!executor.isTerminated()) {
		}
		
		System.out.println("What is balance? " + account.getBalance());
		
	}
	
	private static class AddAPennyTask implements Runnable {
		public void run() {
			account.deposit(1);
		}
	}
	
	private static class Account {
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public synchronized void deposit(int amount) {
			int newBalance = balance + amount;
			
			try {
				Thread.sleep(2);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			balance = newBalance;
		}
	}
}
