package nonageshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import nonageshop.dao.AddressDao;
import nonageshop.dto.Address;

public class AddressDaoImpl implements AddressDao {
//서비스에도 추가해야됨 필터도?
	private Connection con;
	private static final AddressDaoImpl instance = new AddressDaoImpl();
	
	public static AddressDaoImpl getInstance() {
		return instance;
	}
	
	private AddressDaoImpl() {
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
	public ArrayList<Address> selectAddressByDong(String dong) {
		String sql = "SELECT ZIP_NUM,SIDO,GUGUN,DONG,ZIP_CODE,BUNJI FROM ADDRESS WHERE DONG LIKE ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, "%"+dong+"%");
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					ArrayList<Address> list = new ArrayList<Address>();
					do {
						list.add(getAddress(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Address getAddress(ResultSet rs) throws SQLException {
		String zipNum = rs.getString("ZIP_NUM");
        String sido = rs.getString("SIDO");
        String gugun = rs.getString("GUGUN");
        String dong = rs.getString("DONG");
        String zipCode = rs.getString("ZIP_CODE");
        String bunji = rs.getString("BUNJI");
		return new Address(zipNum, sido, gugun, dong, zipCode, bunji);
	}
}
