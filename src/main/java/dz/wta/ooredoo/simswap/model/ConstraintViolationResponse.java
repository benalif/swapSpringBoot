package dz.wta.ooredoo.simswap.model;

public class ConstraintViolationResponse extends GenericResponse {

	private String error;

	public ConstraintViolationResponse(int code, String message, String error) {
		super(code, message);
		this.error = error;
		// TODO Auto-generated constructor stub
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
