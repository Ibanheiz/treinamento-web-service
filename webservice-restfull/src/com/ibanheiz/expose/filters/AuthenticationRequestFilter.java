package com.ibanheiz.expose.filters;

import java.io.Serializable;

import javax.inject.Singleton;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

@Singleton
public class AuthenticationRequestFilter implements ContainerRequestFilter, Serializable {
	private static final long serialVersionUID = 2852372040455618957L;
	
	private static final String AUTORIZACAO = "ibanheiz";

	@Override
	public ContainerRequest filter(ContainerRequest request) {
		String headerValue = request.getHeaderValue("Authorization");
		System.out.println("Authorization" + headerValue);
		
		if (AUTORIZACAO.equals(headerValue)) {
			return request;
		}
		
		throw new WebApplicationException(Status.UNAUTHORIZED);
	}
}