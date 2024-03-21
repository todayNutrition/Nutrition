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
	
	
	public NutritionDTO todayNutrition(String kind, String gender, String name){
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
				+ "	IF(sum(a.kcal)/c.goalKcal*100 > 100, IF(sum(a.kcal)/c.goalKcal*100 >= 200,0,100+(100-(sum(a.kcal)/c.goalKcal*100))), sum(a.kcal)/c.goalKcal*100) AS kcal "
				+ "	from nutrition a "
				+ " JOIN rda b "
				+ " LEFT OUTER JOIN user c"
				+ " ON a.name = c.name"
				+ "	where regDate = curdate() && b.kind = ? && b.gender = ? && a.name = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kind);
			psmt.setString(2, gender);
			psmt.setString(3, name);
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
	
	public NutritionDTO totalNutrition(String name){
		NutritionDTO dto = null;
		sql = "select "
				+ " sum(a.na), sum(a.kcal), sum(a.carbo), sum(a.sugar), sum(a.protein), "
				+ " sum(a.fat), sum(a.tFat), sum(a.sFat), sum(a.chole), a.regDate "
				+ " from nutrition a "
				+ " LEFT OUTER JOIN user b "
				+ " ON a.name = b.name"
				+ " where a.regDate = curdate() && a.name= ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, name);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				dto = new NutritionDTO();
				dto.setKcal(rs.getInt("sum(a.kcal)"));
				dto.setCarbo(rs.getInt("sum(a.carbo)"));
				dto.setNa(rs.getInt("sum(a.na)"));
				dto.setSugar(rs.getInt("sum(a.sugar)"));
				dto.setProtein(rs.getInt("sum(a.protein)"));
				dto.setFat(rs.getInt("sum(a.fat)"));
				dto.settFat(rs.getInt("sum(a.tFat)"));
				dto.setsFat(rs.getInt("sum(a.sFat)"));
				dto.setChole(rs.getInt("sum(a.chole)"));
				dto.setRegDate(rs.getDate("a.regDate"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}		
		return dto;
	}
	
	public void dayAvg(int dayAvg, String name) {
		
		sql ="update nutrition set dayAvg = ? where regdate = curdate() && name = ? ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, dayAvg);
			psmt.setString(2, name);
			psmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close();
		}
	}
	

	/**하루 섭취량과 권장섭취량 비교해 평균치 보기*/
	public NutritionDTO todayGraph(String kind, String gender, String name){
		NutritionDTO dto = null;
		sql = "select"
				+ " sum(a.na)/b.na*100 AS na,"
				+ " sum(a.carbo)/b.carbo*100 AS carbo,"
				+ "	sum(a.sugar)/b.sugar*100 AS sugar,"
				+ "	sum(a.fat)/b.fat*100 AS fat,"
				+ "	sum(a.tFat)/b.tFat*100 AS tFat,"
				+ "	sum(a.sFat)/b.sFat*100 AS sFat,"
				+ "	sum(a.chole)/b.chole*100 AS chole,"
				+ "	sum(a.protein)/b.protein*100 AS protein,"
				+ "	sum(a.kcal)/c.goalKcal*100 AS kcal "
				+ "	from nutrition a"
				+ " JOIN rda b"
				+ " LEFT OUTER JOIN user c"
				+ " ON a.name = c.name"
				+ "	where regDate = curdate() && b.kind = ? && b.gender = ? && a.name = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kind);
			psmt.setString(2, gender);
			psmt.setString(3, name);
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
	
	/**연습!!!!하루 섭취량과 권장섭취량 비교해 평균치 보기*/
	public NutritionDTO todayGraph1(String kind, String gender, String name){
		NutritionDTO dto = null;
		sql = "select"
				+ " sum(a.na)/b.na*100 AS na,"
				+ " sum(a.carbo)/b.carbo*100 AS carbo,"
				+ "	sum(a.sugar)/b.sugar*100 AS sugar,"
				+ "	sum(a.fat)/b.fat*100 AS fat,"
				+ "	sum(a.tFat)/b.tFat*100 AS tFat,"
				+ "	sum(a.sFat)/b.sFat*100 AS sFat,"
				+ "	sum(a.chole)/b.chole*100 AS chole,"
				+ "	sum(a.protein)/b.protein*100 AS protein,"
				+ "	sum(a.kcal)/c.goalKcal*100 AS kcal "
				+ "	from nutrition a"
				+ " JOIN rda b"
				+ " LEFT OUTER JOIN user c"
				+ " ON a.name = c.name"
				+ "	where regDate = curdate() && b.kind = ? && b.gender = ? && a.name = ? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kind);
			psmt.setString(2, gender);
			psmt.setString(3, name);
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
	
	
	/**한 주 섭취량과 권장섭취량 비교해 평균치 보기*/
	public ArrayList<NutritionDTO> weekGraph(String kind, String gender, String name){
		ArrayList<NutritionDTO> res = new ArrayList<NutritionDTO>(); 
		NutritionDTO dto = null;
		sql = "SELECT regdate, "
				+ "SUM(a.na)/b.na*100 AS na, "
				+ "SUM(a.carbo)/b.carbo*100 AS carbo, "
				+ "SUM(a.sugar)/b.sugar*100 AS sugar, "
				+ "SUM(a.fat)/b.fat*100 AS fat, "
				+ "SUM(a.tFat)/b.tFat*100 AS tFat, "
				+ "SUM(a.sFat)/b.sFat*100 AS sFat, "
				+ "SUM(a.chole)/b.chole*100 AS chole, "
				+ "SUM(a.protein)/b.protein*100 AS protein, "
				+ "SUM(a.kcal)/c.goalKcal*100 AS kcal  "
				+ "FROM nutrition a  "
				+ "JOIN rda b "
				+ "LEFT OUTER JOIN user c "
				+ "ON a.name = c.name "
				+ "WHERE regdate BETWEEN CURDATE() - INTERVAL 6 DAY AND CURDATE() AND b.kind = ? && b.gender = ? && a.name = ? "
				+ "GROUP BY regdate ";
		
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, kind);
			psmt.setString(2, gender);
			psmt.setString(3, name);
			rs = psmt.executeQuery();		
			while(rs.next()) {
				dto = new NutritionDTO();
				dto.setRegDateStr(rs.getString("regDate"));
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
	

	public void write(NutritionDTO dto) {
		
		sql = "insert into nutrition(regDate, na, carbo, sugar, fat, tFat, sFat, chole, protein, kcal, name) values (sysdate(),?,?,?,?,?,?,?,?,?,?)";
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
			psmt.setString(10, dto.getName());
			
			
			psmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
	}

	
}
