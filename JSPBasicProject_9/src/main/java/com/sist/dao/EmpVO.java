package com.sist.dao;
import java.util.*;

import lombok.Data;

@Data
public class EmpVO {
	private int empno,deptno,sal,comm,mgr;
	private String ename,job;
	private Date hiredate;
}
