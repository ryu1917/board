package board;

import java.util.Scanner;

import member.MemberVO;

public class BoardMainClass {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		DBClass db=new DBClass();
		MemberVO m=new MemberVO();
		BoardVO bo=new BoardVO();
		while(true) {
			int sel=input.nextInt();
			switch(sel) {
			case 1:break;
			case 2:
				
				db.getMember();
			
				
				
				break;
			case 3:break;
			case 4:break;
			case 5:break;
			case 6:break;
			
			}
			
		}
		
	}
}
