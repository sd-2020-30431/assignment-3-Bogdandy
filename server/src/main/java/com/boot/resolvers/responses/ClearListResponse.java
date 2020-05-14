package com.boot.resolvers.responses;

public class ClearListResponse implements IResponse{
	private boolean successful;

	public ClearListResponse(boolean successful) {
		this.successful = successful;
	}
	
	public boolean isClearSuccessful() {
		return successful;
	}
}
