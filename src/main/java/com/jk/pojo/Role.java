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
public class Role {
    private Integer id;
    private String rolename;
    private Date create_time;
}
