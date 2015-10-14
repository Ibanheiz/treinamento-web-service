package com.ibanheiz.utils;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAProducer {
	
	@Produces
	@ApplicationScoped
	public EntityManagerFactory criarFactory() {
		return Persistence.createEntityManagerFactory("restfull");
	}

	@Produces
	@RequestScoped
	public EntityManager criarEntityManager(EntityManagerFactory factory) {
		return factory.createEntityManager();
	}
	
	public void fecharEntityManager(@Disposes EntityManager entityManager) {
		entityManager.close();
	}
}
