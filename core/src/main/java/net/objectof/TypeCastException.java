package net.objectof;

public class TypeCastException extends ClassCastException {

	private static final long serialVersionUID = 1L;

	public TypeCastException(java.lang.reflect.Type aCandidate, java.lang.reflect.Type aContract) {
		this(aCandidate.getTypeName() + " is not a " + aContract.getTypeName());
	}

	public TypeCastException(String aMessage) {
		super(aMessage);
	}

}
