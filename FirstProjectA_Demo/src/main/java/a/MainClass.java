package a;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;
/*
 *    <div class="a">  .a img
 *      <div class="b">
 *        <h1>Hello</h1>
 *        <img src="">
 *        <a href="">
 *      </div>
 *      <div class="c">
 *        <h1>Hello</h1>
 *        <img src="">
 *        <a href="">
 *      </div>
 *    </div>
 *    <div class="d">
 *      <div class="b">
 *        <h1>Hello</h1>
 *        <img src="">
 *        <a href="">
 *      </div>
 *      <div class="c">
 *        <h1>Hello</h1>
 *        <img src="">
 *        <a href="">
 *      </div>
 *    </div>
 *      
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MainClass mc=new MainClass();
        mc.campData();
	}
	public void campData()
	{
		CampDAO dao=CampDAO.newInstance();
		try
		{
			int k=1;
			for(int i=1;i<=200;i++)
			{
				Document doc=Jsoup.connect("https://www.5gcamp.com/?c=camp&p="+i).get();
			//	Elements link=doc.select("ul.list p.listName a");
				Elements link=doc.select("div.contright div.subject a");
				for(int j=0;j<link.size();j++)
				{
				   try
				   {
					System.out.println(link.get(j).attr("href"));
					System.out.println("번호:"+ k++);
					String url="http://www.5gcamp.com"+link.get(j).attr("href");// 링크
					// 상세보기로 이동 
					// <li class="aa bb cc dd">
					Document doc2=Jsoup.connect(url).get();
					
				//	Element camp_price=doc2.selectFirst("h4.chead price f17 td.td3");
				//	System.out.println(camp_price.attr("src"));
					Element camp_name=doc2.selectFirst("div#contents div#campcontents div.viewheader h3.camp_subject");
					System.out.println(camp_name.text());
					
					
					Element camp_addr=doc2.selectFirst("div.tse-scroll-content div.tse-content div.content h4.chead a.clipboardCopy");
					System.out.println(camp_addr.text());
					Element camp_phone=doc2.selectFirst("div.tse-scroll-content div#camping_view div#vContent h4.chead_tel_fblack");
					System.out.println(camp_phone.text());
					Elements phoneElements = doc.select("h4:matches(\\d{3}-\\d{4}-\\d{4})");

		            for (Element phoneElement : phoneElements) {
		                String phoneNumber = phoneElement.text();
		                System.out.println("전화번호: " + phoneNumber);
				/*	Element address=doc2.selectFirst("div.areaBasic dd.add1");
					System.out.println(address.text());
					Element score=doc2.selectFirst("div.areaBasic span.total");
					System.out.println(score.text());
					Element theme=doc2.selectFirst("div.areaBasic dd.Theme");
					System.out.println(theme.text());
					
					Element content=doc2.selectFirst("div.article div#info_ps_f");
					System.out.println(content.text()); */
					System.out.println("==============================================");
					CampVO vo=new CampVO();
					//vo.setCamp_price(camp_price.text());
					vo.setCamp_name(camp_name.text());
					vo.setCamp_addr(camp_addr.text());
					vo.setCamp_phone(camp_phone.text());
				/*	vo.setTheme(theme.text());
					vo.setPoster(poster.attr("src"));
					vo.setContent(content.text());
					vo.setScore(Double.parseDouble(score.text())); */
					dao.campInsert(vo);
				   }catch(Exception ex) {}
				}
			}
			System.out.println("저장 완료!!");
		}catch(Exception ex) {}
	}

}