package befaster.solutions.HLO;


import org.junit.Test;
import static org.junit.Assert.*;


class TestHello {

	@Test
	void test() {
		HelloSolution hello = new HelloSolution();
		assertNotNull(hello.hello("world"));
	}

}
