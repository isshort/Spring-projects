package com.Youtube.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Person_Address")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})// if two id is equal to each other we can write for one
@ToString // to generate To String method
public class Address implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_person_address", allocationSize = 1)
    @GeneratedValue(generator = "seq_person_address", strategy = GenerationType.SEQUENCE)// in mysql auto_increment
    private Long id;

    @Column(length = 500, name = "address")
    private String address;

    @Enumerated
    private AddressType addressType;

    @Column(name = "active")
    private Boolean active;

    @ManyToOne
    @JoinColumn(name="person_address_id")
    private Person person;

    public enum AddressType {
        Home_Address,
        Work_Address,
        Other,
    }
}
