package com.sist.vo;
import java.util.*;
/*
 * 	1. 목록 => 페이징
 * 	2. 상세 보기
 * 	3. CRUD => 게시판
 * 	=============== 신입 사원 요구 사항
 * 	4. 파일 업로드
 * 
 * 	MVC / Spring => 혼자 짤 수 있다면 => 7개월동안 선방
 * 	=> JSON => Ajax / Vue / React => " 매우 선방
 * 	=> AWS : 호스팅 => " 매우 잘함
 */
import lombok.Data;

@Data
public class BoardVO {
	private int no,hit;
	private String name,subject,content,pwd,dbday;
	private Date regdate;
	private int rownum;
}
