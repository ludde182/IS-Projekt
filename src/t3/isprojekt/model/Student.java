package t3.isprojekt.model;

public class Student {
	private int sPnr;
	private String sName;
	private String sAdress;
	private int sTfn;

	private Student(int sPnr, String name, String sAdress, int sTfn) {
		setsPnr(sPnr);
		setsName(sName);
		setsAdress(sAdress);
		setsTfn(sTfn);

	}

	public int getsPnr() {
		return sPnr;
	}

	public void setsPnr(int sPnr) {
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

	public int getsTfn() {
		return sTfn;
	}

	public void setsTfn(int sTfn) {
		this.sTfn = sTfn;
	}

}
