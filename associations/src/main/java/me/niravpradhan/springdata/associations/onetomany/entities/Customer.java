package me.niravpradhan.springdata.associations.onetomany.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(exclude = {"phoneNumbers"})
@ToString(exclude = {"phoneNumbers"})
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<PhoneNumber> phoneNumbers;

    public void addPhoneNumber(PhoneNumber phoneNumber) {
        if (phoneNumber != null) {
            if (phoneNumbers == null) {
                phoneNumbers = new HashSet<>();
            }
            phoneNumber.setCustomer(this);
            phoneNumbers.add(phoneNumber);
        }
    }
}
