package farm.nz.model;

public class Farmer {
	private String name;
	private int age;
	// private int skill;

	public Farmer() {
		this.name = "";
		this.age = 0;
	}

	public Farmer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
