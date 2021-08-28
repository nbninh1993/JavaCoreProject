package miniProject;

public class SinhVien {
	private String maSv, hoDem, ten, ngaySinh, gioiTinh;

	public String getMaSv() {
		return maSv;
	}
	public SinhVien() {
		
	};

	public void setMaSv(String maSv) {
		this.maSv = maSv;
	}

	public String getHoDem() {
		return hoDem;
	}

	public void setHoDem(String hoDem) {
		this.hoDem = hoDem;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public SinhVien(String maSv, String hoDem, String ten, String ngaySinh, String gioiTinh) {
		super();
		this.maSv = maSv;
		this.hoDem = hoDem;
		this.ten = ten;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
	}
	
	public String showInfo() {
		return maSv + ";" + hoDem + ";"+ten+";"+ngaySinh+";"+gioiTinh;
		
	}
	

	
	

}
