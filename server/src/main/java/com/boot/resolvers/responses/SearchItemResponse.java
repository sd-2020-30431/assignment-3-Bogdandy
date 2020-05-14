package com.boot.resolvers.responses;;

public class SearchItemResponse implements IResponse{
	private boolean successful;
	
	public SearchItemResponse(boolean successful) {
		this.successful = successful;
	}
	
	public boolean doesItemExist() {
		return successful;
	}
}
