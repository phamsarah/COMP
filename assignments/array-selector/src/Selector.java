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
	   
	   check(a, k);
	   int temp[] = Arrays.copyOf(a, a.length);
	   
	   Arrays.sort(temp); 
	   
	   int valuesLess = k - 1; 
	   int[] noDuplicates = removeDuplicates(temp);
	   
	   check(noDuplicates, k);  
	   int k1 = hasKthMin(noDuplicates, valuesLess);
	   
      return k1;
   }
   
   
   /**
    * removeDuplicates compares the current value in the array with the next and will
    * add the value if it's not a duplicate to a temporary array. The temporary array will then 
    * be added to an array with the "fixed" sized with that array being returned.
    * @param a the array containing duplicates
    * @return returnArray the array containing no duplicates
    */
   
   private static int[] removeDuplicates(int[] a)
   { 
	   
	   int[] tempArray = new int[a.length];
	         
	   int j = 0;
	   
	   for(int i = 0; i < a.length - 1; i++)
	   {
		 int currentElement = a[i];
		 
		 if(currentElement != a[i + 1])
		 {
			tempArray[j++] = currentElement;
		 }
	   }
	   
	    
	   tempArray[j++] = a[a.length - 1];
	   int[] returnArray = new int[j];
	   
	   int k = 0;
	   
	   for(int i = 0 ; i < j; i++)
	   {
		   returnArray[i] = tempArray[k];
		   k++; 
	   }
	         
	   return returnArray;
   }
   
   /**
    * hasKthMin checks for kMin and compares the position with the (k-1) value
    * if i (the position) equals the (k-1) then it has (k-1) values less than 
    * the value at i.
    * @param a the array with no duplicates contained
    * @param valuesLess the (k-1) value, how many values that are less than k
    * @return minimum the kMin
    */
   
   private static int hasKthMin(int[] a, int valuesLess)
   {
	   
	   int minimum = 0;
	   for(int i = 0; i < a.length; i++)
	   {
		   if(i == valuesLess)	
		   {
			   minimum = a[i];
		   }
	   }
	   
	   return minimum;
   }
   
   /**
    * hasKthMax compares the number of values that are right of the current value
    * with valuesLess (k-1), if they equal then kMax is found.
    * @param a the array with no duplicates contained
    * @param valuesLess the (k-1) value
    * @return maximum the kMax
    */
   
   
   private static int hasKthMax(int[] a, int valuesLess)
   {
	   
	   int maximum = 0;
	   for(int i = 0; i < a.length; i++)
	   {
		   if(((a.length - 1) - i) == valuesLess)
		   {
			   maximum = a[i];
		   }
	   }
	   
	   return maximum;
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
	   
	   check(a, k);
	   int[] temp = Arrays.copyOf(a, a.length);
	   
	   Arrays.sort(temp); 
	   
	   int valuesLess = k - 1; 
	   int[] noDuplicates = removeDuplicates(temp);
	   
	   check(noDuplicates, k);
	   
	   int k1 = hasKthMax(noDuplicates, valuesLess);
	   
      return k1;
   }
   
   /**
    * check checks to see if the array is null, of length 0, 
    * or if k exceeds the length of array a and 
    * throws an exception if it is.
    * @param a the unchecked array that may contain duplicates
    */
   
   private static void check(int[] a, int k)
   {
	   if(a == null || a.length == 0)
	   {
		   throw new IllegalArgumentException();
	   }
	   else if(k > a.length)
	   {
		   throw new IllegalArgumentException();
	   }
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
