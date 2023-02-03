package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ProductService {
	
	
	//결합도가 높다(강하다) 서비스가 죽을때 같이소멸되는 경우
	
	
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductDTO> getProductList() throws Exception{
		
		return productDAO.getProductList();
		
	}
	
	public int setAddProduct(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception{
		
		Long num = productDAO.getProductNum();
		
		int result = productDAO.setAddProduct(productDTO);;
		 
		
		if(ar !=null) {
			for(ProductOptionDTO productOptionDTO : ar) {
				
			}
		}
	
		return result;
	}

	
	
}
