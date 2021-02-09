package me.niravpradhan.springdata.hibernateinheritance.repos;

import me.niravpradhan.springdata.hibernateinheritance.entities.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
}
