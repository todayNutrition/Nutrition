package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.MainDTO;

public class MainDAO {
	
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public MainDAO() {
		
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/nutrition");
			con = ds.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void close() { //연결 해제 메소드
		if(rs!=null) {try {rs.close();} catch (SQLException e) {}}
		if(psmt!=null) {try {psmt.close();} catch (SQLException e) {}}
		if(con!=null) {try {con.close();} catch (SQLException e) {}}
	}
	
	
	/**메인 사용자 입력 정보 저장하기*/
	public void userWrite(MainDTO dto) {
		
		sql = "insert into user(name, height, weight, age, gender, goalKcal) values(?,?,?,?,?,?)";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHeight());
			psmt.setString(3, dto.getWeight());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getGender());
			psmt.setInt(6, dto.getGoalKcal());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public MainDTO detail(){
		MainDTO dto = null;
		sql = "select age, gender from user ";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				dto = new MainDTO();
				dto.setAge(rs.getInt("age"));
				dto.setGender(rs.getString("gender"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return dto;
	}
	
}
