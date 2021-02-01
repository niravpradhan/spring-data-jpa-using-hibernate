package me.niravpradhan.customerdata;

import me.niravpradhan.customerdata.entitiies.Customer;
import me.niravpradhan.customerdata.repos.CustomerRepository;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class CustomerdataApplicationTests {

    @Autowired
    CustomerRepository repository;

    @Test
    @Order(1)
    void testCreate() {
        Customer customer = new Customer();
        customer.setName("Nirav Pradhan");
        customer.setEmail("nirav.pradhan@gmail.com");

        repository.save(customer);
    }

    @Test
    @Order(2)
    void testRead() {
        repository.findById(1).ifPresent(c -> {
            assertThat(c.getId(), is(equalTo(1)));
            assertThat(c.getName(), is(equalTo("Nirav Pradhan")));
            assertThat(c.getEmail(), is(equalTo("nirav.pradhan@gmail.com")));
        });
    }

    @Test
    @Order(3)
    void testUpdate() {
        repository.findById(1).ifPresent(c -> {
            c.setEmail("nirav.pradhan@outlook.com");
            repository.save(c);
        });

        repository.findById(1).ifPresent(c -> {
            assertThat(c.getEmail(), is(equalTo("nirav.pradhan@outlook.com")));
        });
    }

    @Test
    @Order(4)
    void testDelete() {
        if (repository.existsById(1)) {
            repository.deleteById(1);
        }
    }

    @Test
    @Transactional
    @Rollback(false)
    void test_assignment4_jpql_update_customer_email_by_id() {
        repository.updateCustomerEmailById("nirav.pradhan@gmail.com", 1);

        repository.findById(1).ifPresent(c -> {
            assertThat(c.getEmail(), is(equalTo("nirav.pradhan@gmail.com")));
        });
    }
}
