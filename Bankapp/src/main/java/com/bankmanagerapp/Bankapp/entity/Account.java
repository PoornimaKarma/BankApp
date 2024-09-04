package com.bankmanagerapp.Bankapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long account_number;
	private String account_holdername;
	private double account_balance;
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Account(String account_holdername, double account_balance) {
		super();
		this.account_holdername = account_holdername;
		this.account_balance = account_balance;
	
	}

	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public String getAccount_holdername() {
		return account_holdername;
	}
	public void setAccount_holdername(String account_holdername) {
		this.account_holdername = account_holdername;
	}
	public double getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(double account_balance) {
		this.account_balance = account_balance;
	}
	@Override
	public String toString() {
		return "Bank [account_number=" + account_number + ", account_holdername=" + account_holdername
				+ ", account_balance=" + account_balance + "]";
	}
	
	
}
