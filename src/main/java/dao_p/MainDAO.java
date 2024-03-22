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
import dto_p.RecommendNutriDTO;
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
		
		sql = "insert into user(name, height, weight, age, gender, kind, goalKcal) values(?,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);

			psmt.setString(1, dto.getName());
			psmt.setDouble(2, dto.getHeight());
			psmt.setDouble(3, dto.getWeight());
			psmt.setInt(4, dto.getAge());
			psmt.setString(5, dto.getGender());
			
			int gk = 0;
			if (dto.getAge()>=6 && dto.getAge()<=8) {
				kind="어린이";
				if(dto.getGender().equals("남")) {
					gk = 1700;
				}else {
					gk = 1500;
				}
			}else if(dto.getAge() >= 9 && dto.getAge() <= 18) {
				kind="청소년";
				if(dto.getGender().equals("남")) {
					gk = 2500;
				}else {
					gk = 2000;
				}
			}else if(dto.getAge() >=19 && dto.getAge() < 65) {
				kind="성인";
				if(dto.getGender().equals("남")) {
					gk = 2500;
				}else {
					gk = 2000;
				}
			}else if(dto.getAge() >= 65) {
				kind="노년";
				if(dto.getGender().equals("남")) {
					gk = 1950;
				}else {
					gk = 1550;
				}
			}
			psmt.setString(6, kind);
			psmt.setInt(7, gk);

			psmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	/**메인 사용자 기초정보 수정*/
	public void userModify(MainDTO dto, String kind, String name) {
		
//		sql ="update user set height = ?, weight = ?, age = ?, kind = ? where name = ?";
		sql ="update user set name = ?, height = ?, weight = ?, age = ?, kind = ? where name = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setDouble(2, dto.getHeight());
			psmt.setDouble(3, dto.getWeight());
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
			psmt.setString(6, name);
			
			psmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	/**메인 사용자 닉네임 기초정보 수정*/
	public void userNameModify(String modifyName, String originName) {
		
		sql ="update user set name = ? where name = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, modifyName);
			psmt.setString(2, originName);
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
		
		sql ="select * from user where name = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				res = new MainDTO();
				res.setName(rs.getString("name")); 
				res.setHeight(rs.getDouble("height")); 
				res.setWeight(rs.getDouble("weight")); 
				res.setAge(Integer.parseInt(rs.getString("age")));
				res.setGender(rs.getString("gender")); 
				res.setGoalKcal(rs.getInt("goalKcal")); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	public MainDTO detail(String name){
		MainDTO dto = null;
		sql = "select age, gender,kind,name,goalKcal from user where name = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				dto = new MainDTO();
				dto.setAge(rs.getInt("age"));
				dto.setGender(rs.getString("gender"));
				dto.setKind(rs.getString("kind"));
				dto.setName(rs.getString("name"));
				dto.setGoalKcal(rs.getInt("goalKcal"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return dto;
	}
	
	/**새로운 유저 이름 체크*/
	public MainDTO nameChk(String name) {
		MainDTO res = null;
		sql = "select * from user where name = ?";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				res = new MainDTO();
				res.setName(rs.getString("name")); 
				res.setHeight(rs.getDouble("height")); 
				res.setWeight(rs.getDouble("weight")); 
				res.setAge(Integer.parseInt(rs.getString("age")));
				res.setGender(rs.getString("gender")); 
				res.setGoalKcal(rs.getInt("goalKcal")); 
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
		return res;
	}
	
	public void modify(MainDTO dto,String name) {
		sql = "update user set goalKcal=? where name = ? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, dto.getGoalKcal());
			psmt.setString(2,name);
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
