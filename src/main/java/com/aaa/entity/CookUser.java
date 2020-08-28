package com.aaa.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class CookUser implements Serializable {

    private Integer cuid;

    private Integer ccuid;

    private Integer ucuid;
}
