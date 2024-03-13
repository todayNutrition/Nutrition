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
import jakarta.servlet.http.Cookie;

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
	public void userWrite(MainDTO dto, String kind) {
		
		sql = "insert into user(name, height, weight, age, gender, kind) values(?,?,?,?,?,?)";
//		System.out.println("저장 확인해보께1");
		try {
			psmt = con.prepareStatement(sql);

			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHeight());
			psmt.setString(3, dto.getWeight());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getGender());
			
			if (dto.getAge()>=6 && dto.getAge()<=8) {
				kind="어린이";
			}else if(dto.getAge() >= 9 && dto.getAge() <= 18) {
				kind="청소년";
			}else if(dto.getAge() >=19 && dto.getAge() < 65) {
				kind="성인";
			}else if(dto.getAge() >= 65) {
				kind="노년";
			}
			psmt.setString(6, kind);
//			System.out.println("저장 확인해보께2");
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	/**메인 사용자 기초정보 수정*/
	public void userModify(MainDTO dto, String kind) {
		
		sql ="update user set name = ?, height = ?, weight = ?, age = ?, kind = ?";
//		System.out.println("수정 확인해보께1");
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getHeight());
			psmt.setString(3, dto.getWeight());
			psmt.setInt(4, dto.getAge());
			
			if (dto.getAge()>=6 && dto.getAge()<=8) {
				kind="어린이";
			}else if(dto.getAge() >= 9 && dto.getAge() <= 18) {
				kind="청소년";
			}else if(dto.getAge() >=19 && dto.getAge() < 65) {
				kind="성인";
			}else if(dto.getAge() >= 65) {
				kind="노년";
			}
			psmt.setString(5, kind);
			
//			System.out.println("수정 확인해보께2");
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
//		System.out.println("읽기 확인해보께1");
		
		try {
			psmt = con.prepareStatement(sql);
//			System.out.println("읽기 확인해보께2");
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
	
	public MainDTO detail(){
		MainDTO dto = null;
		sql = "select age, gender,kind from user ";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				dto = new MainDTO();
				dto.setAge(rs.getInt("age"));
				dto.setGender(rs.getString("gender"));
				dto.setKind(rs.getString("kind"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return dto;
	}
	
	/**새로운 user 입장시 기존 사용자 정보 삭제*/
	public MainDTO delete(Cookie coo) {
		MainDTO dto = null;
		sql = "delete from user";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
}
