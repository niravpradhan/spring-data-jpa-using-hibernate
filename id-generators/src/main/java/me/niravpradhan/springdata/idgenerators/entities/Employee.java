package me.niravpradhan.springdata.idgenerators.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "emp_id_gen", strategy = "me.niravpradhan.springdata.idgenerators.entities.RandomIDGeneerator")
    @GeneratedValue(generator = "emp_id_gen")
    //@TableGenerator(name = "employee_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val",
    //        allocationSize = 1)
    //@GeneratedValue(strategy = GenerationType.TABLE, generator = "employee_gen")
    private Long id;

    private String name;
}
