package GET2018.PF.PFAssignment3.StringOperations;

import org.junit.Test;

public class StringOperationsExceptionTest {

	@Test(expected = NullPointerException.class)
	public void test() {
		new StringOperations("");
	}
}
