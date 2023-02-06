package com.iu.s1.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class ProductDAO {
	
	
	
	
	
	
	
	
	
	
	
	
	
	public ProductDTO getProductDetail(ProductDTO productDTO) throws Exception{
		
		
		Connection con = DBConnection.getConnection1();
		String sql ="SELECT * FROM PRODUCT WHERE PRODUCTNUM = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1,productDTO.getProductNum() );
		
		ResultSet rs = st.executeQuery();
		
		
		if(rs.next()) {
			productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductDetail(rs.getString("PRODUCTDETAIL"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			
			
		}else {
			productDTO = null;
		}
		DBConnection.disConnection(rs, st, con);
		return productDTO;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//getMax
	public Long getProductNum() throws Exception{
		Connection con = DBConnection.getConnection1();
		
		String sql = "SELECT PRODUCT_SEQ.NEXTVAL FROM DUAL";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		 Long num = rs.getLong(1);
		 
		 DBConnection.disConnection(rs, st, con);
		 
		 return num;
		
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
		DBConnection.disConnection(rs, st, con);
		return ar;
	}
	
	
	
	public int setAddProdcutOption(ProductOptionDTO dto) throws Exception{
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
	public List<ProductDTO> getProductList()throws Exception{
		ArrayList<ProductDTO> ar = new ArrayList<ProductDTO>();
		
		Connection con = DBConnection.getConnection1();
		
		String sql = "SELECT PRODUCTNUM,PRODUCTNAME,PRODUCTJUMSU "
				+ "FROM PRODUCT ORDER BY PRODUCTJUMSU DESC";
	
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			ProductDTO productDTO = new ProductDTO();
			productDTO.setProductNum(rs.getLong("PRODUCTNUM"));
			productDTO.setProductName(rs.getString("PRODUCTNAME"));
			productDTO.setProductJumsu(rs.getDouble("PRODUCTJUMSU"));
			
			ar.add(productDTO);
		}
		DBConnection.disConnection(rs, st, con);
		
		return ar;
	}
	
	
	public int setAddProduct(ProductDTO productDTO) throws Exception{
		Connection con = DBConnection.getConnection1();
		
		String sql = "INSERT INTO PRODUCT(PRODUCTNUM, PRODUCTNAME, PRODUCTDETAIL, PRODUCTJUMSU) VALUES(?,?,?,0.0)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		st.setLong(1, productDTO.getProductNum());
		st.setString(2, productDTO.getProductName());
		st.setString(3, productDTO.getProductDetail());
		
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		return result;
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
