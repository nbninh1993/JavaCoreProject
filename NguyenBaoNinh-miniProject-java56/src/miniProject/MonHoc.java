package miniProject;

public class MonHoc {
	private String maMh, tenMh;
	private String heSoD;
	public MonHoc(String maMh, String tenMh, String heSoD) {
		super();
		this.maMh = maMh;
		this.tenMh = tenMh;
		this.heSoD = heSoD;
	}
	public String getMaMh() {
		return maMh;
	}
	public void setMaMh(String maMh) {
		this.maMh = maMh;
	}
	public String getTenMh() {
		return tenMh;
	}
	public void setTenMh(String tenMh) {
		this.tenMh = tenMh;
	}
	public String getHeSoD() {
		return heSoD;
	}
	public void setHeSoD(String heSoD) {
		this.heSoD = heSoD;
	}
	
	public String showInfo() {
		return maMh + ";" + tenMh + ";"+heSoD;
		
	}
	
	
	
}
