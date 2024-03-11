package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		
		sql = "insert into user(name, height, weight, age, gender) values(?,?,?,?,?)";
		System.out.println("저장 확인해보께1");
		try {
			psmt = con.prepareStatement(sql);

			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHeight());
			psmt.setString(3, dto.getWeight());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getGender());
			System.out.println("저장 확인해보께2");
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	/**메인 사용자 기초정보 수정*/
	public void userModify(MainDTO dto) {
		
		sql ="update user set name = ?, height = ?, weight = ?, age = ?";
		System.out.println("수정 확인해보께1");
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHeight());
			psmt.setString(3, dto.getWeight());
			psmt.setInt(4, dto.getAge());
			
			System.out.println("수정 확인해보께2");
			psmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	/**메인 사용자 정보 가져오기*/
	public MainDTO userRead(MainDTO dto) {
		MainDTO res = null;
		
		sql ="select * from user";
		System.out.println("읽기 확인해보께1");
		
		try {
			psmt = con.prepareStatement(sql);
			System.out.println("읽기 확인해보께2");
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				res = new MainDTO();
				res.setName(rs.getString("name")); 
				res.setHeight(rs.getString("height")); 
				res.setWeight(rs.getString("weight")); 
				res.setAge(Integer.parseInt(rs.getString("age")));
				res.setGender(rs.getString("gender")); 
//				res.setGoalKcal(Integer.parseInt(rs.getString("goalKcal")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
}