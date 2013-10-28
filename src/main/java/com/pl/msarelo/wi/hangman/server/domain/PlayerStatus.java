/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.domain;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author marcin
 */
@Entity
@XmlType(name = "Player")
public class PlayerStatus extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private int countOfAttempt;
    private int counOfFailure;

    public int getCountOfAttempt() {
	return countOfAttempt;
    }

    public void setCountOfAttempt(int countOfAttempt) {
	this.countOfAttempt = countOfAttempt;
    }

    public int getCounOfFailure() {
	return counOfFailure;
    }

    public void setCounOfFailure(int counOfFailure) {
	this.counOfFailure = counOfFailure;
    }

}
