package com.iperdesign.datametrix.controller;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.iperdesign.datametrix.bean.ExceptionMessage;
import com.iperdesign.datametrix.exception.ElementNotFoundException;



@Provider
public class ElementNotFoundExceptionMapper implements ExceptionMapper<ElementNotFoundException>{

	@Override
	public Response toResponse(ElementNotFoundException cnfe) {
		
		ExceptionMessage exceptionMessage= new ExceptionMessage(cnfe.getExceptionMessage(),"404");
		return Response.status(Status.NOT_FOUND).entity(exceptionMessage).build();
	}

	
}
