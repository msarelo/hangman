/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pl.msarelo.wi.hangman.server.domain;

/**
 *
 * @author Marcin
 */
public class Player extends AbstractEntity {

    private String name;
    private int countOfAttempt;
    private int counOfFailure;

    public Player() {
    }

    public Player(String name) {
	this.name = name;
	this.countOfAttempt = 0;
	this.counOfFailure = 0;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

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
