package dao_p;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto_p.CalendarDTO;
import dto_p.MainDTO;
import jakarta.servlet.http.Cookie;



public class CalendarDAO {
   
   Connection con;
   PreparedStatement psmt;
   ResultSet rs;
   String sql;
   
   public CalendarDAO() {
      try {
         Context init = new InitialContext();
         DataSource ds = (DataSource)init.lookup("java:comp/env/nutrition");
         con = ds.getConnection();
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      //close();
   }
   
   void close() {
      if(rs!=null) { try { rs.close();} catch (SQLException e) {}}
      if(psmt!=null) { try { psmt.close();} catch (SQLException e) {}}
      if(con!=null) { try { con.close();} catch (SQLException e) {}}
   }
   
   public ArrayList<CalendarDTO> list() {
	    ArrayList<CalendarDTO> res = new ArrayList<CalendarDTO>();
	    sql = "SELECT regDate, SUM(kcal) AS total_kcal, SUM(na) AS total_na, SUM(carbo) AS total_carbo, SUM(sugar) AS total_sugar, SUM(fat) AS total_fat, " +
	          "SUM(tFat) AS total_tFat, SUM(sFat) AS total_sFat, SUM(chole) AS total_chole, SUM(protein) AS total_protein, dayavg " +
	          "FROM nutrition GROUP BY regDate";

	    try {
	        psmt = con.prepareStatement(sql);
	        rs = psmt.executeQuery();

	        while (rs.next()) {
	            CalendarDTO dto = new CalendarDTO();
	            dto.setRegDateStr(rs.getString("regDate"));
	            dto.setKcal(rs.getInt("total_kcal"));
	            dto.setNa(rs.getInt("total_na"));
	            dto.setCarbo(rs.getInt("total_carbo"));
	            dto.setSugar(rs.getInt("total_sugar"));
	            dto.setFat(rs.getInt("total_fat"));
	            dto.settFat(rs.getInt("total_tFat"));
	            dto.setsFat(rs.getInt("total_sFat"));
	            dto.setChole(rs.getInt("total_chole"));
	            dto.setProtein(rs.getInt("total_protein"));
	            dto.setDayavg(rs.getInt("dayavg"));

	            res.add(dto);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        close();
	    }

	    return res;
	}
   
	/**새로운 user 입장시 기존 사용자 정보 삭제*/
	public CalendarDTO delete(Cookie coo) {
		CalendarDTO dto = null;
		sql = "delete from nutrition";
		
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
	
	/**월 통계 데이터 가져오기*/	
	   public ArrayList<CalendarDTO> monthlist() {
		   ArrayList<CalendarDTO> res = new ArrayList<CalendarDTO>();
		   sql = "SELECT MONTH(regDate) AS month, "
		   		+ "       AVG(na) AS avg_na, "
		   		+ "       AVG(carbo) AS avg_carbo, "
		   		+ "       AVG(sugar) AS avg_sugar, "
		   		+ "       AVG(fat) AS avg_fat, "
		   		+ "       AVG(tFat) AS avg_tFat, "
		   		+ "       AVG(sFat) AS avg_sFat, "
		   		+ "       AVG(chole) AS avg_chole, "
		   		+ "       AVG(protein) AS avg_protein  "
		   		+ "FROM nutrition "
		   		+ "GROUP BY MONTH(regDate)";
		   
		   try {
		        psmt = con.prepareStatement(sql);
		        rs = psmt.executeQuery();

		        while (rs.next()) {
		            CalendarDTO dto = new CalendarDTO();
					/*
					 * dto.setRegDateStr(rs.getString("regDate"));
					 * dto.setKcal(rs.getInt("total_kcal"));
					 */
		            dto.setNa(rs.getInt("avg_na"));
		            dto.setCarbo(rs.getInt("avg_carbo"));
		            dto.setSugar(rs.getInt("avg_sugar"));
		            dto.setFat(rs.getInt("avg_fat"));
		            dto.settFat(rs.getInt("avg_tFat"));
		            dto.setsFat(rs.getInt("avg_sFat"));
		            dto.setChole(rs.getInt("avg_chole"));
		            dto.setProtein(rs.getInt("avg_protein"));

		            res.add(dto);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } finally {
		        close();
		    }

		    return res;
		}

}