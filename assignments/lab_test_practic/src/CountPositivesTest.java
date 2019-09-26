import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;

public class CountPositivesTest {

	@Test
	public void test() {
		
		ArrayList <Integer> a = new ArrayList<Integer>();
		
		a.add(1);
		a.add(-4);
		a.add(10);
		a.add(0);
		
		int numPos = CountPositives.countPositives(a);
		
		System.out.println("numpos: " + numPos);
		
	}

}
