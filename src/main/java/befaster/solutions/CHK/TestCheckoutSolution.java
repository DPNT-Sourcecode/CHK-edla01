package befaster.solutions.CHK;

import org.junit.*;

public class TestCheckoutSolution {

	
	@Test
	public void test() {
		CheckoutSolution	checkout = new CheckoutSolution();
		
		assert(checkout.checkout("AB") == 80);
		assert(checkout.checkout("ABCD") == 115);
		assert(checkout.checkout("AA") == 100);
		assert(checkout.checkout("AAA") == 130);
		assert(checkout.checkout("AAAA") == 180);
		assert(checkout.checkout("AAAAA") == 200);
		assert(checkout.checkout(" ") == -1);
		assert(checkout.checkout("") == 0);
		
		assert(checkout.checkout("EEB") == 80);
		assert(checkout.checkout("EEEB") == 120);
		assert(checkout.checkout("EEEEBB") == 160);

	}

}
