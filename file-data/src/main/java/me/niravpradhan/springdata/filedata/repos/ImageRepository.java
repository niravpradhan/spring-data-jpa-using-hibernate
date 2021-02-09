package me.niravpradhan.springdata.filedata.repos;

import me.niravpradhan.springdata.filedata.entities.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
