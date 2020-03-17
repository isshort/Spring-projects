package com.Youtube;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "My_Pet_Model",description = "Pet model contains the properties about any pet")
public class Pet  {

    @ApiModelProperty(value = "incremented id of Pet's field")
    private int id;

    @ApiModelProperty(value = "Name of Pet's field")
    private String name;

    @ApiModelProperty(value = "Created data of Pet's field")
    private Date date;
}
