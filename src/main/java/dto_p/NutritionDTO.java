package dto_p;

import java.util.Date;

public class NutritionDTO {
	int kcal, na, carbo, sugar, protein, fat, tFat, sFat, chole, dayAvg;
	public int getDayAvg() {
		return dayAvg;
	}
	public void setDayAvg(int dayAvg) {
		this.dayAvg = dayAvg;
	}
	Date regDate;
	
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
	public int getProtein() {
		return protein;
	}
	public void setProtein(int protein) {
		this.protein = protein;
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
}
