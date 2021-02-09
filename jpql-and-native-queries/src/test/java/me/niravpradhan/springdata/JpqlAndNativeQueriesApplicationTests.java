package me.niravpradhan.springdata;

import me.niravpradhan.springdata.entities.Student;
import me.niravpradhan.springdata.repos.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class JpqlAndNativeQueriesApplicationTests {

    @Autowired
    StudentRepository repository;

    @Test
    void test_create_students() {
        Student student1 = new Student();
        student1.setFirstName("John");
        student1.setLastName("Ferguson");
        student1.setScore(88);

        Student student2 = new Student();
        student2.setFirstName("Bill");
        student2.setLastName("Gates");
        student2.setScore(75);

        Student student3 = new Student();
        student3.setFirstName("James");
        student3.setLastName("Gosling");
        student3.setScore(100);

        repository.save(student1);
        repository.save(student2);
        repository.save(student3);
    }

    @Test
    void test_findAllStudents() {
        List<Student> students = repository.findAllStudents();
        students.forEach(System.out::println);
    }

    @Test
    void test_partial_student_data() {
        List<Object[]> partialData = repository.findAllFirstNameAndLastName();
        partialData.forEach(arr -> System.out.println(arr[0] + ", " + arr[1]));
    }

    @Test
    void test_using_named_query_parameters() {
        List<Student> result = repository.findAllStudentsByFirstName("Bill");
        result.forEach(System.out::println);
    }

    @Test
    void test_find_by_students_scores() {
        List<Student> students = repository.findAllStudentsByScoreBetween(70, 80);
        students.forEach(System.out::println);
    }

    @Test
    @Transactional
    @Rollback(false)
    void test_deleteStudentsByFirstName() {
        repository.deleteStudentsByFirstName("James");
    }

    @Test
    @Transactional
    @Rollback(false)
    void test_deleteAllByFirstName() {
        repository.deleteAllByFirstName("James");
    }

    @Test
    void test_findAllStudents_paging() {
        Pageable pageable = PageRequest.of(0, 5, Sort.by(Order.asc("firstName")));
        List<Student> students = repository.findAllStudents(pageable);
        students.forEach(System.out::println);
    }

    @Test
    void test_findAllStudentsNQ() {
        List<Student> students = repository.findAllStudentsNQ();
        students.forEach(System.out::println);
    }

    @Test
    void test_findAllByFirstNameNQ() {
        List<Student> students = repository.findAllByFirstNameNQ("James");
        students.forEach(System.out::println);
    }
}
