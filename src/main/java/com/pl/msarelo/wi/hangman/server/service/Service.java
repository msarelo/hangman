/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.service;

import com.pl.msarelo.wi.hangman.server.dao.Dao;
import java.util.List;
import org.jodah.typetools.TypeResolver;

/**
 *
 * @author marcin
 */
public class Service<T> {

    protected Dao dao;
    protected Class<T> entityClass;

    public Service() {
	this.entityClass = (Class<T>) TypeResolver.resolveArguments(getClass(), Service.class)[0];
	dao = new Dao(entityClass);
    }

    public T findById(Long id) {
	return (T) dao.findById(id);
    }

    public List<T> getAll() {
	return dao.findAll();
    }
}
