package me.niravpradhan.springdata.filedata;

import me.niravpradhan.springdata.filedata.entities.Image;
import me.niravpradhan.springdata.filedata.repos.ImageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@SpringBootTest
class FileDataApplicationTests {

    @Autowired
    ImageRepository repository;

    @Test
    void readFile() throws IOException {

        byte[] data = Files.readAllBytes(Path.of("my_logo.PNG"));
        System.out.printf("Length: %d%n", data.length);
    }

    @Test
    void test_saveImage() throws IOException {
        Image image = new Image();
        image.setId(1L);
        image.setName("my_logo.PNG");

        byte[] data = Files.readAllBytes(Path.of("my_logo.PNG"));
        image.setData(data);

        repository.save(image);
    }

    @Test
    void test_readImage() throws IOException {
        Image image = repository.findById(1L).get();

        Files.write(Path.of("downloaded/" + image.getName()), image.getData(), StandardOpenOption.CREATE_NEW);
    }

}
