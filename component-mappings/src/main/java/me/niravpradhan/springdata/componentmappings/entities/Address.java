package me.niravpradhan.springdata.componentmappings.entities;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;

    private String streetaddress;
    private String city;
    private String state;
    private String zipcode;
    private String country;
}
