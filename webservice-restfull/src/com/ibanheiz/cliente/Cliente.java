package com.ibanheiz.cliente;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.ibanheiz.telefone.Telefone;
import com.ibanheiz.utils.XmlSetReferences;

import java.util.List;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@XmlType(name = "Cliente", propOrder = { "id", "nome", "cnpj", "cpf", "telefones" })
public class Cliente implements Serializable {
	private static final long serialVersionUID = -3110647821276898911L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String cnpj;

	private String cpf;

	private String nome;

	// bi-directional many-to-one association to Telefone
	@OneToMany(mappedBy = "cliente", cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@XmlSetReferences(classe=Telefone.class, getter="getTelefones")
	private List<Telefone> telefones;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Telefone> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Telefone addTelefone(Telefone telefone) {
		getTelefones().add(telefone);
		telefone.setCliente(this);

		return telefone;
	}

	public Telefone removeTelefone(Telefone telefone) {
		getTelefones().remove(telefone);
		telefone.setCliente(null);

		return telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
	}

}