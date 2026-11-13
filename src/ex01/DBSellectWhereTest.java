package ex01;

import java.sql.*;
import java.util.*;


public class DBSellectWhereTest {

	public static void main(String[] args) {
		String sql = "SELECT * FROM monsters where grade = ?";
		// mysql서버와 연결 테스트
		// 워크벤치의 TEST_Connection과 같은 기능 만들기
		try(
				// DbConfig.getConnection() : mysql 서버에 연결 시도
				// 성공하면 Connction 객체를 돌려줌
				Connection connection = DbConfig.getConnection();
				// 1. PreparedStatement 객체 필요 : mysql서버에 sql문자열 배달
				// 	  그 결과로 레코드들을 얻는다.
				PreparedStatement stmt = 
						connection.prepareStatement(sql);//Sql문장 
				// mysql서버가 보내준 레코드들을 하나씩 가져와야함 : Resultset.next
				// 마지막 레코드를 가져오면 eof == 0이라는 결과 반환
				) {// 연결시도 후 성공할때
			// mysql 서버에 접속하여 sql 질의 결과 얻기
			// 몬스터 객체를 리스트로 관리
			//List<Monster> monsters = new ArrayList<Monster>();
			// mysql 서버로 넘겨줄 조건값을 설정
			// 원래는 SELECT * FROM monsters where grade = '조건값' 
			// ?자리에 설정하는 것을 set자료형()를 호출
			stmt.setString(1, "희귀");
			//stmt.setString(1, "희귀") 한 후 Query날리기
			ResultSet resultset = stmt.executeQuery();
			
			while(resultset.next()) {
				System.out.println(resultset.getString("name"));
			
			}
		} catch(Exception e) {
			System.out.println("MySQL 서버 연결에 실패했습니다.");
			System.out.println("오류내용 : " + e.getMessage() );
			
		}
	}

}
