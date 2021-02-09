package me.niravpradhan.springdata.associations.onetomany.repos;

import me.niravpradhan.springdata.associations.onetomany.entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
