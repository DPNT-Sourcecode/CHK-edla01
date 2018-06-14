package befaster.solutions.HLO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestHello {

	@Test
	void test() {
		HelloSolution hello = new HelloSolution();
		assertNotNull(hello.hello("world"));
	}

}
