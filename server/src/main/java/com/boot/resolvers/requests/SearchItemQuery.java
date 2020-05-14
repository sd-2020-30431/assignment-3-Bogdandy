package com.boot.resolvers.requests;

import com.boot.resolvers.requests.IRequest;

import lombok.Data;

@Data
public class SearchItemQuery implements IRequest{
	private Long idUserList;
	private int listNo;
	private String itemName;
	
	public SearchItemQuery(Long idUserList, int listNo, String itemName) {
		this.idUserList = idUserList;
		this.listNo = listNo;
		this.itemName = itemName;
	}
}
