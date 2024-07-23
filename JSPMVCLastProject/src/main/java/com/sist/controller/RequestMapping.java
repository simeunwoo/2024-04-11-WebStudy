package com.sist.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) // Retention : 객체 저장 기간 => Runtime : 프로그램 종료 시까지 유지
@Target(METHOD) // Target : 구분자
/*
 * 	TYPE : 클래스 구분자
 * 	METHOD : 메소드 구분자
 * 	PARAMETER : 매개 변수 구분자
 * 	FIELD : 멤버 변수 / 멤버 객체 구분자
 * 
 * 	위치
 * 	@ => TYPE
 * 	public class ClassName
 * 	{
 * 		@ => FIELD
 * 		A a;
 * 
 * 		@ => METHOD
 * 		public void display()
 * 		{
 * 		}
 * 		public void setA((@ => PARAMETER) A a)
 * 		{
 * 		}
 * 	}
 * 
 * 	@RequestMapping("구분 내용")
 * 	=> 밑에 있는 메소드를 제어
 */
public @interface RequestMapping {

	public String value();
}
