package me.niravpradhan.springdata.repos;

import me.niravpradhan.springdata.entitiies.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
