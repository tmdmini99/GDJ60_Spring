package com.iu.s1.product;

import java.util.List;

import javax.servlet.RequestDispatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/product/*")//URL localhost/s1/ -->루트 경로 뒤에
//URL : localhost/s1/product/* product/뒤에 오는 모든  URL은 여기로 옴 
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	
	@RequestMapping(value ="list")
	public String getProductList() throws Exception{
		System.out.println("Product List");// URL이 localhost/s1/product/list가 올경우
		
		List<ProductDTO> ar=productService.getProductList();
		
		
		System.out.println(ar.size()>0);
		
		return "product/productList"; // 파일 경로 /WEB-INF/views 가 생략
		//또한 뒤에 productList 뒤에 .jsp가 생략
	}
	//getProductDetail
	@RequestMapping(value ="detail") //URL이 localhost/s1/product/detail 이 올경우
	public String getProductDetail() {
		System.out.println("Product Detail");
		
		return "product/productDetail";
	}
	@RequestMapping(value="productAdd") //URL 주소와  JSP 경로명이 일치할 경우 void 사용해도 사용 가능
	public void getProductAdd() {
		System.out.println("Produt Add");
		
		
	}
	@RequestMapping(value="update")
	public ModelAndView getProductUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");//Jsp 파일 경로
		
		System.out.println("Product Update");
		
		return mv;
		
	}
}
