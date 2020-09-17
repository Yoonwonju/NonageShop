package nonageshop.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import nonageshop.dao.impl.ProductDaoImpl;
import nonageshop.ds.JdbcUtil;
import nonageshop.dto.Product;

public class ProductDaoTest {

	private static Connection con = JdbcUtil.getConnection();
	private static ProductDaoImpl dao = ProductDaoImpl.getInstance();
	
	@BeforeClass
	public static void setUpBeforeClass() {
		dao.setCon(con);
	}
			
	@Test
	public void testListNewProduct() {
//		System.out.println("testListNewProduct()");
//	      List<Product> list = new ArrayList<Product>();
//	      list = dao.listNewProduct();
//	      Assert.assertNotNull(list);
//	      System.out.println(list);
	      
		System.out.println("testListNewProduct");
		List<Product> list = dao.listNewProduct();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}
	
	@Test
	public void testListBestProduct() {
		System.out.println("testListBestProduct");
		List<Product> list = dao.listBestProduct();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void testGetProduct() {
		System.out.println("testGetProduct");
		Product product = dao.getProduct(42);
		Assert.assertNotNull(product);
		System.out.println(product);
	}

	@Test
	public void testListKindProduct() {
		System.out.println("testListKindProduct");
		String[] kindArr = {"1", "2", "3", "4", "5"};
		for(String kind : kindArr) {
			ArrayList<Product> kindList = dao.listKindProduct(kind);
			Assert.assertNotNull(kindArr);
			System.out.println(kind);
			kindList.stream().forEach(System.out::println);
		}
	}

}
