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
	


	public NutritionDTO todayNutrition(){
		NutritionDTO dto = null;
		sql = "select sum(na),sum(carbo),sum(sugar),sum(fat),sum(tFat),sum(sFat),sum(chole),sum(protein),sum(kcal),regDate  \r\n"
				+ "from nutrition where regDate = curdate()";
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
	
	
}
