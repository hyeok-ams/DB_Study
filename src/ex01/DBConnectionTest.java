package ex01;

import java.sql.Connection;

public class DBConnectionTest {

	public static void main(String[] args) {
		// mysql서버와 연결 테스트
		// 워크벤치의 TEST_Connection과 같은 기능 만들기
		try {// 연결시도 후 성공할때
		// DbConfig.getConnection() : mysql 서버에 연결 시도
		// 성공하면 Connction 객체를 돌려줌
		Connection connection = DbConfig.getConnection();
		System.out.println("MySQL 서버에 연결이 성공했습니다.");
		
		//connection.getCatalog() : 연결된 mysql서버의 데이터베이스 알려줌
		System.out.println("연결된 DB는: "
				+ connection.getCatalog());
		} catch(Exception e) {
			System.out.println("MySQL 서버 연결에 실패했습니다.");
			System.out.println("오류내용 : " + e.getMessage() );
			
		}
	}

}
