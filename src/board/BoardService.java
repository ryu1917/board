 package board;

import java.util.Scanner;

import member.MemberVO;

public class BoardService implements IBoardService {
	
	private DBClass DAO = new DBClass();

	@Override
	public boolean login(MemberVO m) {
		return false;
	}
	
	@Override
	public MemberVO getInfo(MemberVO m) {
		return null;
	}

	@Override
	public void logout() {

	}
	
	@Override
	public boolean overlap(String id) {
		return false;
	}

	@Override
	public void register(MemberVO m) {

	}

	@Override
	public void byebye(MemberVO m) {

	}

	@Override
	public void write(BoardVO b) {
		int result = DAO.insertBoard(b);
		System.out.println(result != 0 ? "글이 저장되었습니다.":"글 저장에 실패했습니다."); 
	}

	@Override
	public BoardVO show(int num) {
		return null;
	}

	@Override
	public void modify(BoardVO b) {

	}

	@Override
	public void delete(int delNum, String loginId, Scanner input) {
		BoardVO delInfo = DAO.getBoard(delNum);
		//삭제할 게시글 작성자와 로그인 정보가 일치할때만 삭제
		if(delInfo.getWriter().equals(loginId)) {
			System.out.println("삭제정보) 글번호 : "+delInfo.getNum()+"제목 : "+delInfo.getTitle());
			System.out.println("정말로 삭제하시겠습니까? (Y/N)");
			//다시한번 재확인
			if(input.next().toUpperCase().equals("Y")) {
				int result = DAO.deleteBoard(delNum);
				System.out.println(result != 0 ? "게시글이 삭제되었습니다." : "게시글 삭제에 실패했습니다.");
			}else {
				System.out.println("게시글 삭제가 취소되었습니다.");
			}
		}else {
			System.out.print("글 작성자가 아닙니다.");
		}
	}

	@Override
	public void showList() {

	}

}
