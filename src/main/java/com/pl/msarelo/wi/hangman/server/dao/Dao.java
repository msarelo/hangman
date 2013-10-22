package com.pl.msarelo.wi.hangman.server.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {

    protected Class persistedClass;
    private final EntityManager entityManager;

    public Dao(Class persistedClass) {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hangman");
	entityManager = entityManagerFactory.createEntityManager();

    }

    public Object findById(int id) {
	Object object = (Object) entityManager.find(persistedClass, id);
	return object;
    }

    public void save(Object object) {
	entityManager.persist(object);
    }

    public void saveOrUpdate(Object object) {
	entityManager.merge(object);
    }

    public void delete(Object object) {
	entityManager.remove(object);
    }

    public List findAll() {
	return entityManager.createNamedQuery("SELECT o FROM " + persistedClass.getSimpleName() + " o").getResultList();
    }

}
