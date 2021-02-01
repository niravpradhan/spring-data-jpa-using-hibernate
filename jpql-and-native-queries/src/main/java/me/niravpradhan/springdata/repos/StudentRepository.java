package me.niravpradhan.springdata.repos;

import me.niravpradhan.springdata.entities.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("from Student")
    List<Student> findAllStudents();

    @Query("select st.firstName, st.lastName from Student st")
    List<Object[]> findAllFirstNameAndLastName();

    @Query("from Student where firstName = :firstName")
    List<Student> findAllStudentsByFirstName(@Param("firstName") String firstName);

    @Query("from Student where score >= :min and score <= :max")
    List<Student> findAllStudentsByScoreBetween(@Param("min") int min, @Param("max") int max);

    @Modifying
    @Query("delete from Student where firstName = :firstName")
    void deleteStudentsByFirstName(@Param("firstName") String firstName);

    void deleteAllByFirstName(String firstName);
}
