package com.iu.s1.member;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s1.member.MemberDAO.";
	
	
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"memberJoin", memberDTO);
	}
	public List<MemberDTO> getMemberList() throws Exception{
		return sqlSession.selectList(NAMESPACE+"getMemberList");
	}
}
