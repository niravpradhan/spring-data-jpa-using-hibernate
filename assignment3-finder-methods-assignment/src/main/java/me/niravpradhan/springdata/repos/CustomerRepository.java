package me.niravpradhan.springdata.repos;

import me.niravpradhan.springdata.entities.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByNameAndEmail(String name, String email);

    List<Customer> findByEmailLike(String email);

    List<Customer> findByIdIn(List<Long> ids);
}
