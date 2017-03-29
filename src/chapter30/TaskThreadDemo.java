package chapter30;


public class TaskThreadDemo {

	public static void main(String[] args) throws InterruptedException {
		// Create task
		Runnable printA = new PrintChar('a', 100);
		Runnable printB = new PrintChar('b', 100);
		Runnable print100 = new PrintNum(100);
		
		// Create threads
		Thread thread1 = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);
	
		// Start threads
		thread1.start();
		thread2.start();
		thread3.setPriority(Thread.MAX_PRIORITY);
		thread3.start();
//		thread3.join();
		
//		System.out.println("\nthread3's priority = " + thread3.getPriority());
//		System.out.println("main's priority = " + Thread.currentThread().getPriority());
		
		
		
	}
	
}

class PrintChar implements Runnable {

	private char ch;
	private int times;
	
	public PrintChar(char ch, int times) {
		this.ch = ch;
		this.times = times;
	}

	@Override
	public void run() {
		for (int i = 0; i < times; i++) {
			System.out.print(ch);
		}
		
	}
}

class PrintNum implements Runnable {
	private int lastNum;

	public PrintNum(int n) {
		lastNum = n;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		Thread thread4 = new Thread(new PrintChar('c', 70));
		thread4.start();
		try {
			for (int i = 1; i <= lastNum; i++) {
				System.out.print(" " + i);
				if (i == 15) thread4.join();
			}
			
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
