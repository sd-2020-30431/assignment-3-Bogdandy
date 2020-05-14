package com.boot.resolvers.requests;

import lombok.Data;

@Data
public class ClearListMutation implements IRequest{
	private Long idUserL;
	private int listNo;
	
	public ClearListMutation(Long idUserL, int listNo) {
		this.idUserL = idUserL;
		this.listNo = listNo;
	}
}
