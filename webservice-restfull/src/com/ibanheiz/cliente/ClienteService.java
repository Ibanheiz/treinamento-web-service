package com.ibanheiz.cliente;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;


public class ClienteService implements Serializable {
	private static final long serialVersionUID = 4763420234363367959L;

	@Inject
	private ClienteDAO clienteDAO;

	@SuppressWarnings("unchecked")
	public List<Cliente> buscarTodos() {
		return clienteDAO.buscarTodos();
	}

	public void salvar(Cliente cliente) {
		clienteDAO.save(cliente);
	}

	public void alterar(Cliente cliente) {
		clienteDAO.update(cliente);
	}
}
