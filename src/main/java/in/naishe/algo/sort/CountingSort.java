package in.naishe.algo.sort;

import in.naishe.algo.utils.Util;

/**
 * Counting sort as discussed here:
 * [[URL]]
 * 
 * NOTE: Since we are using a zero based index, while in 
 * the discussion on the blog above, we assume 1 based index
 * for simplicity. Using zero based index requires some tweaking
 * 1. we have (max+1) buckets
 * 2. b[buckets[a[i]]-1] = a[i]; instead of b[buckets[a[i]]] = a[i];
 * 
 * @author Nishant Neeraj (http://naishe.in)
 *
 */
public class CountingSort {

	public static void main(String[] args) {
		int[] a = Util.generateIntArray(12);
		Util.print(a);
		int[] b = countingSort(a);
		Util.print(b);
	}

	private static int[] countingSort(int[] a) {
		int max = Util.getMax(a);
		int[] buckets = new int[max+1];
		
		//btw, this is not required in Java they are initialized to 0 by default.
		for(int i=0; i < buckets.length; i++)
			buckets[i] = 0;
		
		//update counts
		for(int i=0; i < a.length; i++)
			buckets[a[i]] = buckets[a[i]] + 1;
		
		//add offset
		for(int i=1; i < buckets.length; i++)
			buckets[i] = buckets[i-1] + buckets[i];
		
		//create a new array, put sorted values in it
		int[] b = new int[a.length];
		for(int i=0; i < a.length; i++){
			b[buckets[a[i]]-1] = a[i];
			buckets[a[i]] = buckets[a[i]] - 1;
		}
		
		return b;
	}

}
