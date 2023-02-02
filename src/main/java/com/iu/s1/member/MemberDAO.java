package com.iu.s1.member;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {

	
	
	
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		
		Connection con = DBConnection.getConnection1();
		
		String sql = "INSERT INTO MEMBER VALUES(?,?,?,?,?,?)";		
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, memberDTO.getId());
		st.setString(2, memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getAddress());
		st.setString(5, memberDTO.getPhone());
		st.setString(6, memberDTO.getEmail());
		
		
		int result = st.executeUpdate();
		DBConnection.disConnection(st, con);
		
		return result;
	}
}
