package com.Alaket.Entity;



import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


import javax.persistence.*;

import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "Profile")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
@EnableAutoConfiguration
public class Profile implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_profile",allocationSize = 1)
    @GeneratedValue(generator = "seq_profile",strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 75,name = "name")
    private String name;

    @Column(length = 75,name = "last_name")
    private String last_name;

    @Column(length = 100,name = "email")
    private String email;
    @Column(length = 15,name = "contact")
    private String contact;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date")
    private Date birth_date;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "last_login")
    private Date last_login;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_join")
    private Date data_join;


    @Column(length = 20,name = "inn")
    private String inn;
    @Column(length = 20,name = "passport")
    private String passport;

    @Column(name = "is_superuser")
    private Boolean is_superuser = false;

    @Column(name = "is_courier")
    private Boolean is_courier = false;
    @Column(name = "is_reciever")
    private Boolean is_reciever = false;
    @Column(name = "is_customer")
    private Boolean is_customer = false;

    @Column(name = "is_active")
    private Boolean is_active = false;


}
