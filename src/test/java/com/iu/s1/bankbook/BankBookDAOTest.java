package com.iu.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankBookDAOTest extends MyTestCase{
	
	@Autowired
	BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookListTest() throws Exception{
		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
		
		assertNotEquals(0, ar.size());
	}
	//@Test
	public void setBankBookAdd() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		bankBookDTO.setBookName("ddda");
		bankBookDTO.setBookRate(1.11);
		bankBookDTO.setBookSale(1);
		bankBookDTO.setBookDetail("ddd");
		int a = bankBookDAO.setBankBookAdd(bankBookDTO);
		
		assertEquals(1, a);
		
	}
	//@Test
	public void setBankBookDelete() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		
		int a =bankBookDAO.setBankBookDelete(bankBookDTO);
		
		assertEquals(1, a);
		
	}
	//@Test
	public void getBankBookDetail() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();	
		bankBookDTO.setBookNumber(1L);
		bankBookDTO=bankBookDAO.getBankBookDetail(bankBookDTO);
		assertNotNull(bankBookDTO);
	}
	//@Test
	public void setBankBookUpdate() throws Exception{
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(1L);
		bankBookDTO.setBookName("aaaab");
		
		int a =bankBookDAO.setBankBookUpdate(bankBookDTO);
		
		assertEquals(1, a);
	}
	
	

}
