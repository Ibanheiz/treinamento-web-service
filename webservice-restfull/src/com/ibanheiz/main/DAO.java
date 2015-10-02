package com.ibanheiz.main;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 * Geneŕicao
 * @author Nicolas Ibanheiz | 22/09/2015
 * @param <T>
 */
public class DAO<T> implements Serializable {
	private static final long serialVersionUID = 3042466744415667858L;
	
	private final Class<T> classe;
	
	@Inject
	protected EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public DAO() {
		this.classe = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	/**
	 * @author Nicolas Ibanheiz | 22/09/2015
	 * @param objeto
	 */
	public void save(T objeto) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(objeto);
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
	
	// TODO update
	
	// TODO delete
	
	// TODO Find by id

	@SuppressWarnings("rawtypes")
	public List buscarTodos() {
		return entityManager.createQuery("FROM " + classe.getSimpleName()).getResultList();
	}
}
