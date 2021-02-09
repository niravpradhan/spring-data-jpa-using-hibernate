package me.niravpradhan.springdata.transactionmanagement.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "bankaccount")
@Data
public class BankAccount implements Serializable {

    @Id
    private int accno;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "bal")
    private int balance;
}
