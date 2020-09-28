package nonageshop.service;

import java.sql.Connection;
import java.util.ArrayList;

import nonageshop.dao.impl.AddressDaoImpl;
import nonageshop.dao.impl.MemberDaoImpl;
import nonageshop.ds.JndiDS;
import nonageshop.dto.Address;
import nonageshop.dto.Member;


public class MemberService {
	
	private MemberDaoImpl dao = MemberDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	private AddressDaoImpl addressDao = AddressDaoImpl.getInstance();
	
	public MemberService() {
		super();
		dao.setCon(con);
		addressDao.setCon(con);
	}
	
	public int confirmId(String userId) {
		return dao.confirmId(userId);
		
	}
	
	public Member getMember(String id) {
		return dao.getMember(id);
		
	}
	
	public int insertMember(Member member) {
		return dao.insertMember(member);
	}
	
	public ArrayList<Address> selectAddressByDong(String dong){
		return addressDao.selectAddressByDong(dong);
	}
	

}
