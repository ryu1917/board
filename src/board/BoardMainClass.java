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
			case 1:
				System.out.print("ID 입력 : ");
				m.setId(input.next());
				System.out.print("PW 입력 : ");
				m.setPw(input.next());
				System.out.print("이름 입력 : ");
				m.setName(input.next());
				System.out.print("나이 입력 : ");
				m.setAge(input.nextInt());
				db.insertMember(m);
				break;
			case 2:break;
			case 3:break;
			case 4:break;
			case 5:break;
			case 6:break;
			
			}
			
		}
		
	}
}
