package com.sist.dao;
import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.sist.vo.*;

public class CartDAO {

	private static SqlSessionFactory ssf;
	static
	{
		ssf=CreateSqlSessionFactory.getSsf();
	}
	
	/*
	<insert id="cartInsert">
		INSERT INTO project_cart VALUES(
		pc_cno_seq.nextval,#{gno},#{type},#{id},#{account},#{price},'n',SYSDATE
		)
	</insert>
	 */
	public static void cartInsert(CartVO vo)
	{
		SqlSession session=null;
		
		try {
			session = ssf.openSession(true);
			session.insert("cartInsert",vo);
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 1");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
	}
	
	public static List<CartVO> cartListData(String id)
	{
		List<CartVO> list=new ArrayList<CartVO>();
		SqlSession session=null;
		
		try{
			session = ssf.openSession();
			list=session.selectList("cartListData",id);
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 2");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	/*
	<select id="cartGetGnoCount" resultType="int" parameterType="hashmap">
		SELECT COUNT(*)
		FROM project_cart
		WHERE gno=#{gno} AND id=#{id}
	</select>
	<select id="cartGetGno" resultType="int" parameterType="hashmap">
		SELECT cno
		FROM project_cart
		WHERE gno=#{gno} AND id=#{id}
	</select>
	<update id="cartGnoUpdate" parameterType="hashmap">
		UPDATE project_cart SET
		account=account+#{account}
		WHERE cno=#{cno}
	</update>
	 */
	public static int cartGetGnoCount(Map map)
	{
		int count=0;
		SqlSession session=null;
		
		try{
			session = ssf.openSession();
			count=session.selectOne("cartGetGnoCount" , map);
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 3");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return count;
	}
	
	public static int cartGetGno(Map map)
	{
		int cno=0;
		SqlSession session=null;
		
		try{
			session = ssf.openSession();
			cno=session.selectOne("cartGetGno" , map);
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 4");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return cno;
	}

	public static void cartGnoUpdate(Map map)
	{
		SqlSession session=null;
		
		try{
			session = ssf.openSession(true);
			session.update("cartGnoUpdate");
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 5");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
	}
	
	public static void buyInsert(CartVO vo)
	{
		SqlSession session=null;
		
		try {
			session = ssf.openSession(true);
			session.insert("buyInsert",vo);
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 6");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
	}
	
	public static List<CartVO> buyListData(String id)
	{
		List<CartVO> list=new ArrayList<CartVO>();
		SqlSession session=null;
		
		try{
			session = ssf.openSession();
			list=session.selectList("buyListData",id);
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 7");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return list;
	}
	
	/*
	<select id="buyTotalPrice" resultType="int" parameterType="string">
		SELECT SUM(price)
		FROM project_cart
		WHERE id=#{id} AND isbuy='y'
	</select>
	 */
	public static int buyTotalPrice(String id)
	{
		int total=0;
		SqlSession session=null;
		
		try{
			session = ssf.openSession();
			total=session.selectOne("buyTotalPrice",id);
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 8");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
		
		return total;
	}
	
	/*
	<delete id="cartCancel" parameterType="int">
		DELETE FROM project_cart
		WHERE cno=#{cno}
	</delete>
	 */
	public static void cartCancel(int cno)
	{
		SqlSession session=null;
		
		try{
			session = ssf.openSession(true);
			session.delete("cartCancel",cno);
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 9");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
	}
	
	public static void cartBuyUpdate(int cno)
	{
		SqlSession session=null;
		
		try{
			session = ssf.openSession(true);
			session.update("cartBuyUpdate",cno);
		} catch (Exception ex) {
			System.out.println("CartDAO 오류 10");
			ex.printStackTrace();
		} finally {
			if(session!=null) session.close();
		}
	}
}
