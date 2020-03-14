package com.Youtube.Entity;

import lombok.*;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "Person")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})// if two id is equal to each other we can write for one
@ToString // to generate To String method
public class Person {

    @Id
    @SequenceGenerator(name = "seq_person", allocationSize = 1)
    @GeneratedValue(generator = "seq_person", strategy = GenerationType.SEQUENCE)// in mysql auto_increment
    private Long id;

    @Column(length = 100, name = "name")
    private String name;

    @Column(length = 100, name = "surname")
    private String surname;

    @OneToMany
    @JoinColumn(name = "person_address_id")
    private List<Address> addressList;



}
