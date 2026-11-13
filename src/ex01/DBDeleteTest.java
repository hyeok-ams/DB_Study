package ex01;

import java.sql.*;
import java.util.*;


public class DBDeleteTest {

	public static void main(String[] args) {
		String sql = """
				Delete From monsters
				where id = ? 
				""";
		try(
				Connection connection = DbConfig.getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(sql);//Sql문장 
				) {
			stmt.setInt(1, 9);
			int result = stmt.executeUpdate();//sql 실행하면 업데이트 갯수알려줌
												//executeUpdate() = insert, update, delete
			
			System.out.println("Delete 카운트" + result);
						
		} catch(Exception e) {
			System.out.println("MySQL 서버 연결에 실패했습니다.");
			System.out.println("오류내용 : " + e.getMessage() );
			
		}
	}

}
