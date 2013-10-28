package com.pl.msarelo.wi.hangman.server.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Dao {

    private EntityManagerFactory entityManagerFactory;
    protected Class persistedClass;
    private EntityManager entityManager;

    public Dao(Class persistedClass) {
	entityManagerFactory = Persistence.createEntityManagerFactory("hangman"); // or hangman-mysql
	entityManager = entityManagerFactory.createEntityManager();
	this.persistedClass = persistedClass;
    }

    public Object findById(Long id) {
	beginTransaction();
	Object object = (Object) entityManager.find(persistedClass, id);
	commitAndCloseTransaction();
	return object;
    }

    public <T> T save(T object) {
	beginTransaction();
	entityManager.persist(object);
	entityManager.flush();
	commitAndCloseTransaction();
	return object;
    }

    public <T> T saveOrUpdate(T object) {
	beginTransaction();
	entityManager.merge(object);
	commitAndCloseTransaction();
	return object;
    }

    public void delete(Object object) {
	beginTransaction();
	entityManager.remove(object);
	commitAndCloseTransaction();
    }

    public List findAll() {
	beginTransaction();
	List result = entityManager.createNamedQuery(persistedClass.getSimpleName() + ".findAll", persistedClass).getResultList();
	commitAndCloseTransaction();
	return result;
    }

    private void beginTransaction() {

	entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();
    }

    private void commitAndCloseTransaction() {
	entityManager.getTransaction().commit();
	entityManager.close();
    }

}
