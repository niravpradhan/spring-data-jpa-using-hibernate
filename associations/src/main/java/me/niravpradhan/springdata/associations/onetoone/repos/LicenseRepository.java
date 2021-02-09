package me.niravpradhan.springdata.associations.onetoone.repos;

import me.niravpradhan.springdata.associations.onetoone.entiities.License;
import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Integer> {
}
