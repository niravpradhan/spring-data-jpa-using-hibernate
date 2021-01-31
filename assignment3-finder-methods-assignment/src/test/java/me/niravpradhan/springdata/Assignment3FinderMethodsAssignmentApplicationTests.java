package me.niravpradhan.springdata;

import me.niravpradhan.springdata.entities.Customer;
import me.niravpradhan.springdata.repos.CustomerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Assignment3FinderMethodsAssignmentApplicationTests {

    @Autowired
    CustomerRepository repository;

    @Test
    void test_findByNameAndEmail() {
        List<Customer> customers = repository.findByNameAndEmail("Nirav Pradhan", "nirav.pradhan@gmail.com");
        customers.forEach(System.out::println);
    }

    @Test
    void test_findByEmailLike() {
        List<Customer> customers = repository.findByEmailLike("%mit%");
        customers.forEach(System.out::println);
    }

    @Test
    void test_findByIdIn() {
        List<Customer> customers = repository.findByIdIn(List.of(1L));
        customers.forEach(System.out::println);
    }
}
