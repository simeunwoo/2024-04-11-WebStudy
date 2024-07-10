package com.sist.bean;

import lombok.Data;
// VO, DTO, Bean => 같은 개념
// Spring에서 VO == MyBatis에서 DTO == JSP에서 bean
// => 데이터를 모아서 한번에 전송할 목적
// 변수를 제어 => 읽기(getter) / 쓰기(setter)
// => 데이터 해킹 방지 => 숨겨서 보내준다 => 캡슐화 => 데이터 보호 목적
// VO : Value Object / DTO : Data Transfor Object
@Data
public class MemberVO {
	private String name,sex,address,phone;
}
