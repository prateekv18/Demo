package Assignment;

public class MarksheetBean {
	private int id;
	private String RollNo;
	private String FName;
	private String Lname;
	private int Phy;
	private int Che;
	private int Math;

	public MarksheetBean() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRollNo() {
		return RollNo;
	}

	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public int getPhy() {
		return Phy;
	}

	public void setPhy(int phy) {
		Phy = phy;
	}

	public int getChe() {
		return Che;
	}

	public void setChe(int che) {
		Che = che;
	}

	public int getMath() {
		return Math;
	}

	public void setMath(int math) {
		Math = math;
	}

}
