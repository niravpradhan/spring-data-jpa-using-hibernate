package me.niravpradhan.springdata.idgenerators;

import me.niravpradhan.springdata.idgenerators.entities.Employee;
import me.niravpradhan.springdata.idgenerators.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IdGeneratorsApplicationTests {

    @Autowired
    EmployeeRepository repository;

    @Test
    void testCreateEmployee() {
        Employee emp = new Employee();
        emp.setName("John");
        repository.save(emp);
    }
}
