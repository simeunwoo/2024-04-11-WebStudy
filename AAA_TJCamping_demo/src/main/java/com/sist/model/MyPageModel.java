package com.sist.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.sist.commons.CommonsModel;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.*;

public class MyPageModel {
	@RequestMapping("mypage/mypage_main.do")
	public String mypage_main(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("title", "마이페이지 홈");
		request.setAttribute("mypage_jsp", "../mypage/mypage_home.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		// CommonsModel.footerPrint(request);
		return "../main/main.jsp";
	}

	@RequestMapping("member/join_update.do")
	public String mypage_join_update(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		MemberVO vo = MemberDAO.memberUpdateData(id);

		String phone = vo.getPhone();
		phone = phone.substring(phone.indexOf(")") + 1);
		vo.setPhone(phone);
		request.setAttribute("vo", vo);
		request.setAttribute("title", "회원 수정");
		request.setAttribute("mypage_jsp", "../member/join_update.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		// CommonsModel.footerPrint(request);
		return "../main/main.jsp";
	}

	@RequestMapping("member/join_update_ok.do")
	public String mypage_join_update_ok(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (Exception ex) {
		}
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birth = request.getParameter("birth");
		String post = request.getParameter("post");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String email = request.getParameter("email");
		String content = request.getParameter("content");
		String phone1 = request.getParameter("phone1");
		String phone2 = request.getParameter("phone2");

		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pwd);
		vo.setName(name);
		vo.setSex(sex);
		vo.setEmail(email);
		vo.setBirth(birth);
		vo.setPost(post);
		vo.setAddr1(addr1);
		vo.setAddr2(addr2);
		vo.setContent(content);
		vo.setPhone(phone1 + ")" + phone2);

		boolean bCheck = MemberDAO.memberUpdate(vo);
		request.setAttribute("result", bCheck);
		return "../member/join_update_ok.jsp";
	}

	@RequestMapping("mypage/mypage_jjim.do")
	public String mypage_jjim(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		request.setAttribute("title", "찜 목록");
		request.setAttribute("mypage_jsp", "../mypage/mypage_jjim.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		System.out.println(id);
		return "../main/main.jsp";
	}

	@RequestMapping("mypage/fbjjim_list.do")
	public String food_jjim(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		List<FoodVO> fblist = AllJjimDAO.fbjjimListData(id);
		request.setAttribute("title", "맛집찜");
		request.setAttribute("fbList", fblist);
		request.setAttribute("jjim_jsp", "../mypage/my_fbjjim.jsp");
		request.setAttribute("mypage_jsp", "../mypage/mypage_jjim.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("mypage/cgjjim_list.do")
	public String camp_goods_jjim(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		List<CampGoodsVO> cglist = AllJjimDAO.cgjjimListData(id);
		request.setAttribute("title", "캠핑용품");
		request.setAttribute("cgList", cglist);
		request.setAttribute("jjim_jsp", "../mypage/my_cgjjim.jsp");
		request.setAttribute("mypage_jsp", "../mypage/mypage_jjim.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("mypage/recjjim_list.do")
	public String recipe_jjim(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		List<RecipeVO> reclist = AllJjimDAO.recjjimListData(id);
		request.setAttribute("title", "레시피");
		request.setAttribute("recList", reclist);
		request.setAttribute("jjim_jsp", "../mypage/my_recjjim.jsp");
		request.setAttribute("mypage_jsp", "../mypage/mypage_jjim.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("mypage/alljjim_list.do")
	public String all_jjim(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		List<RecipeVO> reclist = AllJjimDAO.recjjimListData(id);
		List<CampGoodsVO> cglist = AllJjimDAO.cgjjimListData(id);
		List<FoodVO> fblist = AllJjimDAO.fbjjimListData(id);
		request.setAttribute("title", "전체");
		request.setAttribute("recList", reclist);
		request.setAttribute("cgList", cglist);
		request.setAttribute("fbList", fblist);
		request.setAttribute("jjim_jsp", "../mypage/my_alljjim.jsp");
		request.setAttribute("mypage_jsp", "../mypage/mypage_jjim.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		return "../main/main.jsp";
	}
	
	@RequestMapping("member/camp_jjim_delete.do")
	public String camp_jjim_delete(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		String no = request.getParameter("cno");
		String jtype = request.getParameter("type");
		int cno = Integer.parseInt(no);
		int type = Integer.parseInt(jtype);
		System.out.println(cno);
		System.out.println(type);
		
		Map map = new HashMap();
		map.put("cno", cno);
		map.put("id", id);
		map.put("type", type);
		try {
			AllJjimDAO.camp_jjim_delete(map);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "redirect:../mypage/alljjim_list.do";
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@RequestMapping("mypage/mypage_buy.do")
	public String mypage_buy(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		request.setAttribute("title", "구매 목록");
		request.setAttribute("mypage_jsp", "../mypage/mypage_buyList.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		System.out.println(id);
		return "../main/main.jsp";
	}
	
	@RequestMapping("mypage/mypage_buyList.do")
	public String mypage_buyList(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		//int cno=(int) request.getAttribute("cno");
		String id = (String) session.getAttribute("id");
		System.out.println("saddsa");
		List<CartVO> glist = CartDAO.goodsBuyList(id);
		int gtotal = CartDAO.goodsBuytotal(id);
		int ctotal= CartDAO.campBuytotal(id);
		System.out.println(ctotal);
		List<CartVO> clist = CartDAO.campBuyList(id);
		//System.out.println(cno+"s");
		//request.setAttribute("cno", cno);
		request.setAttribute("ctotal", ctotal);
		request.setAttribute("gtotal", gtotal);
		request.setAttribute("glist", glist);
		request.setAttribute("clist", clist);
		request.setAttribute("mypage_jsp", "../mypage/mypage_buyList.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		return "../main/main.jsp";
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("mypage/mypage_reserve.do")
	public String mypage_reserve(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		List<ReserveVO> rList = ReserveDAO.campReserveMyPageData(id);
		
		request.setAttribute("rList", rList);
		request.setAttribute("mypage_jsp", "../mypage/mypage_reserve.jsp");
		request.setAttribute("main_jsp", "../mypage/mypage_main.jsp");
		return "../main/main.jsp";
	}
	@RequestMapping("mypage/mypage_reserve_cancel.do")
	public String mypage_reserve_cancel(HttpServletRequest request,HttpServletResponse response)
	  {
		  String rno=request.getParameter("rno");
		  // 데이터베이스 연동 => 삭제 
		  ReserveDAO.reserveCancel(Integer.parseInt(rno));
		  return "redirect:../mypage/mypage_reserve.do";
	  }
}