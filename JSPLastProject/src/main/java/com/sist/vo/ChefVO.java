package com.sist.vo;

import lombok.Data;

/*
CHEF      NOT NULL VARCHAR2(100) 
POSTER             VARCHAR2(500) 
MEM_CONT1          VARCHAR2(100) 
MEM_CONT3          VARCHAR2(100) 
MEM_CONT7          VARCHAR2(100) 
MEM_CONT2          VARCHAR2(100) 
 */
@Data
public class ChefVO {

	private String chef,poster,men_con1,men_con3,men_con7,men_con2;
}
