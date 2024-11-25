package fileupload;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileUtil {
	
	public static String uploadFile(HttpServletRequest req, String sDirectory)
				throws ServletException, IOException{ 
		Part part = req.getPart("ofile");  // 클라이언트에서 업로드한 파일을 가져옴
		
		String partHeader = part.getHeader("content-disposition");  // 파일의 헤더 정보에서 파일명 추출
		String[] phArr = partHeader.split("filename=");  // 파일명 추출
		String originalFileName = phArr[1].trim().replace("\"", "");
		
		if (!originalFileName.isEmpty()) {     // 파일명이 빈 값이 아니라면,
			part.write(sDirectory + File.separator + originalFileName); // 파일 저장
		}
		return originalFileName; // 업로드된 원본 파일명 반환
	}
	
	public static String renameFile(String sDirectory, String fileName) { // 파일명을 변경
																			
		String ext = fileName.substring(fileName.lastIndexOf("."));  // 파일명에서 확장자 추출 - 파일명 뒤에 ex)(.txt)확장자 잘라내기
		String now = new SimpleDateFormat("yyyyMMdd_HmsS").format(new Date());// 현재 날짜와 시간을 기반으로 새 파일명 생성 (형식: yyyyMMdd_HHmmssSSS)
		
		String newFileName = now + ext; // 새 파일명 생성
		
		// 기존 파일과 새 파일 객체 생성
		File oldFile = new File(sDirectory + File.separator + fileName);
		File newFile = new File(sDirectory + File.separator + newFileName);
		oldFile.renameTo(newFile);// 기존 파일명을 새 파일명으로 변경
		
		return newFileName; // 새 파일명 반환
	}
}
