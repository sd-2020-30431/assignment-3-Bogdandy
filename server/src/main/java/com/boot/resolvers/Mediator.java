package com.boot.resolvers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.boot.resolvers.handlers.*;
import com.boot.resolvers.requests.*;
import com.boot.resolvers.responses.*;

@Component
public class Mediator implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;
	
	private final Map<Class <? extends IRequest>, Class<? extends IHandler<? extends IRequest, ? extends IResponse>>> hashHandler;
	
	public Mediator() {
		this.hashHandler = new HashMap<>();
		hashHandler.put(LogInQuery.class, LogInHandler.class);
		hashHandler.put(UserGroceryListQuery.class, UserGroceryListHandler.class);
		hashHandler.put(AllUserGroceryListItemsQuery.class, AllUserGroceryListItemsHandler.class);
		hashHandler.put(SearchItemQuery.class, SearchItemHandler.class);
		hashHandler.put(NewUserRequest.class, NewUserHandler.class);
		hashHandler.put(NewGroceryItemMutation.class, NewGroceryItemHandler.class);
		hashHandler.put(ModifyGroceryItemMutation.class, ModifyGroceryItemHandler.class);
		hashHandler.put(DeleteItemMutation.class, DeleteItemHandler.class);
		hashHandler.put(ClearListMutation.class, ClearListHandler.class);
	}
	
	@SuppressWarnings("unchecked")
	public <T extends IRequest, R extends IResponse> IHandler<T,R> handle(T command){
		Class<? extends IHandler<? extends IRequest, ? extends IResponse>> whichHandler = hashHandler.get(command.getClass());
		return (IHandler<T, R>)applicationContext.getBean(whichHandler);
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		
	}
	
}
