package com.iu.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {
	
	//File을 HDD에 저장
	
	public String fileSave(MultipartFile multipartFile, String path) throws Exception{
		//1.어디에 저장할 것인가?
		///resources/upload/bankBook/...
		//2.저장관리는 운영체제가 담당
		File file = new File(path);
		
		//폴더가 존재하지 않으면 폴더 생성
		if(!file.exists()){
			file.mkdirs();
		}
		
		//3.중복되지 않는 파일명 생성
//		Calendar ca =Calendar.getInstance();
//		Long L=ca.getTimeInMillis();
		String name=UUID.randomUUID().toString();
		
		//4.확장자 추가
		//OriginalName에서 subString을 이용해서 확장자를 추출하는 작업
		//OriginalName을 파일 이름뒤에 붙임
		name=name+"_"+multipartFile.getOriginalFilename();
		
		System.out.println(name);
		//5. 파일 저장
		file = new File(file,name);
		
		//1) multipartFile객체의 transferTo 메서드 사용
		//multipartFile.transferTo(file);
		
		//2) Spring API FileCopyUtis 객체의 copy메서드 사용
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		
		return name;
	}
	
	
}
