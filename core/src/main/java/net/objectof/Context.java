package net.objectof;

/**
 * A Context can emit objects associated to a <em>name</em>. Generally the names
 * are <em>component names</em> as defined in {@link Named}. A Context that:
 * <ul>
 * <li>contains a set of named persistent or singleton objects is known as a
 * <em>scope</em>
 * <li>creates new objects based on a name is known as a <em>factory</em>.
 * </ul>
 * A Context can be both a scope and factory.
 * <p>
 * FAQ
 * <p>
 * Why aren't Contexts Iterable? Some Contexts don't necessarily know the
 * entirety of their elements. Consider a java Class context where Classes
 * aren't enumerable. As well, Contexts are commonly implemented as
 * packages/scopes which extend from parent Contexts. To make packages/scopes
 * Iterable we would need to collect elements up the tree (and handling
 * overridden elements). Another example is a factory, specifically a Spring
 * Framework context.
 * <p>
 * Note: Future versions of this interface will remove the permissibility of
 * "factory" and only return a repeatable object instance for each name.
 * 
 * @author jdh
 *
 * @param <T>
 *            The type of object emitted by the Context.
 */
public interface Context<T> extends Named {

	/**
	 * @param aComponentName
	 *            A name identifying the singleton or a type of instance to
	 *            return.
	 * @return An object for aComponentName or null. This interface doesn't
	 *         specify any constraints on the object that is returned for each
	 *         invocation: i.e. there is no requirement that the same object or
	 *         null or a different object will be returned for repeated calls to
	 *         this even when the <b>same name</b> is specified.
	 * @throws InvalidNameException
	 *             When aComponentName is not known by this Context.
	 */
	T forName(String aComponentName);
}
