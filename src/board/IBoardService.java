package board;

import java.util.Scanner;

import member.MemberVO;

public interface IBoardService {
	/////////// 로그인 관련 기능 ///////////
	// 로그인 검증 기능
	boolean login(MemberVO m);
	
	// 회원정보 가져오기
	MemberVO getInfo(MemberVO m);
	
	// 로그아웃 기능
	void logout();
	
	// 아이디 중복 검증 기능
	boolean overlap(String id);
	
	// 회원가입 기능
	void register(MemberVO m);
	
	// 회원탈퇴 기능
	void byebye(MemberVO m);
	
	/////////// 게시판 관련 기능 ///////////
	//게시글 작성기능
	void write(BoardVO b);
	
	//게시글 보기기능
	BoardVO show(int num);
	
	//게시글 수정기능
	void modify(BoardVO b);
	
	//게시글 삭제기능
	void delete(int delNum, String loginId, Scanner input);
	
	//게시글 목록보기
	void showList();

}
