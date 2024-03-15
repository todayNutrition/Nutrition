package dto_p;

public class MainDTO {
	String name, gender, kind; // 이름, 키, 몸무게, 성별, 구분
	int age, goalKcal;	// 나이, 목표칼로리
	double height, weight;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
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
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	
}
