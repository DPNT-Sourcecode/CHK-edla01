package befaster.solutions;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import befaster.solutions.SUM.TestSumSolution;
import befaster.solutions.HLO.TestHello;;

public class TestRunner {

	public static void main(String[] args) {

		Result  result = JUnitCore.runClasses(	TestSumSolution.class,
												TestHello.class);
		
		for (Failure failure: result.getFailures())
		{
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());

	}

}
