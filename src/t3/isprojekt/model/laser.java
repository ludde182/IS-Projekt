package t3.isprojekt.model;

public class laser {

	private int sPnr;
	private int cCode;

	public laser(int sPnr, int cCode) {
		setsPnr(sPnr);
		setcCode(cCode);

	}

	public int getcCode() {
		return cCode;
	}

	public void setcCode(int cCode) {
		this.cCode = cCode;
	}

	public int getsPnr() {
		return sPnr;
	}

	public void setsPnr(int sPnr) {
		this.sPnr = sPnr;
	}

};
