import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Sarah Pham (slp0042@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version 9/16/19
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
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
	   check(coll, comp);
	   Iterator <T> iterator = coll.iterator();
	   
	  T min = null;
	  
	  while (iterator.hasNext()) {
		  if (min == null) {
			  min = iterator.next();
			  continue;
		  }
		  T other = iterator.next();
		  if (comp.compare(other, min) < 0) min = other;
	  }
      return min;
      
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
	   check(coll, comp);
	   
	   Iterator <T> iterator = coll.iterator();
	   
		  T max = null;
		  
		  while (iterator.hasNext()) {
			  if (max == null) {
				  max = iterator.next();
				  continue;
			  }
			  T other = iterator.next();
			  if (comp.compare(other, max) > 0) max = other;
		  }
		  
	      return max;
	  
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
	   
	   check(coll, comp);
	   
	   if(k > coll.size() || k <= 0) {
		   throw new NoSuchElementException();
	   }
	   
	   T kmin = null;
	   T tempMin = null;
	   boolean firstIteration = true;
	   boolean large = true;
	   
	   for(int i = 0; i < k; i++)
	   {
		   for(T value : coll)
		   {
			   if(tempMin == null)
			   {
				   tempMin = value;
			   }
			   
			   if(firstIteration)
			   {
				   if(comp.compare(value, tempMin) < 0)
					   tempMin = value;
			   }
			   else
			   {
				   if(large && comp.compare(value, kmin) > 0)
				   {
					   large = false;
					   tempMin = value;;
					   
				   }
				   else if(comp.compare(value, kmin) > 0 && comp.compare(value, tempMin) < 0)
					   tempMin = value;
			   }
		   }
		   
		   
	   }
	   
	   firstIteration = false;
	   
	   if(tempMin.equals(kmin)) {
		   throw new NoSuchElementException();
	   }
	   else {
		   kmin = tempMin;
	   }
	   
	   return kmin;
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
	   check(coll, comp);
	   
	   if(k > coll.size() || k <= 0) {
		   throw new NoSuchElementException();
	   }
	   
	   T kmax = null;
	   T tempMax = null;
	   boolean firstIteration = true;
	   boolean small = true;
	   
	   for(int i = 0; i < k; i++)
	   {
		   for(T value : coll)
		   {
			   if(tempMax == null)
			   {
				   tempMax = value;
			   }
			   
			   if(firstIteration)
			   {
				   if(comp.compare(value, tempMax) > 0)
					   tempMax = value;
			   }
			   else
			   {
				   if(small && comp.compare(value, kmax) < 0)
				   {
					   small = false;
					   tempMax = value;;
					   
				   }
				   else if(comp.compare(value, kmax) < 0 && comp.compare(value, tempMax) > 0)
					   tempMax = value;
			   }
		   }
		   
		   
	   }
	   
	   firstIteration = false;
	   
	   if(tempMax.equals(kmax)) {
		   throw new NoSuchElementException();
	   }
	   else {
		   kmax = tempMax;
	   }
	   
	   return kmax;
	   
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high, Comparator<T> comp) {
	   
	   check(coll, comp);
	   
	   Collection<T> currentRange = new ArrayList<T>();
	   for(T value : coll)
	   {
		   if(comp.compare(value, low) >= 0 && comp.compare(value, high) <= 0)
			   currentRange.add(value);
	   }
	   
	   if(currentRange.size() == 0)
	   {
		   throw new NoSuchElementException();
	   }
	   
      return currentRange;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      check(coll, comp);
      
      T finalCeiling = null;
      boolean large = true;
      
      for(T value : coll) {
    	  
    	  if(large && comp.compare(value, key) >= 0)
    	  {
    		  large = false;
    		  finalCeiling = value;
    	  }
    	  else if(comp.compare(value, key) >= 0 && comp.compare(value, finalCeiling) <= 0)
    	  {
    		  finalCeiling = value;
    	  }
      }
      
      if(finalCeiling == null)
      {
    	  throw new NoSuchElementException();
      }
	   
	   
	   return finalCeiling;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      
	   check(coll, comp);
	   
	   T finalFloor = null;
	   boolean small = true;
	   
	   for(T value : coll)
	   {
		   if(small && comp.compare(value, key) <= 0)
		   {
			   small = false;
			   finalFloor = value;
		   }
		   else if(comp.compare(value, key) <= 0 && comp.compare(value, finalFloor) >= 0)
		   {
			   finalFloor = value;
		   }
	   }
	   
	   if(finalFloor == null)
	   {
		   throw new NoSuchElementException();
	   }
	   
	   
	   return finalFloor;
   }
   
   private static <T> void check(Collection <T> coll, Comparator<T> comp)
   {
	   
	   if(coll == null || comp == null)
	   {
		   throw new IllegalArgumentException();
	   }
	   else if (coll.isEmpty())
	   {
		   throw new NoSuchElementException();
	   }
	   
   }

}
