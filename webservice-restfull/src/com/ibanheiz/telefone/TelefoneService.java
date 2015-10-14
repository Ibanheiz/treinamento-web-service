package com.ibanheiz.telefone;

import java.io.Serializable;

import javax.inject.Inject;


public class TelefoneService implements Serializable {
	private static final long serialVersionUID = 4763420234363367959L;

	@Inject
	private TelefoneDAO TelefoneDAO;
}
