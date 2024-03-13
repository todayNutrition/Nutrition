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

import dto_p.MainDTO;
import dto_p.NutritionDTO;
import dto_p.RecommendNutriDTO;

public class NutritionDAO {
	
	Connection con;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;
	
	public NutritionDAO() {
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
	
	
	public NutritionDTO todayNutrition(String kind, String gender){
		NutritionDTO dto = null;
		sql = "select"
				+ "	IF(sum(a.na)/b.na*100 > 100, IF(sum(a.na)/b.na*100 >= 200,0,100+(100-(sum(a.na)/b.na*100))), sum(a.na)/b.na*100) AS na,"
				+ "	IF(sum(a.carbo)/b.carbo*100 > 100, IF(sum(a.carbo)/b.carbo*100 >= 200,0,100+(100-(sum(a.carbo)/b.carbo*100))), sum(a.carbo)/b.carbo*100) AS carbo,"
				+ "	IF(sum(a.sugar)/b.sugar*100 > 100, IF(sum(a.sugar)/b.sugar*100 >= 200,0,100+(100-(sum(a.sugar)/b.sugar*100))), sum(a.sugar)/b.sugar*100) AS sugar,"
				+ "	IF(sum(a.fat)/b.fat*100 > 100, IF(sum(a.fat)/b.fat*100 >= 200,0,100+(100-(sum(a.fat)/b.fat*100))), sum(a.fat)/b.fat*100) AS fat,"
				+ "	IF(sum(a.tFat)/b.tFat*100 > 100, IF(sum(a.tFat)/b.tFat*100 >= 200,0,100+(100-(sum(a.tFat)/b.tFat*100))), sum(a.tFat)/b.tFat*100) AS tFat,"
				+ "	IF(sum(a.sFat)/b.sFat*100 > 100, IF(sum(a.sFat)/b.sFat*100 >= 200,0,100+(100-(sum(a.sFat)/b.sFat*100))), sum(a.sFat)/b.sFat*100) AS sFat,"
				+ "	IF(sum(a.chole)/b.chole*100 > 100, IF(sum(a.chole)/b.chole*100 >= 200,0,100+(100-(sum(a.chole)/b.chole*100))), sum(a.chole)/b.chole*100) AS chole,"
				+ "	IF(sum(a.protein)/b.protein*100 > 100, IF(sum(a.protein)/b.protein*100 >= 200,0,100+(100-(sum(a.protein)/b.protein*100))), sum(a.protein)/b.protein*100) AS protein,"
				+ "	IF(sum(a.kcal)/b.kcal*100 > 100, IF(sum(a.kcal)/b.kcal*100 >= 200,0,100+(100-(sum(a.kcal)/b.kcal*100))), sum(a.kcal)/b.kcal*100) AS kcal "
				+ "	from nutrition a, rda b"
				+ "	where regDate = curdate() && b.kind = ? && b.gender = ?";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kind);
			psmt.setString(2, gender);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				dto = new NutritionDTO();
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
	
	public NutritionDTO totalNutrition(){
		NutritionDTO dto = null;
		sql = "select "
				+ " sum(na), sum(kcal), sum(carbo), sum(sugar), sum(protein), "
				+ " sum(fat), sum(tFat), sum(sFat), sum(chole), regDate "
				+ " from nutrition "
				+ " where regDate = curdate()";
		try {
			psmt = con.prepareStatement(sql);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				dto = new NutritionDTO();
				dto.setKcal(rs.getInt("sum(kcal)"));
				dto.setCarbo(rs.getInt("sum(carbo)"));
				dto.setNa(rs.getInt("sum(na)"));
				dto.setSugar(rs.getInt("sum(sugar)"));
				dto.setProtein(rs.getInt("sum(protein)"));
				dto.setFat(rs.getInt("sum(fat)"));
				dto.settFat(rs.getInt("sum(tFat)"));
				dto.setsFat(rs.getInt("sum(sFat)"));
				dto.setChole(rs.getInt("sum(chole)"));
				dto.setRegDate(rs.getDate("regDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return dto;
	}
	
	public void dayAvg(int dayAvg) {
		
		sql ="update nutrition set dayAvg = ? where regdate = curdate()";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, dayAvg);
			psmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void write(NutritionDTO dto) {
		
		sql = "insert into nutrition(regDate, na, carbo, sugar, fat, tFat, sFat, chole, protein, kcal) values (sysdate(),?,?,?,?,?,?,?,?,?)";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1,  dto.getNa());
			psmt.setInt(2,  dto.getCarbo());
			psmt.setInt(3,  dto.getSugar());
			psmt.setInt(4,  dto.getFat());
			psmt.setInt(5,  dto.gettFat());
			psmt.setInt(6,  dto.getsFat());
			psmt.setInt(7,  dto.getChole());
			psmt.setInt(8,  dto.getProtein());
			psmt.setInt(9,  dto.getKcal());
			
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}
	
}
