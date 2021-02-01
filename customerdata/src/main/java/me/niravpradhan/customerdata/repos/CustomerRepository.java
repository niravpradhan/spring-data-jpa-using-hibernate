package me.niravpradhan.customerdata.repos;

import me.niravpradhan.customerdata.entitiies.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    @Modifying
    @Query("update Customer set email = :email where id = :id")
    void updateCustomerEmailById(@Param("email") String email, @Param("id") Integer id);
}
