/*
 * @author Joey Smeets and Ruth Wenzel
 * @version 18.06.2021
 */
public class EmptySetException extends Exception {
	
	/**
	 * serialVersionUID generated by Eclipse
	 */
	private static final long serialVersionUID = -9162791177362385299L;

	/*
	 * constructor to throw the exception with a message
	 */
	public EmptySetException(String message) {
        super(message); 
    }
} 
