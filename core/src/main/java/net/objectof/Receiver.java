package net.objectof;

/**
 * A Receiver can evaluate messages in a generic way. Subinterfaces provide the
 * means to interrogate a receiver's interface.
 * 
 * @author john
 *
 */
@FunctionalInterface
@Selector
public interface Receiver {

	public Object[] NOARGS = new Object[0];

	/**
	 * Given a message, perform a method/function.
	 * 
	 * @param aSelector
	 *            The selector to route aArguments to the appropriate method or
	 *            function.
	 * @param aArguments
	 *            The message arguments.
	 * @return The evaluation output.
	 * @throws InvalidNameException
	 *             when aSelector isn't defined by this Receiver.
	 * @throws EvaluationException
	 *             when evaluation cannot be performed. All runtime exceptions
	 *             from evaluation should be wrapped (as the target exception)
	 *             in an EvaluationException.
	 */
	@Selector("perform:with:")
	public Object perform(String aSelector, Object... aArguments) throws InvalidNameException, EvaluationException;

	/**
	 * Perform with no arguments. The default behavior should always be
	 * performed.
	 * 
	 * @param aSelector
	 *            The selector to route aArguments to the appropriate method or
	 *            function.
	 * @return The evaluation output.
	 */
	@Selector("perform")
	default Object perform(String aSelector) {
		return perform(aSelector, NOARGS);
	}
}
