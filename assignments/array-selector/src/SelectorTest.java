import static org.junit.Assert.*;

import org.junit.Test;

public class SelectorTest {

	@Test
	public void test() {
		int[] a = {2, 8, 7, 3, 4};
		int result = Selector.kmax(a, 1);
	}

}
