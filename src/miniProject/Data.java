package miniProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.util.ArrayList;

public class Data {
	
	 static String dataPath = "C:\\Users\\Ninh\\eclipse-workspace\\NguyenBaoNinh-miniProject-java56\\data";
	 static ArrayList<SinhVien> listSv = new ArrayList<>();
	 static ArrayList<MonHoc> listMh = new ArrayList<>();
	 static ArrayList<DiemHs> listDiem = new ArrayList<>();
 	 static BufferedReader bufR = null;
	 static BufferedWriter bufW = null;
	 static BufferedWriter bufW2 = null;
	 static BufferedWriter bufW3 = null;
	 static String maSv = null;
	 
	 public static void docData () throws IOException {
		 docDuLieuSV();
		  }

	public static void ghiData() throws IOException {
		 ghiDuLieuSV();
		 ghiDuLieuDiem();
		 ghiDuLieuMonHoc();
	 }
	 

	
	private static void ghiDuLieuSV() throws IOException {
		 bufW = new BufferedWriter(new FileWriter(dataPath +"\\sinhvien.txt"));;
		 bufW.write("#Ma - Ho dem - Ten - Ngay sinh - Gioi tinh");
		 bufW.newLine();
		 for (SinhVien sinhVien : listSv) {
			bufW.write(sinhVien.showInfo());
			bufW.newLine();
		}	 
	
	}
	
	private static void ghiDuLieuDiem() throws IOException {
		 bufW2 = new BufferedWriter(new FileWriter(dataPath +"\\diem.txt"));;
		 bufW2.write("# ma sinh vien; ma mon hoc; diem");
		 bufW2.newLine();
		 for (DiemHs diem : listDiem) {
			bufW2.write(diem.showInfo());
			bufW2.newLine();	
		 } 
	
	}
	
	private static void ghiDuLieuMonHoc() throws IOException {
		 bufW3 = new BufferedWriter(new FileWriter(dataPath +"\\monhoc_en.txt"));;
		 bufW3.write("#Ma ; Ten mon hoc; he so diem");
		 bufW3.newLine();
		 for (MonHoc mh : listMh) {
			bufW3.write(mh.showInfo());
			bufW3.newLine();	
		 }
	
	}
	
	
	
	
	
	


	private static void docDuLieuSV() throws IOException {
		String line;	
		bufR = new BufferedReader(new FileReader(dataPath +"\\sinhvien.txt"));
		while ((line = bufR.readLine()) != null) {
			if(line.startsWith("#")) continue;
			String [] partLine = line.split(";");
			maSv = partLine[0];
			String hoDem = partLine[1];
			String ten = partLine[2];
			String ngaySinh = partLine[3];
			String gioiTinh = partLine[4];
			SinhVien sv = new SinhVien(maSv, hoDem, ten, ngaySinh, gioiTinh);
			listSv.add(sv);
			
		}
		
		bufR = new BufferedReader(new FileReader(dataPath+"\\diem.txt"));
		while((line = bufR.readLine()) !=  null) {
			if(line.startsWith("#")) continue;
			String partLine [] = line.split(";");
			String maSv = partLine[0];
			String tenMh = partLine[1];
			String diem = partLine[2];
			DiemHs diemHs = new DiemHs(maSv, tenMh, diem);
			listDiem.add(diemHs);

		}
		
		
		bufR = new BufferedReader(new FileReader(dataPath +"\\monhoc_en.txt"));
		while ((line = bufR.readLine()) != null) {
			if(line.startsWith("#")) continue;
			String [] partLine = line.split(";");
			String maMh = partLine[0];
			String tenMh = partLine[1];
			String heSoD = partLine[2];
			MonHoc mh = new MonHoc(maMh, tenMh, heSoD);
			listMh.add(mh);
		}
		
		
	}
	

}
