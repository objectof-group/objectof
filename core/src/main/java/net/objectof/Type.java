package net.objectof;

/**
 * A Type is a Named object that classifies objects. Type provides a minimal
 * interface into typing. Types in different contexts with the same relative
 * component names may represent the same concept within different
 * implementations or facets.
 * <p>
 * Some contract interrogation methods in this interface (or sub-interfaces)
 * return tri-state Boolean. Boolean.TRUE should only be returned when this Type
 * considers aObject offer under the strictest contract to be met. Boolean.FALSE
 * should be returned when the offer is outright rejected. Return null when
 * unknown, "somewhat" (same characteristics but different facet), n/a, etc. It
 * is expected that the majority of consumers will treat null as false therefore
 * the unboxing performed by the compiler can generally be used. For example:
 * <p>
 * <code>
 * 	if (!aType.isInstance(aObject)) throw new RuntimeException("failed contract");
 * </code>
 * 
 * @author jdh
 */
public interface Type extends Named, java.lang.reflect.Type {

	/**
	 * Returns true when this Type considers aObject to be an instance of this.
	 * The default uses this.getTypeName() equality with aObject's class when
	 * aObject is not null.
	 * 
	 * @return true when this Type considers aObject to be an instance of this.
	 */
	default Boolean isInstance(Object aObject) {
		return aObject != null & isAssignable(aObject.getClass());
	}

	/**
	 * Determines the assignability of an instance of the argument type to an
	 * instance of this type. This method is similar in purpose to
	 * Class.isAssignableFrom().
	 * <p>
	 * The strictest (and simplest) form of assignability is an identity match
	 * (this == aType). All implementations must answer true for an identity
	 * match.
	 * <p>
	 * Note that assignability might be determined through the uniform name or a
	 * portion thereof or, more commonly, through getTypeName(). For example,
	 * given types with names of "ns.acme.com/2015/ctx1/app.ui.Widget" and
	 * "ns.rrinc.net/2014/afw/app.ui.Widget", either may answer true or false
	 * based on the common path suffix. Also note there is no requirement that
	 * there be commonality in the two names. One system may simply map names,
	 * paths, etc. into its type system.
	 *
	 * @return true when aType is assignable to this.
	 */
	default boolean isAssignable(java.lang.reflect.Type aType) {
		return aType == this;
	}
}
