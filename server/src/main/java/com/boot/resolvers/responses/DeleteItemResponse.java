package com.boot.resolvers.responses;


public class DeleteItemResponse implements IResponse{
	private boolean successful;

	public DeleteItemResponse(boolean successful) {
		this.successful = successful;
	}
	
	public boolean isDeletionSuccessful() {
		return successful;
	}
	
	
}
