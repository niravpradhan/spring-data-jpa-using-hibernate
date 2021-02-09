package me.niravpradhan.springdata.componentmappings.repos;

import me.niravpradhan.springdata.componentmappings.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
