package dz.wta.ooredoo.simswap.model;

public class GenericResponse {

	public final static String SUCCESS_MESSAGE = "success";
	public final static String ERROR_MESSAGE = "error";
	public final static String SIM_ALREADY_EXISTS_MESSAGE = "simswap already exist";
	public final static String SIM_NOT_EXISTS_MESSAGE = "simswap doesn't exist";
	public final static String SIM_ALREADY_DEACTIVATED_MESSAGE = "simswap already deactivated";
	public final static String SIM_DEACTIVATED_MESSAGE = "simswap deactivated successfuly";
	public final static String ESN_NOT_ILLIGIBLE_MESSAGE = "esn not illigble";
	public final static String GENERIC_ERROR ="Une erreur innatendu est survenu";
	public final static String NOT_EXIST_REASON ="Not Exist Reason";
	

	private int code;
	private String message;

	public GenericResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
