package quit;

import java.util.Scanner;

public class Main {
	static int[] tx;
	static int[] ty;
	static int n;
	static int walkTime, taxTime;
	static int gx, gy;
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
	
		n = scan.nextInt();
		
		tx = input(scan);
		ty = input(scan);
		
		gx = scan.nextInt();
		gy = scan.nextInt();
		
		walkTime = scan.nextInt();
		taxTime = scan.nextInt();
		
		System.out.println(getMinTime());
		
	}
	
	static int[] input(Scanner scan) {
		int[] tmps = new int[n];
		for (int i = 0; i < n; i++)
			tmps[i] = scan.nextInt();
		
		return tmps;
	}
	
	
	
	
	static int getMinTime() {
		
		int min1 = (Math.abs(gx) + Math.abs(gy))*walkTime;
		
		
		int toTaxMin = 10001;
		int t = 0;
		for (int i = 0; i < n; i++) {
			int tmp = Math.abs(tx[i]) + Math.abs(ty[i]);
			if (tmp < toTaxMin) {
				t = i;
				toTaxMin = tmp;
			}
		}
		
		int wt = toTaxMin*walkTime;
		
		int tmp = Math.abs(tx[t] - gx) + Math.abs(ty[t] - gy);
		int min2 = tmp*taxTime + wt;
		
		return (min2 < min1) ? min2 : min1;
		
	}
}
