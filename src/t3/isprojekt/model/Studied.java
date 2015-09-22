package t3.isprojekt.model;

public class Studied {

	private int sPnr;
	private int cCode;
	private int sBetyg;

	private Studied(int sPnr, int cCode, int sBetyg) {
		setsPnr(sPnr);
		setcCode(cCode);
		setsBetyg(sBetyg);

	}

	public int getsPnr() {
		return sPnr;
	}

	public void setsPnr(int sPnr) {
		this.sPnr = sPnr;
	}

	public int getcCode() {
		return cCode;
	}

	public void setcCode(int cCode) {
		this.cCode = cCode;
	}

	public int getsBetyg() {
		return sBetyg;
	}

	public void setsBetyg(int sBetyg) {
		this.sBetyg = sBetyg;
	}

}
