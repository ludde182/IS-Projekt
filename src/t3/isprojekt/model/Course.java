package t3.isprojekt.model;

public class Course {
	private String cCode;
	private int hp;
	private String cDescription;

	public Course(String cCode, String cDescription, int hp) {
		setcCode(cCode);
		setcDescription(cDescription);
		setHp(hp);
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getcDescription() {
		return cDescription;
	}

	public void setcDescription(String cDescription) {
		this.cDescription = cDescription;
	}

}
