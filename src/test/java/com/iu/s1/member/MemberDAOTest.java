package com.iu.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase{
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	public void setMemberAdd() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("13");
		memberDTO.setPw("ddd");
		memberDTO.setName("name");
		memberDTO.setAddress("ddd");
		memberDTO.setPhone("0001");
		memberDTO.setEmail("ddd");
		
		int a=memberDAO.setMemberAdd(memberDTO);
		assertEquals(1, a);
	}
	//@Test
	public void setMemberLogin() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("dd");
		memberDTO.setPw("dd");
		
		memberDTO=memberDAO.getMemberLogin(memberDTO);
		
		assertNotNull(null, memberDTO);
	}
	//@Test
	public void setMemberUpdate() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("dd");
		memberDTO.setName("d2");
		memberDTO.setAddress("d3");
		memberDTO.setPhone("d4");
		memberDTO.setEmail("d5");
		
		int a = memberDAO.setMemberUpdate(memberDTO);
		assertEquals(1, a);
		
	}

}
