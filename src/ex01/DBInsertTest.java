package ex01;

import java.sql.*;
import java.util.*;


public class DBInsertTest {

	public static void main(String[] args) {
		String sql = """
				insert into monsters (name, grade, level_no, exp, element) 
				values (?, ?, ?, ?, ?)
				""";
		try(
				Connection connection = DbConfig.getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(sql);//Sql문장 
				) {
			stmt.setString(1, "꼬마유령");
			stmt.setString(2, "희귀");
			stmt.setInt(3, 15);
			stmt.setInt(4, 900);
			stmt.setString(5, "어둠");
			int result = stmt.executeUpdate();//sql 실행하면 업데이트 갯수알려줌
												//executeUpdate() = insert, update, delete
			
			System.out.println("insert 카운트" + result);
			
		} catch(Exception e) {
			System.out.println("MySQL 서버 연결에 실패했습니다.");
			System.out.println("오류내용 : " + e.getMessage() );
			
		}
	}

}
