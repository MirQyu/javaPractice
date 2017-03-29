package chapter30;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSyncUsingLock {
	private static Account account = new Account();
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for (int i = 0; i < 100; i++) {
			executor.execute(new AddAPennyTask());
		}
		
		executor.shutdown();
		
		while (!executor.isTerminated()) {
			
		}
		
		System.out.println("what is balance? " + account.getBalance());
	}
	public static class AddAPennyTask implements Runnable {

		@Override
		public void run() {
			account.deposit(1);
		}	
	}
	
	public static class Account {
		private static Lock lock = new ReentrantLock();
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			lock.lock();
			
			try {
				int newBalance = balance + amount;
				
				Thread.sleep(10);
				
				balance = newBalance;
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			finally {
				lock.unlock();
			}
		}
	}
	
	private static class AccountWithSem {
		private static Semaphore semaphore = new Semaphore(1);
		private int balance = 0;
		
		public int getBalance() {
			return balance;
		}
		
		public void deposit(int amount) {
			try {
				semaphore.acquire();
				int newBalance = balance + amount;
				
				Thread.sleep(5);
				
				balance = newBalance;
			}
			catch (InterruptedException e) {
			}
			finally {
				semaphore.release();
			}
		}
		
	}
}
