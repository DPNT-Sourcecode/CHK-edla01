package befaster.solutions.HLO;


public class HelloSolution {
	/**
	 * @param = a String. Ignore for now.
 	   @return = a String containing a message
	 */
    public String hello(String friendName) {
    	if ( friendName != null )
    		return "Hello, " + friendName + "!";
        return("Hello, World!");
    }
}
