package me.niravpradhan.springdata.transactionmanagement.repos;

import me.niravpradhan.springdata.transactionmanagement.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {
}
