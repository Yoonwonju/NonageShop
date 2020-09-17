package nonageshop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import nonageshop.dao.ProductDao;
import nonageshop.dto.Product;

public class ProductDaoImpl implements ProductDao {

	private Connection con;
	
	public Connection getCon() {
		return con;
	}
	
	public void setCon(Connection con) {
		this.con = con;
	}
	
	//Singleton 생성

	private static final ProductDaoImpl instance = new ProductDaoImpl();
	
	public static ProductDaoImpl getInstance() {
		return instance;
	}

	private ProductDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ArrayList<Product> listNewProduct() {
		String sql = "SELECT NO, NAME, SALEPRICE, IMAGE FROM NEW_PRO_VIEW";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				ArrayList<Product> list = new ArrayList<Product>();
				do {
					list.add(getListProduct(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			throw new CustomSQLException(e);
		}
		return null;
	}

	private Product getListProduct(ResultSet rs) throws SQLException {
		int no = rs.getInt("NO"); // 상품 번호
		String name = rs.getString("NAME"); // 상품명
		int salePrice = rs.getInt("SALEPRICE"); // 판매가
		String image = rs.getString("IMAGE"); // 상품이미지
//		String kind = rs.getString("KIND"); // 상품종류
//		int price = rs.getInt("PRICE"); // 원가
//		int margin = rs.getInt("MARGIN"); // 수익
//		String content = rs.getString("CONTENT"); // 상품내용
//		String delYn = rs.getString("DELYN"); // 상품 삭제 여부 'y' : 사용 , 'n' : 삭제
//		String bestYn = rs.getString("BESTYN"); // 베스트 상품 여부
//		Date regDate = rs.getDate("REGDATE"); // 등록일
		return new Product(no, name, salePrice, image);
	}

	@Override
	public ArrayList<Product> listBestProduct() {
		String sql = "SELECT NO, NAME, SALEPRICE, IMAGE FROM BEST_PRO_VIEW";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
			if(rs.next()) {
				ArrayList<Product> list = new ArrayList<Product>();
				do {
					list.add(getListProduct(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Product> listKindProduct(String kind) {
		String sql = "SELECT NO,NAME,KIND,PRICE,SALEPRICE,MARGIN,CONTENT,IMAGE,DEL_YN,BEST_YN,REG_DATE"
						+ "  FROM PRODUCT WHERE KIND = ? ";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setString(1, kind);
			try(ResultSet rs = pstmt.executeQuery();){
				if(rs.next()) {
					ArrayList<Product> list = new ArrayList<Product>();
					do {
						list.add(getProduct(rs));
					}while(rs.next());
					return list;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product getProduct(int no) {
		String sql = "SELECT NO,NAME,KIND,PRICE,SALEPRICE,MARGIN,CONTENT,IMAGE,DEL_YN,BEST_YN,REG_DATE FROM PRODUCT WHERE NO = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql);){
			pstmt.setInt(1, no);
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getProduct(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Product getProduct(ResultSet rs) throws SQLException {
		Product pdt = getListProduct(rs);
		pdt.setKind(rs.getString("KIND"));
		pdt.setPrice(rs.getInt("PRICE"));
		pdt.setMargin(rs.getInt("MARGIN"));
		pdt.setContent(rs.getString("CONTENT"));
		pdt.setDelYn(rs.getString("DEL_YN"));
		pdt.setBestYn(rs.getString("BEST_YN"));
		pdt.setRegDate(rs.getDate("REG_DATE"));
		return pdt;
		
//		int no = rs.getInt("NO"); // 상품 번호
//		String name = rs.getString("NAME"); // 상품명
//		int salePrice = rs.getInt("SALEPRICE"); // 판매가
//		String image = rs.getString("IMAGE"); // 상품이미지
//		String kind = rs.getString("KIND"); // 상품종류
//		int price = rs.getInt("PRICE"); // 원가
//		int margin = rs.getInt("MARGIN"); // 수익
//		String content = rs.getString("CONTENT"); // 상품내용
//		String delYn = rs.getString("DELYN"); // 상품 삭제 여부 'y' : 사용 , 'n' : 삭제
//		String bestYn = rs.getString("BESTYN"); // 베스트 상품 여부
//		Date regDate = rs.getDate("REGDATE"); // 등록일
//		return new Product(no, name, kind, price, salePrice, margin, content, image, delYn, bestYn, regDate);
	}

}
