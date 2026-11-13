package ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class DBSellectListTest {

	public static void main(String[] args) {
		String sql = "SELECT id, name, grade, level_no, exp, element FROM monsters";
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
				ResultSet resultset = stmt.executeQuery();
				// mysql서버가 보내준 레코드들을 하나씩 가져와야함 : Resultset.next
				// 마지막 레코드를 가져오면 eof == 0이라는 결과 반환
				) {// 연결시도 후 성공할때
			// mysql 서버에 접속하여 sql 질의 결과 얻기

			while(resultset.next()) {
				//get형식("컬럼명")
				int id = resultset.getInt("id"); 
				String name = resultset.getString("name");
				String grade = resultset.getString("grade");
				int level = resultset.getInt("level_no"); 
				int exp = resultset.getInt("exp"); 
				String element = resultset.getString("element");
				Monster monster = 
						new Monster(id, name, grade, level, exp, element);
				System.out.println(monster.getName());
			}
			/*
			 * try에서 아래중 하나라도 null일때 닫고 catch로 넘어감
			if(resultset != null)
			{
				resultset.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(connection != null) {
				connection.close();
			}
			*/
		} catch(Exception e) {
			System.out.println("MySQL 서버 연결에 실패했습니다.");
			System.out.println("오류내용 : " + e.getMessage() );
			
		}
	}

}
