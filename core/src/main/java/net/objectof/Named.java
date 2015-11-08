package net.objectof;

/**
 * A Named object has an absolute, uniform name within the objectof naming
 * scheme. A Name isn't necessarily unique however it is a qualified,
 * distinguished name with a defined scheme.
 */
public interface Named {
	/**
	 * @return The absolute, uniform name of the object.
	 */
	String getUniqueName();

	default String getUri() {
		return "ans://" + getUniqueName();
	}
}