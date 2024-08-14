package b;
import java.util.*;
import java.sql.*;
public class CampImageDAO {
   private Connection conn;
   private PreparedStatement ps;
   private static CampImageDAO dao;
   private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
   
   // 드라이버 등록 
   public CampImageDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex) {}
   }
   
   // 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr2","happy");
	   }catch(Exception ex) {}
   }
   // 해제 
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // 싱글턴
   public static CampImageDAO newInstance()
   {
	   if(dao==null)
		   dao=new CampImageDAO();
	   return dao;
   }
   // 기능 
   /*
 CAMP_NO                                   NOT NULL NUMBER
 CAMP_PRICE                                NOT NULL NUMBER
 CAMP_NAME                                 NOT NULL VARCHAR2(51)
 CAMP_ADDR                                          VARCHAR2(200)
 CAMP_PHONE                                         VARCHAR2(20)
 CAMP_CONTENT                                       CLOB
 CAMP_IMAGE                                         VARCHAR2(4000)
 CAMP_WIFI                                          VARCHAR2(30)
 CAMP_STORE                                         VARCHAR2(30)
 CAMP_ANIMAL                                        VARCHAR2(30)    
    */
   public void campInsert(CampImageVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO image_camp(no,image1,image2,image3,image4,image5,image6,image7,image8,image9,image10,"
		   		+ "image1s,image2s,image3s,image4s,image5s,image6s,image7s,image8s,image9s,image10s) "
				     +"VALUES(no_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, vo.getImage1());
		   ps.setString(2, vo.getImage2());
		   ps.setString(3, vo.getImage3());
		   ps.setString(4, vo.getImage4());
		   ps.setString(5, vo.getImage5());
		   ps.setString(6, vo.getImage6());
		   ps.setString(7, vo.getImage7());
		   ps.setString(8, vo.getImage8());
		   ps.setString(9, vo.getImage9());
		   ps.setString(10, vo.getImage10());
		   ps.setString(11, vo.getImage1s());
		   ps.setString(12, vo.getImage2s());
		   ps.setString(13, vo.getImage3s());
		   ps.setString(14, vo.getImage4s());
		   ps.setString(15, vo.getImage5s());
		   ps.setString(16, vo.getImage6s());
		   ps.setString(17, vo.getImage7s());
		   ps.setString(18, vo.getImage8s());
		   ps.setString(19, vo.getImage9s());
		   ps.setString(20, vo.getImage10s());
		   
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
}





