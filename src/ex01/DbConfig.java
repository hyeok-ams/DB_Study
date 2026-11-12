package ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfig {
	// 자바와 데이터베이스가 네트워크 연결하여
	// 통신하는 것이므로 통신규칙이 필요
	// jdbc:mysql = db와 통신하는 네트워크 프로토콜
	// db_uri = /db명
	// jdbc:mysql://db호스트주소:포트/dburi
	// mysql 전용옵션 =
	// "?characterEncoding = UTF-8&serverTimezone=Asia/Seoul";
	// 항상 시작을 jdbc:mysql://localhost:3306/monster_lab
	private static final String DB_URL = 
			"jdbc:mysql://localhost:3306/monster_lab"
			+ "?characterEncoding = UTF-8&serverTimezone=Asia/Seoul";
	
	private static final String DB_USER = "root";
	private static final String DB_PASS = "admin1234";
	
	// 자바가 mysql서버에 연결함
	public static Connection getConnection() throws SQLException{
		// mysql connector/J를 이용해서 mysql에 연결
		// 이것을 connection이라고 함
		return DriverManager.getConnection(
				DB_URL, DB_USER, DB_PASS);
		
	}


	
}
