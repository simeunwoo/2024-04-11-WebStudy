package com.sist.dao;
import java.util.*;

import com.sist.database.DataBaseConnection;

import java.sql.*;
/*
 * 	클래스의 종류 (역할) => 클래스는 한개의 기능을 수행 => 컴포넌트
 * 
 * 	VO => 데이터를 모아서 한번에 브라우저 / 모바일로 전송
 * 	DAO => 데이터베이스 연동
 * 	Manager => 관리 => 데이터 수집 / Open API
 * 	Service => 사용자 요청에 대한 처리
 * 	Model(Controller) => 사용자 요청을 받아서 => 결과를 전송
 * 	================= MVC (Spring MVC)
 */
/*             JSP 프로젝트   Spring 프로젝트  Spring-Boot => 개인 프로젝트
 * 	JDBC =====> DBCP =====> ORM =====> DataSet - 자동 SQL 문장을 만들어 준다 (JPA)
 * 	  |           |          |
 * 	 기본        연결 속도      라이브러리 (데이터베이스만 연결)
 *           Connection 관리   MyBatis
 *  
 *  자격 요건 : Spring 가능자, JQuery | Vue | React, MySQL, Spring-Boot, AWS
 *           ===========
 *           Java + JSP + Oracle => Full Stack
 */
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static FoodDAO dao;
	private DataBaseConnection dbConn=new DataBaseConnection();
}
