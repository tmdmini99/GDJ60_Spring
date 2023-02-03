package com.iu.s1.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="list")
	public String getProductList() throws Exception{
		
		List<ProductDTO> ar=(List<ProductDTO>)productService.getProductList();
		System.out.println("aaa");
		
		return "product/productList";
	}
	@RequestMapping(value="productAdd")
	public void setAdd() {
		
	}
	@RequestMapping(value="detail")
	public ModelAndView getDetail(ModelAndView mv) {
		
		 
		
		return mv;
	}
	
	
	
	
	
	
}
