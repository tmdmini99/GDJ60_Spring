package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;
import com.iu.s1.util.Pager;

@Repository
public class ProductDAO {
	
	@Autowired
	private SqlSession sqlSession; //Mapper 위치
	private final String NAMESPACE="com.iu.s1.product.ProductDAO.";
	
	
	
	
	public Long getProductCount(Pager pager) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"getProductCount", pager);
	}
	
	
	
	
	// 어떤 mapper를 쓸껀지 정하는건 NAMESPACE 매개변수 붙이면 return뒤에 변수 넣어야함
	//매개변수는 DTO로 받는게 BEST 수업때문에 Long으로 받음
		public int setProductDelete(Long productNum) throws Exception {
			//매개변수의 명을 Mapper에 그대로 적어야함
			return sqlSession.delete(NAMESPACE+"setProductDelete", productNum);
		}
	
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		
		
		//selectOne 메서드는 결과물이 한개 나올때 사용
		return sqlSession.selectOne(NAMESPACE+"getProductDetail", productDTO);
		// NAMESPACE 뒤에 +된 getProductDetail은 Mapper의 <select id = 에서의 id값과 동일>
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//getMax
	public Long getProductNum() throws Exception{
		
		 
		 return sqlSession.selectOne(NAMESPACE+"getProductNum");
		
	}
	
	
	
	//ProductOption 메서드
	
	public List<ProductOptionDTO> getProductOptionList()throws Exception{
		List<ProductOptionDTO> ar = new ArrayList<ProductOptionDTO>();
		
		Connection con = DBConnection.getConnection1();
		String sql="SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductOptionDTO dto = new ProductOptionDTO();
			dto.setOptionNum(rs.getLong("OPTIONNUM"));
			dto.setProductNum(rs.getLong("PRODUCTNUM"));
			dto.setOptionName(rs.getString("OPTIONNAME"));
			dto.setOptionPrice(rs.getLong("OPTIONPRICE"));
			dto.setOptionAmount(rs.getLong("OPTIONAMOUNT"));
			
			ar.add(dto);
			
		}
		return ar;
	}
	
	
	
	public int setAddProductOption(ProductOptionDTO dto) throws Exception{
		Connection con = DBConnection.getConnection1();
		
		String sql = "INSERT INTO PRODUCTOPTION VALUES(PRODUCT_OPTION_SEQ.NEXTVAL,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, dto.getProductNum());
		st.setString(2, dto.getOptionName());
		st.setLong(3, dto.getOptionPrice());
		st.setLong(4, dto.getOptionAmount());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
	}
	
	
	
	
	
	// Product 메서드
	
	public List<ProductDTO> getProductList(Pager pager)throws Exception{
		return sqlSession.selectList(NAMESPACE+"getProductList",pager);
	}
	
	
	public int setProductAdd(ProductDTO productDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"setProductAdd",productDTO);
	
	}
	
	public static void main(String[] args) {
		
		try {
			ProductDAO dao = new ProductDAO();
			ProductDTO dto = new ProductDTO();
			
			List<ProductOptionDTO> ar =dao.getProductOptionList();
			
			
			
//			dto.setProductname("상품");
//			dto.setProductdetail("설명");
//			dto.setProductjumsu(1.1);
//			int a= dao.setProduct(dto);
			
			System.out.println(ar.size()!=0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
