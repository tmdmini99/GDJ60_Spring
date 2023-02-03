package com.iu.s1.product;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/product/*")//URL localhost/s1/ -->루트 경로 뒤에
//URL : localhost/s1/product/* product/뒤에 오는 모든  URL은 여기로 옴 
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	
	@RequestMapping(value ="list")
	public ModelAndView getProductList(ModelAndView mv) throws Exception{
		System.out.println("Product List");// URL이 localhost/s1/product/list가 올경우
		
		List<ProductDTO> ar=productService.getProductList();
		
		
		mv.setViewName("product/productList");
		mv.addObject("list", ar);
		
		System.out.println(ar.size()>0);
		
		return mv; // 파일 경로 /WEB-INF/views 가 생략
		//또한 뒤에 productList 뒤에 .jsp가 생략
	}
	//getProductDetail
	
	@RequestMapping(value ="detail") //URL이 localhost/s1/product/detail 이 올경우
	public String getProductDetail(ProductDTO productDTO,Model model) throws Exception{
		System.out.println("Product Detail");
		
		//파라미터의 이름과 setter의 이름과 같아야함
		//setter의 이름 set을 빼고 첫번째 대문자를 소문자로 바꾼것
		//setName  ->set을 빼고 N을 소문자로 바꿈 name이 setter의 이름
		
//		String num=request.getParameter("num");
		
		
		//ProductDTO productDTO = new ProductDTO();
		//productDTO.setProductNum(num);
		
		productDTO=productService.getProductDetail(productDTO);
		
		System.out.println(productDTO != null);
		
		model.addAttribute("dto", productDTO);
		
		
		
		return "product/productDetail";
	}
	
	@RequestMapping(value="productAdd" , method=RequestMethod.GET) //URL 주소와  JSP 경로명이 일치할 경우 void 사용해도 사용 가능
	public void getProductAdd() {
		System.out.println("Produt Add");
		
		
	}
	@RequestMapping(value="productAdd" , method = RequestMethod.POST)
	public String productAdd(ProductDTO productDTO) throws Exception{
		int result = productService.setAddProduct(productDTO, null);
		System.out.println(result == 1);
		return "redirect:./list";
	}
	
	
	
	@RequestMapping(value="update")
	public ModelAndView getProductUpdate() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("product/productUpdate");//Jsp 파일 경로
		
		System.out.println("Product Update");
		
		return mv;
		
	}
}
