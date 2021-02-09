package me.niravpradhan.springdata;

import me.niravpradhan.springdata.entities.Product;
import me.niravpradhan.springdata.repos.ProductRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class ProductdataApplicationTests {

    @Autowired
    ProductRepository repository;

    @Autowired
    EntityManager entityManager;

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
    @Transactional
    void test_level1_caching() {
        repository.findById(2);
        repository.findById(2);
    }

    @Test
    @Transactional
    void test_caching() {
        Session session = entityManager.unwrap(Session.class);
        Product product = repository.findById(2).get();

        repository.findById(2);

        session.evict(product);

        repository.findById(2);
    }
}

