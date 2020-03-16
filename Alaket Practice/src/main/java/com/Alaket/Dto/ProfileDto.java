package com.Alaket.Dto;

import lombok.Data;

import java.sql.Date;

@Data
public class ProfileDto {
    private Long id;
    private String name;
    private String last_name;
    private String email;
    private String contact;
    private Date birth_date;
    private Date last_login;
    private Date data_join;
    private String inn;
    private String passport;
    private Boolean is_superuser = false;
    private Boolean is_courier = false;
    private Boolean is_reciever = false;
    private Boolean is_customer = false;
    private Boolean is_active = false;

}
