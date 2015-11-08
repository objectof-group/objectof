package net.objectof;

/**
 * Thrown when a name isn't recognized.
 * 
 * @author jdh
 * 
 */
public class InvalidNameException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public InvalidNameException(String aName) {
		super(aName);
	}
}
