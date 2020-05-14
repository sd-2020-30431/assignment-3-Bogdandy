package com.boot.resolvers.handlers;

import com.boot.resolvers.requests.IRequest;
import com.boot.resolvers.responses.IResponse;

public interface IHandler<T extends IRequest, R extends IResponse>
{
	R Handle(T q);
}
