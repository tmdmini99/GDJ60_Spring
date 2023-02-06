package com.iu.s1.member;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.iu.s1.util.DBConnection;

@Repository
public class MemberDAO {
	//setAddMember
	
	
	
	
	
	public int setAddMember(MemberDTO memberDTO) throws Exception{
		Connection con = DBConnection.getConnection1();
		
		String sql ="INSERT INTO MEMBER(ID, PW, NAME, ADDRESS, PHONE, EMAIL) VALUES(?,?,?,?,?,?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,memberDTO.getId());
		st.setString(2,memberDTO.getPw());
		st.setString(3, memberDTO.getName());
		st.setString(4, memberDTO.getAddress());
		st.setString(5, memberDTO.getPhone());
		st.setString(6, memberDTO.getEmail());
		
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		
		return result;
	}
	public List<MemberDTO> getMemberList() throws Exception{
		
		List<MemberDTO> ar = new ArrayList<MemberDTO>();
		Connection con = DBConnection.getConnection1();
		String sql = "SELECT * FROM MEMBER";
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setId(rs.getString("ID"));
			memberDTO.setPw(rs.getString("PW"));
			memberDTO.setName(rs.getString("NAME"));
			memberDTO.setAddress(rs.getString("ADDRESS"));
			memberDTO.setPhone(rs.getString("PHONE"));
			memberDTO.setEmail(rs.getString("EMAIL"));
			ar.add(memberDTO);
		}
		
		DBConnection.disConnection(rs, st, con);
		return ar;
		
	}
	
	
	
	
}
