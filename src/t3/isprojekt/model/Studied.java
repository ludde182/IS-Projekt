package t3.isprojekt.model;

public class Studied {

	private String sPnr;
	private String cCode;
	private String sGrade;

	public Studied(String sPnr, String cCode, String sGrade) {
		setsPnr(sPnr);
		setcCode(cCode);
		setsGrade(sGrade);
	}

	public String getsPnr() {
		return sPnr;
	}

	public void setsPnr(String sPnr) {
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
