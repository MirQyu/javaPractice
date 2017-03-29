package chapter30;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConsumerProducerUsingBlockingQueue {
	private static ArrayBlockingQueue<Integer> buffer = 
			new ArrayBlockingQueue<>(2);
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		executor.execute(new ProduceTask());
		executor.execute(new ConsumerTask());
		executor.shutdown();
	}
	
	private static class ProduceTask implements Runnable {

		@Override
		public void run() {
			try {
				int i = 1;
				while (true) {
					System.out.println("producer writes " + i);
					buffer.put(i++);
					
					Thread.sleep((int)(Math.random()*1000));
				}
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private static class ConsumerTask implements Runnable {
		
		@Override
		public void run() {
			try {
				while (true) {
					System.out.println("\t\t\tconsumer reads " + buffer.take());
					
					Thread.sleep((int)(Math.random()*1000));
				}
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}
}
