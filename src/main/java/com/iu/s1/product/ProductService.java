package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ProductService {
	
	
	//결합도가 높다(강하다) 서비스가 죽을때 같이소멸되는 경우
	
	
	@Autowired
	private ProductDAO productDAO;
	
	

	//결합도가 낮다(약하다)
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO =productDAO;
		
	}
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		return productDAO.getProductDetail(productDTO);
	}
	
	public List<ProductDTO> getProductList()throws Exception{
		return productDAO.getProductList();
	}
	
	
	
	public int setProductAdd(ProductDTO productDTO, List<ProductOptionDTO> ar) throws Exception{
		//product, option  두가지를 전처리함
		
		Long productNum = productDAO.getProductNum();
		productDTO.setProductNum(productNum);
		
		int result = productDAO.setProductAdd(productDTO);
		
		if(ar !=null){
		for(ProductOptionDTO productOptionDTO : ar) {
			productOptionDTO.setProductNum(productNum);
			result = productDAO.setAddProductOption(productOptionDTO);
			
		}
		}
		return result;
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
