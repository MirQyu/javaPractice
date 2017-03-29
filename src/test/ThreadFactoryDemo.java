package test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadFactory;

public class ThreadFactoryDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyThreadFactory factory=new MyThreadFactory("my thread factory");
		factory.newThread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("in runnable.");
				
			}
		}).start();
	}

}

class MyThreadFactory implements ThreadFactory {
	private int counter;
	private String name;
	private List<String> stats;

	public MyThreadFactory(String name) {
		counter = 0;
		this.name = name;
		stats = new ArrayList<String>();
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r, name + "-Thread_" + counter);
		counter++;
		stats.add(String.format("Created thread %d with name %s on %s\n",
				t.getId(), t.getName(), new Date()));
		return t;
	}
}
