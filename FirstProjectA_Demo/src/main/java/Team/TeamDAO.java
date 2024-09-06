package Team;
import java.util.*;
import java.sql.*;
public class TeamDAO {
   private Connection conn;
   private PreparedStatement ps;
   private static TeamDAO dao;
   private final String URL="jdbc:oracle:thin:@211.238.142.124:1521:XE";
   
   // 드라이버 등록 
   public TeamDAO()
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
   public static TeamDAO newInstance()
   {
	   if(dao==null)
		   dao=new TeamDAO();
	   return dao;
   }
   // 기능 
   
   public void teamInsert(TeamVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO team(no,team,game,win,draw,lose,cha,winper) "
					     +"VALUES(team_no_seq.nextval,?,?,?,?,?,?,?)";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, vo.getNo());
		   ps.setString(2, vo.getTeam());
		   ps.setInt(3, vo.getGame());
		   ps.setInt(4, vo.getWin());
		   ps.setInt(5, vo.getDraw());
		   ps.setInt(6, vo.getLose());
		   ps.setDouble(7, vo.getCha());
		   ps.setDouble(8, vo.getWinper());
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





