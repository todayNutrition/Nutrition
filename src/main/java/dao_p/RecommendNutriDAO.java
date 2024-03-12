package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto_p.RecommendNutriDTO;

public class RecommendNutriDAO {
	
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public RecommendNutriDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource)init.lookup("java:comp/env/nutrition");
			con = ds.getConnection();
		}
		catch (SQLException | NamingException e) {
			e.printStackTrace();
		}
	}
	
	void close() {
		if(rs!=null) {try {rs.close();} catch (SQLException e) {}}
		if(psmt!=null) {try {psmt.close();} catch (SQLException e) {}}
		if(con!=null) {try {con.close();} catch (SQLException e) {}}
	}
	

	
	public ArrayList<RecommendNutriDTO> list(int age,String gender){
		ArrayList<RecommendNutriDTO> res = new ArrayList<RecommendNutriDTO>();
		if (age>=6 && age<=8) {
			sql = "select * from rda where kind='어린이' && gender = ?";
		}else if(age >= 9 && age <= 18) {
			sql = "select * from rda where kind='청소년' && gender = ?";
		}else if(age >=19 && age < 65) {
			sql = "select * from rda where kind='성인' && gender = ?";
		}else if(age >= 65) {
			sql = "select * from rda where kind='노년' && gender = ?";
		}
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, gender);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				RecommendNutriDTO dto = new RecommendNutriDTO();
				dto.setKind(rs.getString("kind"));
				dto.setGender(rs.getString("gender"));
				dto.setKcal(rs.getInt("kcal"));
				dto.setCarbo(rs.getInt("carbo"));
				dto.setNa(rs.getInt("na"));
				dto.setSugar(rs.getInt("sugar"));
				dto.setProtein(rs.getInt("protein"));
				dto.setFat(rs.getInt("fat"));
				dto.settFat(rs.getInt("tFat"));
				dto.setsFat(rs.getInt("sFat"));
				dto.setChole(rs.getInt("chole"));
				res.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return res;
	}
	
	public void modify(RecommendNutriDTO dto,int age,String gender) {
		if (age>=6 && age<=8) {
			sql = "update rda set kcal=? where kind='어린이' && gender = ?";
		}else if(age >= 9 && age <= 18) {
			sql = "update rda set kcal=? where kind='청소년' && gender = ?";
		}else if(age >=19 && age < 65) {
			sql = "update rda set kcal=? where kind='성인' && gender = ?";
		}else if(age >= 65) {
			sql = "update rda set kcal=? where kind='노년' && gender = ?";
		}
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, dto.getKcal());
			psmt.setString(2, gender);
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**구분, 성별로 평균 권장량 가져오기*/
	public ArrayList<RecommendNutriDTO> list1(String kind, String gender){
		ArrayList<RecommendNutriDTO> res = new ArrayList<RecommendNutriDTO>();
		
		sql = "select * from rda where kind = ? and rda.gender = ?";
	
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kind);
			psmt.setString(2, gender);
			rs = psmt.executeQuery();		
			
			while(rs.next()) {
				RecommendNutriDTO dto = new RecommendNutriDTO();
				dto.setKind(rs.getString("kind"));
				dto.setGender(rs.getString("gender"));
				dto.setKcal(rs.getInt("kcal"));
				dto.setCarbo(rs.getInt("carbo"));
				dto.setNa(rs.getInt("na"));
				dto.setSugar(rs.getInt("sugar"));
				dto.setProtein(rs.getInt("protein"));
				dto.setFat(rs.getInt("fat"));
				dto.settFat(rs.getInt("tFat"));
				dto.setsFat(rs.getInt("sFat"));
				dto.setChole(rs.getInt("chole"));
				res.add(dto);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return res;
	}
}