package dto_p;

public class MainDTO {
	String name, height, weight, gender; // 이름, 키, 몸무게, 성별
	int age, goalKcal;	// 나이, 목표칼로리
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGoalKcal() {
		return goalKcal;
	}
	public void setGoalKcal(int goalKcal) {
		this.goalKcal = goalKcal;
	}
	
	
}
