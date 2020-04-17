package farm.nz.model;

public class Farmer {
	private String name;
	private int age;
	private int skill;

	public Farmer() {
		this.name = "";
		this.age = 0;
		this.skill = 0;
	}

	public Farmer(String name, int age) {
		this.name = name;
		this.age = age;
		this.skill = 0;
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
