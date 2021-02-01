package me.niravpradhan.customerdata;

import me.niravpradhan.customerdata.entitiies.Customer;
import me.niravpradhan.customerdata.repos.CustomerRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Order(5)
    void test_assignment4_jpql_update_customer_email_by_id() {
        repository.updateCustomerEmailById("nirav.pradhan@gmail.com", 1);

        repository.findById(1).ifPresent(c -> {
            assertThat(c.getEmail(), is(equalTo("nirav.pradhan@gmail.com")));
        });
    }

    @Test
    void test_findAll_assignemnt5_paging_and_sorting() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Sort.Order.desc("id")));

        List<Customer> results = repository.findAll(pageable);
        results.forEach(System.out::println);
    }
}
