package t3.isprojekt.model;

public class Student {
	private String sPnr;
	private String sName;
	private String sAdress;
	private String sTfn;

	public Student(String sPnr, String name, String sAdress, String sTfn) {
		setsPnr(sPnr);
		setsName(sName);
		setsAdress(sAdress);
		setsTfn(sTfn);
	}

	public String getsPnr() {
		return sPnr;
	}

	public void setsPnr(String sPnr) {
		this.sPnr = sPnr;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsAdress() {
		return sAdress;
	}

	public void setsAdress(String sAdress) {
		this.sAdress = sAdress;
	}

	public String getsTfn() {
		return sTfn;
	}

	public void setsTfn(String sTfn) {
		this.sTfn = sTfn;
	}

}
