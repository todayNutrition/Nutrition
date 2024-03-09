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
	
	
	public ArrayList<RecommendNutriDTO> list(){
		ArrayList<RecommendNutriDTO> res = new ArrayList<RecommendNutriDTO>();
		sql = "select * from rda"; //등록 날짜 기준 내림차순
		try {
			psmt = con.prepareStatement(sql);
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
	
	
	
	public RecommendNutriDTO recommendNutrition(String kind, String gender){
		RecommendNutriDTO dto = null;
		sql = "select * from rda where kind=?,gender=?"; // 하루 권장 섭취량 읽어오기
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kind);
			psmt.setString(2, gender);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				dto = new RecommendNutriDTO();
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return dto;
	}
	
	
}
