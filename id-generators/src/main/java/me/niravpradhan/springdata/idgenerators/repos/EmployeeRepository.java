package me.niravpradhan.springdata.idgenerators.repos;

import me.niravpradhan.springdata.idgenerators.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
