package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;
// Model => 사용자 요청 정보를 받아서 요청 처리 => 결과값을 브라우저로 전송
public class SeoulModel {

	@RequestMapping("seoul/location.do")
	// _ok => redirect / ajax => void (화면 변경이 없다)
	public String seoul_location(HttpServletRequest request,HttpServletResponse response)
	{
		// 1) 사용자 요청 받기 => getParameter(), getParameterValues()
		// 2) 요청 처리 => 데이터베이스 연동 => 메소드 호출
		// 3) 결과값을 브라우저로 전송 => setAttribute()
		
		// 4) 어떤 화면을 출력할 지 설정
		request.setAttribute("main_jsp", "../seoul/location.jsp");
		return "../main/main.jsp";
	}
}
