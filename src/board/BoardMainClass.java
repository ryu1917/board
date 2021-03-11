package board;

import java.util.Scanner;

import member.MemberVO;



public class BoardMainClass {
	
	public static void main(String[] args) {
		//로그인 정보
		MemberVO loginData = new MemberVO();
		boolean isLogin = false;
		
		Scanner input = new Scanner(System.in);
		IBoardService service = new BoardService();
		while(true) {
			if(!isLogin) {
				System.out.println("1.로그인 2.회원가입 3.프로그램 종료");
				switch(input.nextInt()) {
				case 1:
					MemberVO login = new MemberVO();
					System.out.print("아이디 : ");
					login.setId(input.next());
					System.out.print("비밀번호 : ");
					login.setPw(input.next());
					isLogin = service.login(login);
					if(isLogin) {
						loginData = service.getInfo(login);
						System.out.println(loginData.getId()+" 님 환영합니다!");
					}else {
						System.out.println("아이디 또는 비밀번호가 다릅니다.");
					}
					break;
				case 2:
					MemberVO regi = new MemberVO();
					System.out.print("ID 입력 : ");
					String id = input.next();
					//ID 중복 확인
					if(!service.overlap(id)) {
						regi.setId(id);
						System.out.print("PW 입력 : ");
						regi.setPw(input.next());
						System.out.print("이름 입력 : ");
						regi.setName(input.next());
						System.out.print("나이 입력 : ");
						regi.setAge(input.nextInt());
						service.register(regi);
						System.out.println(id +"님의 가입을 환영합니다!");
					}else {
						System.out.println("이미 존재하는 ID 입니다.");
					}
					break;
				default:
					System.out.println("프로그램 종료");
					return;
				}
			}else {
				System.out.println("1.글목록 2.글작성 3.글수정 4.글삭제 5.로그아웃 6.회원탈퇴");
				switch(input.nextInt()) {
				case 1:
					service.showList();
					break;
				case 2:
					BoardVO post = new BoardVO();
					System.out.print("제목 : ");
					post.setTitle(input.next());
					System.out.print("내용 : ");
					post.setContent(input.next());
					post.setWriter(loginData.getId());
					service.write(post);
					break;
				case 3:
					System.out.print("수정할 글 번호 : ");
					BoardVO modifyInfo = service.show(input.nextInt());
					//수정할 게시글 작성자와 로그인 정보가 일치할때
					if(modifyInfo.getWriter().equals(loginData.getId())) {
						System.out.print("기존 제목 >>> ");
						System.out.println(modifyInfo.getTitle());
						System.out.print("수정할 제목 : ");
						modifyInfo.setTitle(input.next());
						System.out.print("기존 내용 >>> ");
						System.out.println(modifyInfo.getContent());
						System.out.print("수정할 내용 : ");
						modifyInfo.setContent(input.next());
					}else {
						System.out.print("글 작성자가 아닙니다.");
					}
					break;
				case 4:
					System.out.print("삭제할 글 번호 : ");
					BoardVO deleteInfo = service.show(input.nextInt());
					//삭제할 게시글 작성자와 로그인 정보가 일치할때
					if(deleteInfo.getWriter().equals(loginData.getId())) {
						System.out.println("삭제정보) 글번호 : "+deleteInfo.getNum()+"제목 : "+deleteInfo.getTitle());
						System.out.println("정말로 삭제하시겠습니까? (Y/N)");
						if(input.next().toUpperCase().equals("Y")) {
							service.delete(deleteInfo);
							System.out.println("게시글이 삭제되었습니다.");
						}else {
							System.out.println("게시글 삭제가 취소되었습니다.");
						}
					}else {
						System.out.print("글 작성자가 아닙니다.");
					}
					break;
				case 5:
					System.out.println("로그아웃 되었습니다.");
					isLogin = false;
					break;
				case 6:
					System.out.println("정말로 회원 탈퇴를 하시겠습니까? (Y/N)");
					if(input.next().toUpperCase().equals("Y")) {
						System.out.println(loginData.getId()+"님 다음에 다시 만나요~");
						service.byebye(loginData);
						isLogin = false;
					}else {
						System.out.println("휴~");
					}
				default:
				}
			}
				
		}
		
	}
}
