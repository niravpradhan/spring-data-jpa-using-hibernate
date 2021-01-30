package me.niravpradhan.customerdata.repos;

import me.niravpradhan.customerdata.entitiies.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
