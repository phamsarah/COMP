import java.util.Collection;
import java.util.Iterator;

/**
 * Counts the number of positive values in a Collection.
 * 
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2017-09-28
 */
public class CountPositives {

   /**
    * Returns the number of positive values in the given Collection.
    */
   public static int countPositives(Collection<Integer> collection) {

	   Iterator<Integer> iter = collection.iterator();
	   int pos = 0;

	   while(iter.hasNext())
	   {
		   if(iter.next() > 0)
		   {
			   pos++;
		   }
		   
	   }
	   
      return pos;
   }
}
