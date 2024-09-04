package com.bankmanagerapp.Bankapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanagerapp.Bankapp.Service.AccountServiceimpl;
import com.bankmanagerapp.Bankapp.entity.Account;

@RestController
@RequestMapping("/account")
public class Accountcontroller {
	
	@Autowired
	AccountServiceimpl service;

	@PostMapping("/create")
	public Account CreateAC(@RequestBody Account account )
	{
		Account createac = service.createacount(account);
		return createac;
	}
	@GetMapping("/{accountnumber}")
	public  Account getaccountbyACnumber(@PathVariable long accountnumber)
	{
		Account ac = service.getAllAccountByAcNumbers(accountnumber);
		
		return ac;
	}
	
	@GetMapping("/getallaccount")
	public List<Account> getalldetailsofaccount()
	{
		List<Account> li= service.getAllAccount();
		return li;
	}
	
	@PutMapping("/deposit/{accountnumber}/{paisa}")
	public Account depositeaccoun(@PathVariable long accountnumber , @PathVariable double paisa)
	{
		Account a = service.depositeaccount(accountnumber, paisa);
		return a;
	}
	@PutMapping("/withdrow/{accountnumber}/{paisa}")
	public Account withdrowamount(@PathVariable long accountnumber ,@PathVariable double paisa)
	{
		Account a = service.WithdrowAmount(accountnumber, paisa);
		return a;
	}
	
	@DeleteMapping("/delete/{accountnumber}")
	public ResponseEntity<String> deleteaccount(@PathVariable long accountnumber)
	{
		service.closeaccount(accountnumber);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("account closed");
		
	}
}
