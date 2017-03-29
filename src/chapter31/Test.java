package chapter31;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Queue;
import java.util.function.IntPredicate;

public class Test {
	
	private static ObjectInputStream inputFromFile;

	public static void main(String[] args) {
		
//		try {
//			System.out.println(args.length);
//			InetAddress address = InetAddress.getByName("www.baidu.com");
//			System.out.println(address.getHostAddress());
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// 9, 256
		try {
			inputFromFile = new ObjectInputStream(
					new FileInputStream("student.dat"));
			
			Object object1 = inputFromFile.readObject();
			System.out.println(object1);
			
			Object object2 = inputFromFile.readObject();
			System.out.println(object2);
			
		}  
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				inputFromFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
