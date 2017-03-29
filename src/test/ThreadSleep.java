package test;
import java.util.concurrent.TimeUnit;


public class ThreadSleep {

	
	public static void main(String[] args) {
		Thread th=new Thread(new Runnable(){

			private int counter=0;
			
			public void run() {
				for(int i=0;i<5;i++){
					try {
						//Thread.sleep(500);
						//if(!Thread.currentThread().isInterrupted())
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
					e.printStackTrace();
					}
					counter++;
					System.out.println(counter);
					
				}
					
					
				
			}
		
		});
		
		th.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th.interrupt();

	}

}
