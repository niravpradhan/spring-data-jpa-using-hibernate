package me.niravpradhan.springdata.repos;

import me.niravpradhan.springdata.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

    List<Product> findByName(String name);

    List<Product> findByNameAndDesc(String name, String desc);

    List<Product> findByPriceGreaterThanEqual(Double price);

    List<Product> findByDescContains(String desc);

    List<Product> findByPriceBetween(Double price1, Double price2);

    List<Product> findByDescLike(String desc);

    List<Product> findByIdIn(List<Integer> ids);

    List<Product> findByIdIn(List<Integer> ids, Pageable pageable);
}
