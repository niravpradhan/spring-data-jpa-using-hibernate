package me.niravpradhan.springdata;

import me.niravpradhan.springdata.entities.Product;
import me.niravpradhan.springdata.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class PagingAndSortingApplicationTests {

    @Autowired
    ProductRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreate() {
        Product product = new Product();
        product.setName("IPhone");
        product.setDesc("Awesome");
        product.setPrice(1000d);

        repository.save(product);
    }

    @Test
    void testRead() {
        repository.findById(1).ifPresent(p -> {
            assertThat(p.getName(), is(equalTo("IPhone")));
            assertThat(p.getDesc(), is(equalTo("Awesome")));
        });
    }

    @Test
    void testUpdate() {
        Product product = repository.findById(1).get();
        product.setPrice(1200d);

        repository.save(product);
    }

    @Test
    void testDelete() {
        if (repository.existsById(1)) {
            System.out.println("Deleting a product");
            repository.deleteById(1);
        }
    }

    @Test
    void testCount() {
        System.out.println("Total Records=" + repository.count());
    }

    @Test
    void testFindByName() {
        List<Product> products = repository.findByName("IWatch");
        assertThat(products.size(), is(equalTo(1)));
        products.forEach(System.out::println);
    }

    @Test
    void testFindByNameAndDescription() {
        List<Product> products = repository.findByNameAndDesc("TV", "From Samsung Inc");
        assertThat(products.size(), is(equalTo(1)));
        products.forEach(System.out::println);
    }

    @Test
    void testFindByPriceGreaterThanEqual() {
        List<Product> products = repository.findByPriceGreaterThanEqual(1500d);
        products.forEach(System.out::println);
    }

    @Test
    void testFindByDescContains() {
        List<Product> products = repository.findByDescContains("LG");
        products.forEach(System.out::println);
    }

    @Test
    void testFindByPriceBetween() {
        List<Product> products = repository.findByPriceBetween(1000d, 2000d);
        products.forEach(System.out::println);
    }

    @Test
    void testFindByDescLike() {
        List<Product> products = repository.findByDescLike("%LG%");
        products.forEach(System.out::println);
    }

    @Test
    void testFindByIdIn() {
        List<Product> products = repository.findByIdIn(List.of(1, 2));
        products.forEach(System.out::println);
    }

    @Test
    void test_findAllPaging() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(new Order(Sort.Direction.DESC, "price")));

        Page<Product> products = repository.findAll(pageable);
        products.forEach(System.out::println);
    }

    @Test
    void test_findAllSorting() {
        //Iterable<Product> products = repository.findAll(Sort.by("name"));
        Iterable<Product> products = repository.findAll(Sort.by(new Order(Sort.Direction.DESC, "name")));
        products.forEach(System.out::println);
    }

    @Test
    void test_sort_by_multiple_properties() {
        Iterable<Product> products = repository.findAll(Sort.by(Sort.Direction.DESC, "name", "price"));
        products.forEach(System.out::println);
    }

    @Test
    void test_sort_by_multiple_properties_and_directions() {
        Iterable<Product> products = repository.findAll(Sort.by(Order.asc("name"), Order.desc("price")));
        products.forEach(System.out::println);
    }

    @Test
    void test_paging_and_sorting_in_action() {
        Pageable pageable = PageRequest.of(0, 2, Sort.by(Order.asc("name"), Order.desc("price")));
        Page<Product> products = repository.findAll(pageable);
        products.forEach(System.out::println);
    }

    @Test
    void test_paging_and_sorting_custom_finder_method() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by(Order.asc("name"), Order.desc("price")));
        List<Product> products = repository.findByIdIn(List.of(2, 3, 4, 5, 6, 7, 8, 9), pageable);
        products.forEach(System.out::println);
    }
}
