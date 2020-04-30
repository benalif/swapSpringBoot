package dz.wta.ooredoo.simswap.model;

import java.util.List;

import dz.wta.ooredoo.simswap.entity.Reason;

public class ReasonsResponse extends GenericResponse {

	List<Reason> reasons;

	public ReasonsResponse(int code, String message, List<Reason> reasons) {
		super(code, message);
		this.reasons = reasons;
	}

	public List<Reason> getReasons() {
		return reasons;
	}

	public void setReasons(List<Reason> reasons) {
		this.reasons = reasons;
	}

}
