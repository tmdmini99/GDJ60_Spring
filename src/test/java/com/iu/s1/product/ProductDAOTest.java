package com.iu.s1.product;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.member.MemberDTO;

public class ProductDAOTest extends MyTestCase{
	
	@Autowired
	private ProductDAO productDAO;
	
//	//@Test
//	public void getProductListTest() throws Exception{
//		//List<ProductDTO>ar=productDAO.getProductList();
//		//단정문
//		//assertNotEquals(0, ar.size()); 
//		
//	}
	//@Test
	public void getProductDetail() throws Exception {
		ProductDTO productDTO= new ProductDTO();
		productDTO.setProductNum(28L);
		productDTO=productDAO.getProductDetail(productDTO);
		
		assertNotNull(productDTO);
		
	}
//	//insert
	//@Test
	public void setProductAdd() throws Exception{
		ProductDTO productDTO= new ProductDTO();
		productDTO.setProductNum(5L);
		productDTO.setProductName("ok");
		productDTO.setProductDetail("detail");
		productDTO.setProductJumsu(1.1);
		
		int a = productDAO.setProductAdd(productDTO);
		assertEquals(1, a);
	}
	
	

}
