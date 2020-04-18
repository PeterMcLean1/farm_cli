package farm.nz.model;

public class Farmer {
	private String name;
	private int age;
	private int skill = 0;

	// TODO implement skill logic training and advantage
	public Farmer() {
	}

	public Farmer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	public int getSkill() {
		return skill;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}

}
