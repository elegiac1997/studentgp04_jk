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
public class Perm {
    private Integer id;
    private String perm;
    private Date create_time;
}
