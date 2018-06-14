package befaster.solutions.CHK;

import org.junit.*;

class TestCheckoutSolution {

	
	@Test
	void test() {
		CheckoutSolution	checkout = new CheckoutSolution();
		
		assert(checkout.checkout("AB") == 80);
	}

}
