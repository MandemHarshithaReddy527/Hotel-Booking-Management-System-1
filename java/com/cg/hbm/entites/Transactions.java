package com.cg.hbm.entites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transactions {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int transaction_id;
	private double amount;
	public Transactions() {
		
	}
	public Transactions(int transaction_id, double amount) {
		super();
		this.transaction_id = transaction_id;
		this.amount = amount;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
