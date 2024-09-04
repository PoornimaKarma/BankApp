package com.bankmanagerapp.Bankapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankmanagerapp.Bankapp.entity.Account;

public interface acRepository extends JpaRepository<Account, Long> 
{

}
