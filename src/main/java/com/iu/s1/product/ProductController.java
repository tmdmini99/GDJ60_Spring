package com.iu.s1.product;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value ="/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="list") //URL
	public String getProductList(Model mv) throws Exception{
		
		List<ProductDTO> ar=(List<ProductDTO>)productService.getProductList();
		mv.addAttribute("list", ar);
		
		return "product/productList";
	}
	@RequestMapping(value="productAdd", method=RequestMethod.GET)
	public void getAdd() {
		
	}
	@RequestMapping(value="productAdd", method=RequestMethod.POST)
	public String getAdd(ProductDTO productDTO) throws Exception{
		
		productService.setAddProduct(productDTO, null);
		
		
		return "redirect:./list"; //URL
		
	}
	@RequestMapping(value="detail")
	public ModelAndView getDetail(ProductDTO productDTO,ModelAndView mv) throws Exception{
		
		productDTO=productService.getProductDetail(productDTO);
		mv.addObject("detail", productDTO);
		mv.setViewName("product/productDetail"); //JSP파일 위치
		 
		
		return mv;
	}
	
	
	
	
	
	
}
