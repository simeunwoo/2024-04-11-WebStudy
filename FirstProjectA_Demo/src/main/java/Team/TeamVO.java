package Team;
/*
NO     NOT NULL NUMBER       
TEAM   NOT NULL VARCHAR2(20) 
GAME            NUMBER       
WIN             NUMBER       
DRAW            NUMBER       
LOSE            NUMBER       
CHA             NUMBER(3,1)  
WINPER          NUMBER(4,3)
 */
import lombok.Data;

@Data
public class TeamVO {

	private int no,game,win,draw,lose;
	private double cha,winper;
	private String team;
}