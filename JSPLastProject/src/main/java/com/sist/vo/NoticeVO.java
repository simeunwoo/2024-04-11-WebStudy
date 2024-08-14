package com.sist.vo;

import java.util.Date;

import lombok.Data;

/*
NO      NOT NULL NUMBER         
TYPE             NUMBER         
NAME             VARCHAR2(50)   
SUBJECT          VARCHAR2(2000) 
CONTENT          CLOB           
REGDATE          DATE           
HIT              NUMBER 
 */
@Data
public class NoticeVO {

	private int no,type,hit;
	private String name,subject,content,dbday;
	private Date regdate;
	
	private String notice_type;
}
