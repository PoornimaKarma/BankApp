package com.bankmanagerapp.Bankapp.Service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bankmanagerapp.Bankapp.Repository.acRepository;
import com.bankmanagerapp.Bankapp.entity.Account;
@Service
public class AccountServiceimpl implements ACservice
{

	@Autowired
   acRepository repository;
	
	@Override
	public Account createacount(Account account) 
	{
		  Account account_save = repository.save(account);
		
		return account_save;
	}

	@Override
	public Account getAllAccountByAcNumbers(long account_number) {
	Optional<Account> AClist = repository.findById(account_number);
		
			if(AClist.isEmpty())
			{
				throw new RuntimeException("account is empty"); 
			}
			Account data = AClist.get();
			return data;
	}

	@Override
	public List<Account> getAllAccount() {
	List<Account> aclist1=	repository.findAll();
		return aclist1;
	}

	@Override
	public Account depositeaccount(long accountnumber, double paisa) {
		Optional<Account> account =   repository.findById(accountnumber);
		if(account.isEmpty())
		{
			throw new RuntimeException("account no present");
			
		}
		Account acpresent = account.get();
		double totleblnce = acpresent.getAccount_balance()+paisa;
		acpresent.setAccount_balance(totleblnce);
		repository.save(acpresent);
		return acpresent;
	}

	@Override
	public Account WithdrowAmount(long accountnumber, double paisa) {
		Optional<Account> accountlist = repository.findById(accountnumber);
		if(accountlist.isEmpty())
		{
			throw new RuntimeException("account is empty");
		}
		Account ac =  accountlist.get();
		double acbalance = ac.getAccount_balance()-paisa;
		ac.setAccount_balance(acbalance);
		repository.save(ac);
		return ac;
	}

	@Override
	public void closeaccount(long accountnumber) {
		getAllAccountByAcNumbers(accountnumber);
		repository.deleteById(accountnumber);
		
	}
  
}
