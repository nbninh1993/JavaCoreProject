package miniProject;

public class DiemHs {
 	private String maSv, maMh, diem;

	public String getMaSv() {
		return maSv;
	}

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getMaMh() {
		return maMh;
	}

	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}

	public DiemHs(String maSv, String maMh, String diem) {
		super();
		this.maSv = maSv;
		this.maMh = maMh;
		this.diem = diem;
	}
	public String showInfo() {
		return maSv + ";" + maMh + ";"+ diem;
		
	}

}
