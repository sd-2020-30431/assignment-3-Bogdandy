package com.boot.resolvers.requests;

import lombok.Data;

@Data
public class UserGroceryListQuery implements IRequest{
	private Long idUserList;
	private int listNo;
	
	public UserGroceryListQuery(Long idUserList, int listNo) {
		this.idUserList = idUserList;
		this.listNo = listNo;
	}
}
