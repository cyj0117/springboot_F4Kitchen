package com.aaa.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
@Data
public class Type implements Serializable {
    @Id
    private Integer tid;
    private String tname;
}
