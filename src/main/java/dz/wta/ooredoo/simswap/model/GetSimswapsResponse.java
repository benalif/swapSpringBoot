package dz.wta.ooredoo.simswap.model;

import java.util.List;

import dz.wta.ooredoo.simswap.entity.SwapEsnEntry;

public class GetSimswapsResponse extends GenericResponse {

	private List<SwapEsnEntry> simSwapList;

	public GetSimswapsResponse(int code, String message, List<SwapEsnEntry> simSwapList) {
		super(code, message);
		this.simSwapList = simSwapList;
	}

	public List<SwapEsnEntry> getSimSwapList() {
		return simSwapList;
	}

	public void setSimSwapList(List<SwapEsnEntry> simSwapList) {
		this.simSwapList = simSwapList;
	}

}
