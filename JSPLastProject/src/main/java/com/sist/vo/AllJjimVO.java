package com.sist.vo;
import java.util.*;

import lombok.Data;
/*
JNO     NOT NULL NUMBER       
CNO              NUMBER       
TYPE             NUMBER       
ID               VARCHAR2(20) 
REGDATE          DATE   
 */
@Data
public class AllJjimVO {
	
	private int jno,cno,type;
	private String id,dbday;
	private Date regdate;
}
