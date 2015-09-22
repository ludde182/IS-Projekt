package t3.isprojekt.model;

public class Studied {

	private int sPnr;
	private String cCode;
	private String sGrade;

	private Studied(int sPnr, String cCode, String sGrade) {
		setsPnr(sPnr);
		setcCode(cCode);
		setsGrade(sGrade);
	}

	public int getsPnr() {
		return sPnr;
	}

	public void setsPnr(int sPnr) {
		this.sPnr = sPnr;
	}

	public String getcCode() {
		return cCode;
	}

	public void setcCode(String cCode) {
		this.cCode = cCode;
	}

	public String getsGrade() {
		return sGrade;
	}

	public void setsGrade(String sGrade) {
		this.sGrade = sGrade;
	}

}
