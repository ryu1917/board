 package board;

import member.MemberVO;

public class BoardService implements IBoardService {

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

	}

	@Override
	public BoardVO show(int num) {
		return null;
	}

	@Override
	public void modify(BoardVO b) {

	}

	@Override
	public void delete(BoardVO b) {

	}

	@Override
	public void showList() {

	}

}
