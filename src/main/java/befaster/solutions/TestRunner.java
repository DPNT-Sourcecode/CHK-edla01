package befaster.solutions;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.Failure;
import org.junit.runner.notification.Failure;

import befaster.solutions.SUM.TestSumSolution;

public class TestRunner {

	public static void main(String[] args) {

		Result  result = JUnitCore.runClasses(TestSumSolution.class);
		
		for (Failure failure: result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}

}
