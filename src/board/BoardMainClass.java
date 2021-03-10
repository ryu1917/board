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
			case 2:
				db.getMember();
				break;
			case 3:
				System.out.print("탈퇴 할 회원 ID를 입력 : ");
				String id = input.next();
				int result = db.deleteMember(id);
				if(result ==1) {
					System.out.println("성공적으로 삭제했습니다.");
				}else {
					System.out.println("삭제 중 문제가 발생했습니다.");
				}
			case 4:break;
			case 5:
				System.out.println("수정 할 글 번호 입력 : ");
				bo.setNum(input.nextInt());
				System.out.println("수정 할 글 제목 입력 : ");
				bo.setTitle(input.next());
				System.out.println("수정 할 작가 명 입력 : ");
				bo.setWriter(input.next());
				System.out.println("수정 할 내용 입력 : ");
				bo.setContent(input.next());
				
				int re = db.modifyBoard(bo);
				if(re ==1) {
					System.out.println("성공적으로 수정했습니다.");
				}else {
					System.out.println("수정 중 문제가 발생했습니다.");
				}
				
				break;
			case 6:break;
			
			}
			
		}
		
	}
}
