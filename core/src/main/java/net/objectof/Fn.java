package net.objectof;

/**
 * Perform evaluation with the supplied arguments, if any. In general,
 * implementations should ensure the evaluation is immediate and fails-fast:
 * Lazy evaluation (currying) should be avoided when possible. Other functional
 * interfaces are to be used for a more generalized apply() interface.
 * <p>
 * The signature for the argument parameters is not defined by this interface.
 * Implementations may treat the arguments as a generic tuple to a formal
 * parameter list or they may treat the arguments as an arbitrary Object[].
 * <p>
 * See EvaluationException for Exception handling guidance when implementing Fn.
 * 
 * @author jdh
 *
 */

@FunctionalInterface
public interface Fn {

	public Fn NIL = (Object[] IGNORED) -> {
		return null;
	};

	/**
	 * Evaluate with arguments or null.
	 * 
	 * @param aArguments
	 *            Optional. A series of object arguments to evaluation.
	 *            Generally null should be handled as an empty array however it
	 *            can be treated as a separate condition if required.
	 * @return The Object of evaluation.
	 * @throws EvaluationException
	 */
	@Selector("")
	Object evaluate(Object... aDomain) throws EvaluationException;

	/**
	 * Evaluate with no arguments. The default behavior should always be
	 * performed.
	 *
	 * @return The Object of evaluation.
	 */
	@Selector("evaluate")
	default Object evaluate() {
		return evaluate(Receiver.NOARGS);
	}
}
