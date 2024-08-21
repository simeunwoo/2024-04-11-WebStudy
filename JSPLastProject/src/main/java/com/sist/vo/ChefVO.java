package com.sist.vo;

import lombok.Data;

/*
CHEF      NOT NULL VARCHAR2(100) 
POSTER             VARCHAR2(500) 
MEM_contT1          VARCHAR2(100) 
MEM_contT3          VARCHAR2(100) 
MEM_contT7          VARCHAR2(100) 
MEM_contT2          VARCHAR2(100) 
 */
@Data
public class ChefVO {

	private String chef,poster,mem_cont1,mem_cont3,mem_cont7,mem_cont2;
}
