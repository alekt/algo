package in.naishe.algo.utils;

import java.util.Random;

public class Util {
	public static final Random rand = new Random();
	public static int[] generateIntArray(int length){
		int[] a = new int[length];
		for(int i=0; i<length; i++)
			a[i] = rand.nextInt(100);
		return a;
	}
	
	public static void print(int[] a) {
		System.out.print("[");
		for(int i=0; i<a.length; i++){
			System.out.print(a[i]);
			if(i != a.length-1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	public static int[] swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}
}
