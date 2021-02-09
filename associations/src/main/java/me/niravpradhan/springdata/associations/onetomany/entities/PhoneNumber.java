package me.niravpradhan.springdata.associations.onetomany.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone_number")
@Data
@EqualsAndHashCode(exclude = {"customer"})
@ToString(exclude = {"customer"})
public class PhoneNumber implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String type;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
