package com.company;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List listMembers() {
		List list = new ArrayList();
		try {
			// connDB();
			con = dataFactory.getConnection();
			String query = "select * from t_member ";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public void addMember(MemberVO memberVO) {
		try {
			Connection con = dataFactory.getConnection();
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			String query = "insert into t_member";
			query += " (id,pwd,name,email)";
			query += " values(?,?,?,?)";
			System.out.println("prepareStatememt: " + query);
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isExisted(MemberVO memberVO) {
	    boolean result = false;
	    String id = memberVO.getId();  // MemberVO 객체에서 아이디를 가져옵니다.
	    String pwd = memberVO.getPwd();  // MemberVO 객체에서 비밀번호를 가져옵니다.
	    try {
	        con = dataFactory.getConnection();  // 데이터베이스 연결을 가져옵니다.
	        
	        // DECODE 함수를 사용하여 count(*)의 값이 1이면 'true', 아니면 'false'를 반환합니다.
	        // 이 쿼리는 주어진 id와 pwd가 t_member 테이블에 존재하는지 확인합니다.
	        String query = "select decode(count(*), 1, 'true', 'false') as result from t_member where id=? and pwd=?";
	        
	        System.out.println("Query: " + query);  // 실행될 SQL 쿼리 출력
	        pstmt = con.prepareStatement(query);  // 쿼리를 준비합니다.
	        pstmt.setString(1, id);  // 첫 번째 파라미터인 id 값을 쿼리에 설정합니다.
	        pstmt.setString(2, pwd);  // 두 번째 파라미터인 pwd 값을 쿼리에 설정합니다.
	        
	        ResultSet rs = pstmt.executeQuery();  // 쿼리 실행 후 결과를 ResultSet에 저장
	        rs.next();  // 결과 집합에서 첫 번째 레코드로 커서를 이동시킵니다.
	        
	        // DECODE 함수의 결과값을 가져와 문자열로 변환한 후 boolean 값으로 파싱합니다.
	        String resultStr = rs.getString("result");  // 'result' 컬럼에서 'true' 또는 'false' 값을 가져옵니다.
	        result = Boolean.parseBoolean(resultStr);  // 'true' 또는 'false'를 boolean 값으로 변환
	        
	        System.out.println("result=" + result);  // 결과값 출력 (true 또는 false)
	    } catch (Exception e) {
	        e.printStackTrace();  // 예외 발생 시 스택 트레이스를 출력
	    }return result;  // 최종 결과를 반환 (true 또는 false)
	}
}