package com.iu.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase{
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
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

}