import java.util.Arrays;

/**
 * Provides a sum function on arrays.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2018-03-26
 */
public class ArraySum {

	/** Returns the sum of values in the given array. */
	public static int sum(int[] a, int left, int right) {
		
		if(right - left == 0)
			return a[0];
		else
			return a[right] + sum(a, left, right - 1);
		
	}
}
