package dz.wta.ooredoo.simswap.model;

import dz.wta.ooredoo.simswap.entity.SwapEntry;

public class SwapEntryResponse extends GenericResponse {

	private SwapEntry swapEntry;

	public SwapEntryResponse(int code, String message, SwapEntry swapEntry) {
		super(code, message);
		this.swapEntry = swapEntry;
	}

	public SwapEntry getSwapEntry() {
		return swapEntry;
	}

	public void setSwapEntry(SwapEntry swapEntry) {
		this.swapEntry = swapEntry;
	}

}
