package befaster.solutions.HLO;

import org.junit.*;

import org.junit.Test;

class TestHello {

	@Test
	void test() {
		HelloSolution hello = new HelloSolution();
		assert(hello.hello("world").equalsIgnoreCase("Hello, World!"));
	}

}
