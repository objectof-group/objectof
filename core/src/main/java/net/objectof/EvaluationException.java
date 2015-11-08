package net.objectof;

import java.lang.reflect.InvocationTargetException;

/**
 * An EvaluationException is objectof's equivalent to an
 * InvocationTargetException. When implementing Fn.evaluate, all all Exceptions
 * (checked and runtime) <em>except</em> EvalutionException should be wrapped
 * into an EvaluationException. EvalutionExceptions should not be wrapped:
 * 
 * <pre>
 * 	try {
 * 			...
 *  }
 *  catch (EvalutionException e) {
 *  	throw e;
 *  }
 *  catch (Exception e) {
 *  	throw new EvaluationException(e);
 *  }
 * </pre>
 * 
 * Note that Throwable shouldn't, in general, be caught or cast to. Implementors
 * may unwrap the target exception of an InvocationTargetException, when an
 * instance of Exception, prior to wrapping the target into an
 * EvaluationException when there is a benefit in doing so: It's not recommended
 * or required.
 * 
 * @author jdh
 *
 */
public class EvaluationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EvaluationException(Exception aException) {
		this(aException.getMessage(), cause(aException));
	}

	public EvaluationException(String aMessage, Exception aException) {
		this(aMessage, cause(aException));
	}

	public EvaluationException(String aMessage) {
		super(aMessage);
	}

	protected EvaluationException(String aMessage, Throwable aThrowable) {
		super(aMessage, aThrowable);
	}

	/**
	 * Because EvaluationExceptions are the framework's equivalent of
	 * InvocationTargetException, we take InvocationTargetException.getCause()
	 * otherwise aException is returned.
	 * 
	 * @param aException
	 * @return aException or aException.getCause()
	 */
	public static Throwable cause(Exception aException) {
		return aException instanceof InvocationTargetException ? aException.getCause() : aException;
	}
}
