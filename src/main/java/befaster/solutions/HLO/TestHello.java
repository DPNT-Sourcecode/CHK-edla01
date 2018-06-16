package befaster.solutions.HLO;

import org.junit.*;

import org.junit.Test;

public class TestHello {

	@Test
	public void test() {
		HelloSolution hello = new HelloSolution();
		assert(hello.hello(null).equalsIgnoreCase("Hello, World!"));
		assert(hello.hello("valtech").equalsIgnoreCase("Hello, valtech!"));

	}

}
