package dz.wta.ooredoo.simswap.model;

import java.util.List;

public class InvalidFieldsResponse extends GenericResponse {

	private List<String> errors;

	public InvalidFieldsResponse(int code, String message, List<String> errors) {
		super(code, message);
		this.errors = errors;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
