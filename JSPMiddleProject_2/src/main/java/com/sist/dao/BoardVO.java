package com.sist.dao;
import java.util.*;

import lombok.Data;
// 데이터를 묶어서 한번에 브라우저로 전송하는 목적
// => JSP(Bean), MyBatis(DTO), Spring(VO)
// => 데이터 보호 : 자바(캡슐화) => 데이터는 메모리에 저장 => 읽기/쓰기 => 메소드 호출
// => 시큐어 코딩 => Lombok
/*
 NO                                        NOT NULL NUMBER
 NAME                                      NOT NULL VARCHAR2(51)
 SUBJECT                                   NOT NULL VARCHAR2(4000)
 CONTENT                                   NOT NULL CLOB
 PWD                                       NOT NULL VARCHAR2(10)
 REGDATE                                            DATE
 HIT                                                NUMBER
*/
// 공공포털 / 실시간 크롤링 외에는 모든 데이터를 오라클
/*
 * 	IT
 * 	끈기
 * 	역량 => 제작(자신감)
 */
@Data
public class BoardVO {
	private int no,hit;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
}
