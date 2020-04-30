package dz.wta.ooredoo.simswap.model;

public class LoginResponse extends GenericResponse {

	public final static String BAD_CREDENTIALS = "bad credentials";
	private String token;

	public LoginResponse(int code, String message, String token) {
		super(code, message);
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
