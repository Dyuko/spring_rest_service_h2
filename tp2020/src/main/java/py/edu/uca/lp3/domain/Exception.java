package py.edu.uca.lp3.domain;

public class Exception extends RuntimeException {

	private static final long serialVersionUID = 4785145566889666717L;
	
	@SuppressWarnings("unused")
	private final String msgError;
	
	public Exception(String error) {
		this.msgError=error;
	}

}
