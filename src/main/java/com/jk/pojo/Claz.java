package com.jk.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * JK
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Claz {
    private Integer id;
    private String clazname;
    private Date create_time;
}
