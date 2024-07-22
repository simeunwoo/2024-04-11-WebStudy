package com.sist.model;

import javax.servlet.http.HttpServletRequest;
// 처리하는 기능이 비슷한 경우 => 클래스를 통합 => 인터페이스 (배열 느낌)
// => 조건문(if ~ else if) 없이 찾을 수 있다
public interface Model {

	public String execute(HttpServletRequest request);
}
