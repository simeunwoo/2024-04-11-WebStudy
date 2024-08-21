package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
CNO     NOT NULL NUMBER       
GNO              NUMBER       
TYPE             NUMBER       
ID               VARCHAR2(20) 
ACCOUNT          NUMBER       
PRICE            NUMBER       
ISBUY            CHAR(1)      
REGDATE          DATE   
 */
@Data
public class CartVO {

	private int cno,gno,type,account,price;
	private String id,isbuy,dbday;
	private Date regdate;
}
