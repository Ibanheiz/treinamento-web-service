package com.ibanheiz.main;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.ibanheiz.cliente.Cliente;
import com.ibanheiz.cliente.ClienteService;

@Named
@ViewScoped
public class MainBean implements Serializable {
	private static final long serialVersionUID = -8189667399168215506L;

	@Inject
	private ClienteService clienteService;

	private String souinutil;

	@PostConstruct
	public void init() {
		System.out.println("teste");
		List<Cliente> clientes = clienteService.buscarTodos();
		System.out.println("Quantidade de clientes: " + clientes.size());
	}

	/**
	 * @return the souinutil
	 */
	public String getSouinutil() {
		return souinutil;
	}

	/**
	 * @param souinutil
	 *            the souinutil to set
	 */
	public void setSouinutil(String souinutil) {
		this.souinutil = souinutil;
	}
}
