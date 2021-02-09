package me.niravpradhan.springdata.associations.manytomany.repos;

import me.niravpradhan.springdata.associations.manytomany.entities.Programmer;
import org.springframework.data.repository.CrudRepository;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {
}
