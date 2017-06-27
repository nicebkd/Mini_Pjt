package Model.member.DAO;

import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO{

	@Override
	public ArrayList<String> insert() {
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		return (ArrayList<String>) list;
	}




}
