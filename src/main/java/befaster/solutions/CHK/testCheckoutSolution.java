package befaster.solutions.CHK;

import org.junit.*;

public class TestCheckoutSolution {

	
	@Test
	public void test() {
		CheckoutSolution	checkout = new CheckoutSolution();
		
		assert(checkout.checkout("AB") == 80);
		assert(checkout.checkout("AA") == 100);
		assert(checkout.checkout("AAA") == 130);
		assert(checkout.checkout(" ") == 0);
	}

}
