/**
 * ArrayBagClient.java
 * Provides a sample client of Bag behavior from
 * the ArrayBag class.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @version 2016-02-24
 *
 */
public class ArrayBagClient {
   /** Drives execution. */
   public static void main(String[] args) {
     /**
	   
	   Bag<Integer> bag = new ArrayBag<>();
      for (int i = 0; i < 10; i++) {
         bag.add(i);
      }
      System.out.println(bag);
      
      **/
	   
	   ArrayBag b = new ArrayBag();
	   for(int i = 1; i<=18; i++)
	   {
		   b.add(i);
	   }
	   
	   for(int i = 1; i <= 15; i++)
	   {
		   b.remove(i);
	   }
	   
	   System.out.println("length: " + b.size());
   }
}

