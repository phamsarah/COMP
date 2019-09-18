package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;

public class Test {
	private Test() { }
	
	public static <T> T min(Collection<T> coll) {
		  	
		Iterator iterator = coll.iterator();
		
		System.out.println("list items: ");
		while(iterator.hasNext())
			System.out.println(iterator.next() + " ");
		
				// create iterator
				// itr.hasnext 
				// comp.compareTo();
		   
	      return null;
	  }
	

}
