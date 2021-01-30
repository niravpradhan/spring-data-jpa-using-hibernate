package me.niravpradhan.springdata;

import me.niravpradhan.springdata.entities.Product;
import me.niravpradhan.springdata.repos.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
class ProductdataApplicationTests {

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
}

