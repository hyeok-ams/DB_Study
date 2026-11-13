package ex01;

import java.sql.*;
import java.util.*;


public class DBUpdateTest {

	public static void main(String[] args) {
		String sql = """
				Update monsters set
				level_no = ? 
				where id = ? 
				""";
		try(
				Connection connection = DbConfig.getConnection();
				PreparedStatement stmt = 
						connection.prepareStatement(sql);//Sql문장 
				) {
			stmt.setInt(1, 16);
			stmt.setInt(2, 6);
			int result = stmt.executeUpdate();//sql 실행하면 업데이트 갯수알려줌
												//executeUpdate() = insert, update, delete
			
			System.out.println("update 카운트" + result);
						
		} catch(Exception e) {
			System.out.println("MySQL 서버 연결에 실패했습니다.");
			System.out.println("오류내용 : " + e.getMessage() );
			
		}
	}

}
