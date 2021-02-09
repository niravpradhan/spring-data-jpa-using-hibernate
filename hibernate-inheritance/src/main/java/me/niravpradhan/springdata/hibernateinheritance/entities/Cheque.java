package me.niravpradhan.springdata.hibernateinheritance.entities;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@Entity
//@DiscriminatorValue("ch")
@Table(name = "bankcheck")
@PrimaryKeyJoinColumn(name = "id")
public class Cheque extends Payment {

    private String checknumber;
}
