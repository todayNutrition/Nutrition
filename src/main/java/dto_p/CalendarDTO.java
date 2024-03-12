package dto_p;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CalendarDTO {
   Date regDate;
   int kcal,na,carbo,sugar,fat,tFat,sFat,chole,protein,dayavg;
   
	public int getDayavg() {
		return dayavg;
	}
	public void setDayavg(int dayavg) {
		this.dayavg = dayavg;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getKcal() {
		return kcal;
	}
	public void setKcal(int kcal) {
		this.kcal = kcal;
	}
	public int getNa() {
		return na;
	}
	public void setNa(int na) {
		this.na = na;
	}
	public int getCarbo() {
		return carbo;
	}
	public void setCarbo(int carbo) {
		this.carbo = carbo;
	}
	public int getSugar() {
		return sugar;
	}
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}
	public int getFat() {
		return fat;
	}
	public void setFat(int fat) {
		this.fat = fat;
	}
	public int gettFat() {
		return tFat;
	}
	public void settFat(int tFat) {
		this.tFat = tFat;
	}
	public int getsFat() {
		return sFat;
	}
	public void setsFat(int sFat) {
		this.sFat = sFat;
	}
	public int getChole() {
		return chole;
	}
	public void setChole(int chole) {
		this.chole = chole;
	}
	public int getProtein() {
		return protein;
	}
	public void setProtein(int protein) {
		this.protein = protein;
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public String getRegDateStr() {
	   return sdf.format(regDate);
	}
	public void setRegDateStr(String regDate) {
	   try {
	      this.regDate = sdf.parse(regDate);
	   } catch (ParseException e) {
	        
	      e.printStackTrace();
	   }
	}
   
   
   
}