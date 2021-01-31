package me.niravpradhan.springdata;

import me.niravpradhan.springdata.entitiies.Customer;
import me.niravpradhan.springdata.repos.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Assignment2IdGeneratorsApplicationTests {

    @Autowired
    CustomerRepository repository;

    @Test
    void testCreate() {
        Customer customer = new Customer();
        customer.setName("Nirav Pradhan");
        customer.setEmail("nirav.pradhan@gmail.com");

        repository.save(customer);
    }

}
