import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Sarah Pham (slp0042@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  8/30/2019
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
	   if(a == null || a.length == 0)
	   {
		   throw new IllegalArgumentException();
	   }
	  int min_value = a[0];
	  for(int i = 0; i < a.length; i++)
   		{
		  if(a[i] < min_value)
	   		{
			  min_value = a[i];
	   		}
   		}	   
	  return min_value;
	   
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {   
	   if(a == null || a.length == 0)
		   {
			   throw new IllegalArgumentException();
		   }
	   int max_value = a[0];
	   for(int i = 0; i < a.length; i++)
	   	{
		   if(a[i] > max_value)
		   	{
			   max_value = a[i];
			}
	   	}   
	   return max_value;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      return -99;
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      return -99;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
	  int numI = 0;
	  int returnArray[];
	  
	  
	  if(a == null || a.length == 0)
	   {
		   throw new IllegalArgumentException();
	   }
	  
	  int rangedNum[] = new int[a.length];
	  
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] >= low)
			{
				if(a[i] <= high)
				{
					numI++;
					rangedNum[i] = a[i];
				}
			}
		}
		
		returnArray = new int[numI];
		int j = 0;
		
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] >= low)
			{
				if(a[i] <= high)
				{
					returnArray[j] = a[i];
					j++;
				}
			}
		}
			
		
			return returnArray;

   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
	   if(a == null || a.length == 0)
	   {
		   throw new IllegalArgumentException();
	   }
	   else
	   {
		   boolean exist = false;
		   int smallest = 0;
		   int numI = 0;
		   int[] total = new int[a.length];
		   
		   for(int i = 0; i < a.length; i++)
		   {
			   if(a[i] >= key)
			   {
				   exist = true;
				   total[numI] = a[i];
				   numI++;
			   }
		   }
		   
		   int[] result = new int[numI];
		   for(int i = 0; i < numI; i++)
		   {
			   result[i] = total[i];
		   }
		   
		   smallest = total[0]; 
		   
		   for(int j = 0; j < result.length; j++)
		   {
		   
			   if(total[j] < smallest)
			   {
				   smallest = result[j];
			   }
		   }
		   
		   if(exist == false)
		   {
			   throw new IllegalArgumentException();
		   }
		   
		   return smallest;
	   }
	   
	   
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   /**
 * @param a
 * @param key
 * @return
 */
public static int floor(int[] a, int key) {
	   
	if(a == null || a.length == 0)
      {
	   throw new IllegalArgumentException();
	  }
   else
   {
	   
	   boolean exist = false;
	   int largest = 0;
	   int[] total = new int[a.length];
	   int numI = 0;
	   
	   for(int i = 0; i < a.length; i++)
	   {
		   if(a[i] <= key)
		   {
			   exist = true;
			   total[numI] = a[i];
			   numI++;
		   }
	   }
	   
	   int[] result = new int[numI];
	   for(int i = 0; i < numI; i++)
	   {
		   result[i] = total[i];
	   }
	   
	   largest = total[0]; 
	   
	   for(int j = 0; j < result.length; j++)
	   {
	   
		   if(total[j] > largest)
		   {
			   largest = result[j];
		   }
	   }
	   
	   if(exist == false)
	   {
		   throw new IllegalArgumentException();
	   }
	   
	   return largest;
	   }
   }

}
