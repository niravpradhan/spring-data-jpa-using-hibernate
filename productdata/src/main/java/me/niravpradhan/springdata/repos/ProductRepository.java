package me.niravpradhan.springdata.repos;

import me.niravpradhan.springdata.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
