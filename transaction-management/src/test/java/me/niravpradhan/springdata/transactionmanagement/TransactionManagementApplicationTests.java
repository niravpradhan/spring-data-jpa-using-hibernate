package me.niravpradhan.springdata.transactionmanagement;

import me.niravpradhan.springdata.transactionmanagement.services.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class TransactionManagementApplicationTests {

    @Autowired
    BankAccountService service;

    @Test
    void test_transfer() {
        service.transfer(500);
    }

}
