package com.bankmanagerapp.Bankapp.Service;

import java.util.List;

import com.bankmanagerapp.Bankapp.entity.Account;

public interface ACservice {

	public Account createacount(Account account);
	public Account getAllAccountByAcNumbers(long account_number);
	public List<Account> getAllAccount();
	public Account depositeaccount(long accountnimber , double paisa);
	public Account WithdrowAmount(long accountnumber , double paisa);
	public void closeaccount(long accountnumber);
}
