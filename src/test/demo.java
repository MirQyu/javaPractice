package test;

public class demo {
	public static void main(String []args) {
		// TODO Auto-generated method stub
		
		Thread th = new Thread(new Runnable() {
			public void run() {
				System.out.println("Runnable.Run()");}
						}) {
				public void run() {
					System.out.println("Thread.Run()");
				}
		};
		th.start();
	
	}
}
