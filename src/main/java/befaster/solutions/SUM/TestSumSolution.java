package befaster.solutions.SUM;

import org.junit.*;

import org.junit.Test;

public class TestSumSolution {

	@Test
	public void test() {
		
		SumSolution	sum = new SumSolution();
		
		for (int x=0;x<100;x++)
		{
			for (int y=0; y<100; y++ )
			{
				assert(sum.compute(x, y)==(x+y));
			}
		}
	}
}
