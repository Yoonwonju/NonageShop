package nonageshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import nonageshop.dao.MemberDao;
import nonageshop.dto.Member;

public class MemberDaoImpl implements MemberDao {

	private static final MemberDaoImpl instance = new MemberDaoImpl();
	private Connection con;
	
	public static MemberDaoImpl getInstance() {
		return instance;
	}

	private MemberDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getCon() {
		return con;
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}

	@Override
	public int confirmId(String userId) {
		String sql = "SELECT 1 FROM MEMBER WHERE ID = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, userId);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					return rs.getInt(1);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Member getMember(String id) {
		String sql = "SELECT ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE, LEAVE_YN, JOIN_DATE FROM MEMBER WHERE ID = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, id);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					return getMember(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Member getMember(ResultSet rs) throws SQLException {
		String id = rs.getString("ID");
		String pwd = rs.getString("PWD");
		String name = rs.getString("NAME");
		String email = rs.getString("EMAIL");
		String zipNum = rs.getString("ZIP_NUM");
		String address = rs.getString("ADDRESS");
		String phone = rs.getString("PHONE");
		String leave_yn = rs.getString("LEAVE_YN");
		Date joinDate = rs.getDate("JOIN_DATE");
		return new Member(id, pwd, name, email, zipNum, address, phone, leave_yn, joinDate);
	}

	@Override
	public int insertMember(Member member) {
		String sql = "INSERT INTO MEMBER (ID, PWD, NAME, EMAIL, ZIP_NUM, ADDRESS, PHONE)"
						+ " VALUES (?,?,?,?,?,?,?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getZipNum());
			pstmt.setString(6, member.getAddress());
			pstmt.setString(7, member.getPhone());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
	}
}
