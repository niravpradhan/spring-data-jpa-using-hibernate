package me.niravpradhan.springdata.transactionmanagement.services;

import me.niravpradhan.springdata.transactionmanagement.entities.BankAccount;
import me.niravpradhan.springdata.transactionmanagement.repos.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    BankAccountRepository repository;

    @Override
    @Transactional
    public void transfer(int amount) {
        BankAccount obamaAccount = repository.findById(1).get();
        BankAccount trumpAccount = repository.findById(2).get();

        obamaAccount.setBalance(obamaAccount.getBalance() - amount);
        repository.save(obamaAccount);

        if(true) {
            throw new RuntimeException();
        }

        trumpAccount.setBalance(trumpAccount.getBalance() + amount);
        repository.save(trumpAccount);
    }
}
