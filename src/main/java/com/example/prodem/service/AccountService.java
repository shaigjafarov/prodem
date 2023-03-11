package com.example.prodem.service;

import com.example.prodem.model.Account;
import com.example.prodem.repository.AccountRepository;
import java.util.List;

public class AccountService {

    AccountRepository accountRepository;

    AccountService (AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }

    Account getAccountById (Long id){
        return  accountRepository.getAccountById(id);
    }

    List<Account> getAllAccount (){

        return null;

    }
}
