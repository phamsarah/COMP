package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class TestTest {

	@Test
	public void test() {
		
		ArrayList<Integer> list = new ArrayList<Integer>(); 
		list.add(10); 
        list.add(20); 
        list.add(30); 
        list.add(40); 
        
        Selector.<Integer>min(c1, ascendingInteger)
        
        final Collection<Integer> c1 = Arrays.<Integer>asList(new Integer[]{2,8,7,3,4});
				
		Integer min = (Integer)Test.min(c1);
	}

}
