package com.Youtube.Dto;

import lombok.Data;

import java.util.List;

//Bu biz client icin disarda icin kullinyoruz yani person ve addressin client'e bagli nesneler
@Data //Bu ise getter setter ver degir metotlari ulusturuyor....
public class PersonDto  {
    private Long id;
    private String name;
    private String surname;
    private List<String> address;

}
