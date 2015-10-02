package com.ibanheiz.expose;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.ibanheiz.cliente.Cliente;
import com.ibanheiz.cliente.ClienteService;

@Path("/clientes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
public class ClienteResource  implements Serializable  {
	private static final long serialVersionUID = -6997135368312026507L;

	@Inject
	private ClienteService clienteService;
	
	@GET
	public Response buscarTodos() {
		List<Cliente> clientes = clienteService.buscarTodos();
		return Response.ok(clientes.toArray(new Cliente[clientes.size()])).build();
	}
	
	@POST
	public Response salvar(Cliente cliente) {
		try {
			
			System.out.println(cliente);
//			clienteService.salvar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		} 
		return Response.ok(cliente).build();
	}
	
	@PUT
	@Path("{id}")
	public Response alterar(@PathParam("id") String id, Cliente cliente) {
		cliente.setId(Integer.parseInt(id));
		try {
			clienteService.alterar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
			throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
		} 
		return Response.ok(cliente).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") String id) {
		return Response.status(Status.NOT_IMPLEMENTED).build();
	}
	
}
