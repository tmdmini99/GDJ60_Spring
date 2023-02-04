package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import oracle.net.aso.m;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	public int setAddMember(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.setAddMember(memberDTO);
	}
	public List<MemberDTO> getMemberList() throws Exception{
		return memberDAO.getMemberList();
	}
}
