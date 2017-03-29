package quit;

import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrintTest {
    static Lock lock1 = new ReentrantLock();
    static int n;
    static String str;
    static int whichOne = 0;
    public static void main(String[] args) throws InterruptedException {


    	Scanner input = new Scanner(System.in);
        n = input.nextInt();
        str = input.next();
        

        Thread[] threads = new Thread[str.length()];


        for (int i = 0; i < str.length(); i++) {
           threads[i] = new Thread(new Task(i));
           threads[i].start();
        }        
    }

    static class  Task implements Runnable {
        final int index;
        public Task(int index) {
            this.index = index;
        }

        @Override
        public void run() {
            
            for (int i = 0; i < n; i++) {
//            	while (true) {
//            		lock1.lock();
//            		whichOne = whichOne % str.length();
//            		if (whichOne == index) {
//            			System.out.print(str.charAt(index));
//                    	++whichOne;
//                    	lock1.unlock();
//                    	break;
//            		}
//            		else {
//            			lock1.unlock();
//            		}
//            	}
            	
            	while (whichOne != index) {
            		
            	}
            	
            	lock1.lock();
            	System.out.println(str.charAt(index));
            	whichOne++;
            	whichOne %= str.length();
            	lock1.unlock();
            }
        }
    }
}