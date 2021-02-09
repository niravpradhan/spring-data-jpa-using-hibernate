package me.niravpradhan.springdata.hibernateinheritance;

import me.niravpradhan.springdata.hibernateinheritance.entities.Cheque;
import me.niravpradhan.springdata.hibernateinheritance.entities.CreditCard;
import me.niravpradhan.springdata.hibernateinheritance.repos.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HibernateInheritanceApplicationTests {

    @Autowired
    PaymentRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void test_create_credit_card_payment() {
        CreditCard cc = new CreditCard();
        cc.setCardnumber("1234567890123456");
        cc.setAmount(1000D);

        repository.save(cc);
    }

    @Test
    void test_create_cheque_payment() {
        Cheque ch = new Cheque();
        ch.setChecknumber("1234567890");
        ch.setAmount(1000D);

        repository.save(ch);
    }
}
