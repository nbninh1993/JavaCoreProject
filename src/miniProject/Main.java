package miniProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
	
	
	
	
	
	public static int chon;
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
	
			
		System.out.println("QUAN LY SINH VIEN 1.0.0");		
		try {
			Data.docData();
			main();
			Data.ghiData();
		
		} catch (Exception e) {
			e.getMessage();
			
		}finally {
			try {
				if (Data.bufR != null) Data.bufR.close();
				if (Data.bufW != null) Data.bufW.close();
				if (Data.bufW2 != null) Data.bufW2.close();
				if (Data.bufW3 != null) Data.bufW3.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
		
		
		
	}
	private static void main() {
		do {
			try {
			
				System.out.println("┌─────────────────────────────────────┐");
				System.out.format("│ %-36s│\n","MENU");
				System.out.println("├─────────────────────────────────────┤");
				System.out.format("│ %-36s│\n","1. Cap nhat danh sach");
				System.out.format("│ %-36s│\n","2. Hien thi bang diem");
				System.out.format("│ %-36s│\n","3. Tim kiem");
				System.out.format("│ %-36s│\n","0. Thoat");
				System.out.println("└─────────────────────────────────────┘");
				
				System.out.println("Chon: ");
				chon = sc.nextInt();
				switch (chon) {
				case 1: capNhatDS();	
					break;
				case 2: hienThiBD();	
				break;
				case 3: timKiem();	
				break;
				default:
					break;
				
			} 
			}catch (Exception e) {
				System.out.println("nhap sai!!!");
			}
		} while (chon !=0 );
		
	}
	
	private static void capNhatDS() throws Exception {
		do {
			System.out.println("┌─────────────────────────────────────┐");
			System.out.format("│ %-36s│\n","Cap nhat danh sach");
			System.out.println("├─────────────────────────────────────┤");
			System.out.format("│ %-36s│\n","1. Cap nhat danh sach sinh vien");
			System.out.format("│ %-36s│\n","2. Cap nhat danh sach mon hoc");
			System.out.format("│ %-36s│\n","3. Cap nhat bang diem");
			System.out.format("│ %-36s│\n","0. Tro ve menu truoc");
			System.out.println("└─────────────────────────────────────┘");
			
			System.out.println("Chon: ");
			chon = sc.nextInt();
			switch (chon) {
			case 1: capNhatDSSinhVien();	
				break;
			case 2: capNhatDSMonHoc();	
			break;
			case 3: capnhatBd();	
			break;
			case 0: main();
			default:
				break;
			}
		} while (chon != 0 );
		
		
	}


	private static void capNhatDSSinhVien() throws Exception {
		do {
			System.out.println("┌─────────────────────────────────────┐");
			System.out.format("│ %-36s│\n","Danh sach sinh vien");
			System.out.println("├─────────────────────────────────────┤");
			System.out.format("│ %-36s│\n","1. Them sinh vien");
			System.out.format("│ %-36s│\n","2. Sua thong tin sv");
			System.out.format("│ %-36s│\n","3. Xoa sinh vien");
			System.out.format("│ %-36s│\n","4. Hien thi danh sach");
			System.out.format("│ %-36s│\n","0. Tro ve menu truoc");
			System.out.println("└─────────────────────────────────────┘");
			
			System.out.println("Chon: ");
			chon = sc.nextInt();
			switch (chon) {
			case 1: themSinhVien();	
				break;
			case 2: suaTtSinhVien();	
			break;
			case 3: xoaSinhVien();	
			break;
			case 4: hienThiDanhSach();	
			break;
			case 0: capNhatDS();
				
			default:
				break;
			}
		} while (chon != 0 );
		
	}
	
	
  
	private static void themSinhVien() throws Exception {
		
	
		System.out.println("Nhap thong tin theo dang");
		System.out.println("[ho va ten];[ngay sinh(dd/MM/yyyy];[gioi tinh(Nam/Nu]");
		System.out.println("Vi du: Nguyen Van A;14/06/1996;Nam");
		System.out.println("Nhap exit de quay lai");
		System.out.println("Nhap");
		sc.nextLine();
		String thongTin = sc.nextLine();
		String exit = "exit";
	
		if(thongTin.equals(exit)) {
			capNhatDSSinhVien();
		}
		else {
		String maSvNew = "SV"+String.format("%05d", (Integer.parseInt(Data.maSv.substring(2))+1)); 
		String partThongTin [] = thongTin.split(";");
		String name = partThongTin[0];
		String ngaySinhNew = partThongTin[1];
		String gioiTinhNew = partThongTin[2];
		int end  = name.lastIndexOf(" ");
		String hoMoi = name.substring(0, end);
		String tenmoi = name.substring(end+1);
		SinhVien svMoi = new SinhVien(maSvNew, hoMoi, tenmoi, ngaySinhNew, gioiTinhNew);
		Data.listSv.add(svMoi);
		System.out.println("Them thanh cong");
		System.out.println("[ "+maSvNew+" "+hoMoi+" "+tenmoi+" "+ngaySinhNew+" "+gioiTinhNew+ " ]\n");
		Data.maSv = maSvNew;
		}
	}
	
	

	
	private static void suaTtSinhVien() {
		sc.nextLine();
		System.out.println("nhap ma sinh vien muon sua");
		System.out.println("Nhap: ");
		String maSvSua = sc.nextLine();
		int count = 0;
		for (SinhVien sv : Data.listSv) {
			if (sv.getMaSv().equals(maSvSua)) {
				count++;
				System.out.println("Tim thay sinh vien");
				System.out.println("[ "+sv.getMaSv()+" "+sv.getHoDem()+" "+sv.getTen()+" "+sv.getNgaySinh()+" "+sv.getGioiTinh()+ " ]\n");
				System.out.println("Nhap lai thong tin sinh vien theo dinh dang");
				System.out.println("[ho va ten];[ngay sinh(dd/MM/yyyy];[gioi tinh(Nam/Nu]");
				System.out.println("Neu khong muon sua muc nao thi bo trong muc do");
				System.out.println("vi du: Nguyen van A;;Nam");
				String thongTin = sc.nextLine();
				String partThongTin [] = thongTin.split(";");
				if (partThongTin.length == 1) {
					String name = partThongTin[0];
					int end  = name.lastIndexOf(" ");
					String hoMoi = name.substring(0, end);
					String tenmoi = name.substring(end+1);
					sv.setTen(tenmoi);
					sv.setHoDem(hoMoi);
					System.out.println("Da sua thanh cong");
					System.out.println("[ "+sv.getMaSv()+" "+sv.getHoDem()+" "+sv.getTen()+" "+sv.getNgaySinh()+" "+sv.getGioiTinh()+ " ]\n");
				}
				else {
					if(partThongTin[0] == "") partThongTin[0] = null;
					else {
						String name = partThongTin[0];
						int end  = name.lastIndexOf(" ");
						String hoMoi = name.substring(0, end);
						String tenmoi = name.substring(end+1);
						sv.setTen(tenmoi);
						sv.setHoDem(hoMoi);
					}
					
					if (partThongTin[1] == "") partThongTin[1] = null;
					else sv.setNgaySinh(partThongTin[1]);
					if (partThongTin[2] == "") partThongTin[2] = null;
					else sv.setGioiTinh(partThongTin[2]);	
					System.out.println("Da sua thanh cong");
					System.out.println("[ "+sv.getMaSv()+" "+sv.getHoDem()+" "+sv.getTen()+" "+sv.getNgaySinh()+" "+sv.getGioiTinh()+ " ]\n");
					break;
				}
			}
		}
	if (count == 0) System.out.println("Khong co thong tin sinh vien!");
		
	}
	private static void xoaSinhVien() {
		System.out.println("Nhap ma sinh vien muon xoa: ");
		sc.nextLine();
		String maSvXoa = sc.nextLine();
		
		int key = 0;
		
		for (SinhVien sv : Data.listSv) {
			if(sv.getMaSv().equals(maSvXoa)) {
				key = 1; 
				System.out.println("Tim thay sinh vien: ");
				System.out.println("[ "+sv.getMaSv()+" "+sv.getHoDem()+" "+sv.getTen()+" "+sv.getNgaySinh()+" "+sv.getGioiTinh()+" ]");		
				for (DiemHs diem : Data.listDiem) {
				if(diem.getMaSv().equals(maSvXoa)) {
					System.out.println("Sinh vien nay da co diem, khong the xoa\n");
					key = 2;
					break;
				}
					
			}
		}						
		}
		if (key == 0) {
			System.out.println("Khong tim thay sinh vien");
		} 
		if (key == 1) {
			System.out.println("Ban co chac muon xoa (c/k)");
			String xoa = sc.nextLine();
			if (xoa.equals("c")) {
				for (int i = 0; i < Data.listSv.size(); i++) {
					if(Data.listSv.get(i).getMaSv().equals(maSvXoa)) {
						Data.listSv.remove(i);
					}
				}
			}
			System.out.println("Xoa thanh cong!");
		}
	}
	private static void showHienThiDanhSach() {
		System.out.println("------------------------------trang   "+trang+"/"+soTrang+"--------------------------------");
		System.out.println("┌────────┬─────────────────────────┬───────────┬───────────┬───────────┐");
		 System.out.format("│ %-5s  │ %-22s  │ %-9s │ %-4s │ %s │\n", "Ma", "Ho dem","Ten", "Ngay sinh", "Gioi tinh");
		System.out.println("├────────┼─────────────────────────┼───────────┼───────────┼───────────┤"); 
		for (int i = start; i < end; i++) {
		 System.out.format("│ %s│ %-24s│ %-10s│ %-5s│ %-10s│\n", Data.listSv.get(i).getMaSv(), Data.listSv.get(i).getHoDem(), Data.listSv.get(i).getTen(), Data.listSv.get(i).getNgaySinh(), Data.listSv.get(i).getGioiTinh());
		}
		System.out.println("└────────┴─────────────────────────┴───────────┴───────────┴───────────┘");
		System.out.println("------------------------------trang   "+trang+"/"+soTrang+"--------------------------------");
	}
	
	
	private static void hienThiDanhSach() {
		Comparator<SinhVien> comp = new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				Locale vn = new Locale("vi");
				Collator vncol = Collator.getInstance(vn);
				return vncol.compare(o1.getTen(),o2.getTen());
			}
		
		};
		Data.listSv.sort(comp);
		end = 30;
		start = 0;
		max = Data.listSv.size();
		soTrang = max/30 + 1;
		if (max % 30 == 0) soTrang = max/30;
		trang = start/end +1;
		if (end > max) end = max;
		System.out.println("--------------------------DANH SACH SINH VIEN-------------------------------");
		showHienThiDanhSach();
		
		int key = -1;
		do {
			System.out.println("\n1. Xem trang tiep theo");
			System.out.println("2. Tro lai trang truoc");
			System.out.println("3. Den trang cuoi");
			System.out.println("4. Den trang dau tien");
			System.out.println("5. Xem trang cu the");
			System.out.println("0. Tro ve menu truoc");
			System.out.println("\nChon: ");
			key = sc.nextInt();
			switch (key) {
			case 1:
				end += 30;
				start +=30;
				trang++;
				if (trang >= soTrang) {
					start = (soTrang - 1)*30;
					end = max;
					trang = soTrang;
				}
				showHienThiDanhSach();
				break;
			case 2:
				end -= 30;
				start -= 30;
				trang--;
				if (start < 0) {
					start = 0;
					end = 30;
					if (end > max) end = max;
					trang = 1;
				}
				showHienThiDanhSach();
				break;
			case 3:
				start = (soTrang - 1)*30;
				trang = soTrang;
				end = max;
				showHienThiDanhSach();
				break;	
			case 4:
				start = 0;
				end = 30;
				if (end > max) end = max;
				trang = 1;
				showHienThiDanhSach();
				break;
			case 5:
				System.out.println("Nhap trang cu the");
				int nhap = sc.nextInt();
				start = (nhap-1)*30;
				end = 30*nhap;
				trang = nhap;
				if (nhap >= soTrang) {
					start = ((soTrang-1)*30);
					end = max;
					trang = soTrang;
				}
				showHienThiDanhSach();
				break;	

			default:
				break;		
			}			
		} while (key != 0);
		
		Comparator<SinhVien> comp2 = new Comparator<SinhVien>() {

			@Override
			public int compare(SinhVien o1, SinhVien o2) {
				Locale vn = new Locale("vi");
				Collator vncol = Collator.getInstance(vn);
				return vncol.compare(o1.getMaSv(),o2.getMaSv());
			}
		
		};
		Data.listSv.sort(comp2);	
		
		
	}
	private static void capNhatDSMonHoc() throws Exception {	
		do {
			System.out.println("┌─────────────────────────────────────┐");
			System.out.format("│ %-36s│\n","Danh sach mon hoc");
			System.out.println("├─────────────────────────────────────┤");
			System.out.format("│ %-36s│\n","1. Them mon hoc");
			System.out.format("│ %-36s│\n","2. Sua thong tin mon hoc");
			System.out.format("│ %-36s│\n","3. Xoa mon hoc");
			System.out.format("│ %-36s│\n","4. Hien thi danh sach mon hoc");
			System.out.format("│ %-36s│\n","0. Tro ve menu truoc");
			System.out.println("└─────────────────────────────────────┘");
			
			System.out.println("Chon: ");
			chon = sc.nextInt();
			switch (chon) {
			case 1: themMonHoc();	
				break;
			case 2: suaTtMonHoc();	
			break;
			case 3: xoaMonHoc();	
			break;
			case 4: hienThiDanhSachMonHoc();	
			break;
			case 0: capNhatDS();
			break;	
			default:
				break;
			}
		} while (chon != 0 );
		
		
	}
	private static void showHienThiDanhSachMonHoc() {
		Comparator<MonHoc> comp = new Comparator<MonHoc>() {

			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTenMh().compareTo(o2.getTenMh());
			}
		
		};
		Data.listMh.sort(comp);
		
		System.out.println("--------------------trang   "+trang+"/"+soTrang+"----------------------");
		System.out.println("┌─────┬─────────────────────────────────────┬───────┐");
		 System.out.format("│ %-3s │ %25s           │ %s │\n", "Ma", "Ten mon hoc","He so");
		System.out.println("├─────┼─────────────────────────────────────┼───────┤"); 
		for (int i = start; i < Data.listMh.size(); i++) {
			System.out.format("│ %s │ %35s │%6s │\n", Data.listMh.get(i).getMaMh(), Data.listMh.get(i).getTenMh(), Data.listMh.get(i).getHeSoD());
		}
		System.out.println("└─────┴─────────────────────────────────────┴───────┘");
		System.out.println("--------------------trang   "+trang+"/"+soTrang+"----------------------");
	}
	private static void hienThiDanhSachMonHoc() {
		end = 30;
		start = 0;
		max = Data.listMh.size();
		soTrang = max/30 + 1;
		if (max % 30 == 0) soTrang = max/30;
		trang = start/end +1;
		if (end > max) end = max;
		System.out.println("-------------------DANH SACH MON HOC-----------------------");
		showHienThiDanhSachMonHoc();
		
		int key = -1;
		do {
			System.out.println("\n1. Xem trang tiep theo");
			System.out.println("2. Tro lai trang truoc");
			System.out.println("3. Den trang cuoi");
			System.out.println("4. Den trang dau tien");
			System.out.println("5. Xem trang cu the");
			System.out.println("0. Tro ve menu truoc");
			System.out.println("\nChon: ");
			key = sc.nextInt();
			switch (key) {
			case 1:
				end += 30;
				start +=30;
				trang++;
				if (trang >= soTrang) {
					start = (soTrang - 1)*30;
					end = max;
					trang = soTrang;
				}
				showHienThiDanhSachMonHoc();
				break;
			case 2:
				end -= 30;
				start -= 30;
				trang--;
				if (start < 0) {
					start = 0;
					end = 30;
					if (end > max) end = max;
					trang = 1;
				}
				showHienThiDanhSachMonHoc();
				break;
			case 3:
				start = (soTrang - 1)*30;
				trang = soTrang;
				end = max;
				showHienThiDanhSachMonHoc();
				break;	
			case 4:
				start = 0;
				end = 30;
				if (end > max) end = max;
				trang = 1;
				showHienThiDanhSachMonHoc();
				break;
			case 5:
				System.out.println("Nhap trang cu the");
				int nhap = sc.nextInt();
				start = (nhap-1)*30;
				end = 30*nhap;
				trang = nhap;
				if (nhap >= soTrang) {
					start = ((soTrang-1)*30);
					end = max;
					trang = soTrang;
				}
				showHienThiDanhSachMonHoc();
				break;	

			default:
				break;
			}
		} while (key != 0);
		
		
		
		
		
	}
	private static void xoaMonHoc() {
		// TODO Auto-generated method stub
		
	}
	private static void suaTtMonHoc() {
		// TODO Auto-generated method stub
		
	}
	private static void themMonHoc() {
		// TODO Auto-generated method stub
		
	}
	private static void capnhatBd() {
		// TODO Auto-generated method stub
		
	}
	

	

	private static void hienThiBD() {
		do {	
				System.out.println("┌─────────────────────────────────────┐");
				System.out.format("│ %-36s│\n","BANG DIEM");
				System.out.println("├─────────────────────────────────────┤");
				System.out.format("│ %-36s│\n","1. Bang diem theo ds sinh vien");
				System.out.format("│ %-36s│\n","2. Bang diem theo ds mon hoc");
				System.out.format("│ %-36s│\n","0. Tro ve Menu truoc");	
				System.out.println("└─────────────────────────────────────┘");
				System.out.println("Chon: ");
				chon = sc.nextInt();
				switch (chon) {
				case 1: bangDiemTheoSinhVien();	
					break;
				case 2: bangdiemTheoMonHoc();	
				break;
				case 0: main();
				break;
				
				default:
					break;
		} 
		}
		while (chon !=0 );
		
	}
	
	static int end, start, soTrang, trang, max;
	private static void showBangDiemTheoSinhVien() {
		
		
		
		System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
		for (int i = start; i < end; i++) {
			String fullName = Data.listSv.get(i).getHoDem()+" "+Data.listSv.get(i).getTen();
			System.out.println("┌─────────────────────────────────────┐");
			System.out.format("│%s %27s  │\n", Data.listSv.get(i).getMaSv(), fullName);
			System.out.format("│DTK: %30.2f  │\n", DTK(Data.listSv.get(i).getMaSv()));
			System.out.println("├─────────────────────────────────────┤");
			String chuaCoDiem = "Chua co diem";
			if (DTK(Data.listSv.get(i).getMaSv()) == 0.00) System.out.format("│%35s  │\n", chuaCoDiem);
			else {
				for (DiemHs diem : Data.listDiem) {
					if(Data.listSv.get(i).getMaSv().equals(diem.getMaSv())) {
						System.out.format("│%s", diem.getMaMh());
							for (MonHoc mh : Data.listMh) {
							if(diem.getMaMh().equals(mh.getMaMh())) {
								System.out.format("%27s", mh.getTenMh());
								break;
							}			
						}
					System.out.format(" %-5s │\n", diem.getDiem());		
					}
					
				}
			}
			System.out.println("└─────────────────────────────────────┘");
			
			System.out.println("\n");
		
		}
		System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
		
	}
	
	private static void bangDiemTheoSinhVien() {
		end = 30;
		start = 0;
		max = Data.listSv.size();
		soTrang = max/30 + 1;
		if (max % 30 == 0) soTrang = max/30;
		trang = start/end +1;
		if (end > max) end = max;
		System.out.println("-------------------DANH SACH SINH VIEN------------------------");
		showBangDiemTheoSinhVien();
		
		int key = -1;
		do {
			System.out.println("\n1. Xem trang tiep theo");
			System.out.println("2. Tro lai trang truoc");
			System.out.println("3. Den trang cuoi");
			System.out.println("4. Den trang dau tien");
			System.out.println("5. Xem trang cu the");
			System.out.println("0. Tro ve menu truoc");
			System.out.println("\nChon: ");
			key = sc.nextInt();
			switch (key) {
			case 1:
				end += 30;
				start +=30;
				trang++;
				if (trang >= soTrang) {
					start = (soTrang - 1)*30;
					end = max;
					trang = soTrang;
				}
				showBangDiemTheoSinhVien();
				break;
			case 2:
				end -= 30;
				start -= 30;
				trang--;
				if (start < 0) {
					start = 0;
					end = 30;
					if (end > max) end = max;
					trang = 1;
				}
				showBangDiemTheoSinhVien();
				break;
			case 3:
				start = (soTrang - 1)*30;
				trang = soTrang;
				end = max;
				showBangDiemTheoSinhVien();
				break;	
			case 4:
				start = 0;
				end = 30;
				if (end > max) end = max;
				trang = 1;
				showBangDiemTheoSinhVien();
				break;
			case 5:
				System.out.println("Nhap trang cu the");
				int nhap = sc.nextInt();
				start = (nhap-1)*30;
				end = 30*nhap;
				trang = nhap;
				if (nhap >= soTrang) {
					start = ((soTrang-1)*30);
					end = max;
					trang = soTrang;
				}
				showBangDiemTheoSinhVien();
				break;	

			default:
				break;
			}						
		} while (key != 0);
		
		
	}
	
	private static double DTK(String DTKmaSv) {
		double sum = 0;
		double count = 0;
		double DTK = 0;
		for (DiemHs diem : Data.listDiem) {
			if(DTKmaSv.equals(diem.getMaSv())) {
					for (MonHoc mh : Data.listMh) {
					if(diem.getMaMh().equals(mh.getMaMh())) {
						sum += Double.valueOf(diem.getDiem())*Double.valueOf(mh.getHeSoD());
						count += Double.valueOf(mh.getHeSoD());
						break;
					}			
				}
			}
			
		}
		
	if(count == 0) {
		return 0;
	}
	else {
		return DTK = sum/count;
		
	}	
	
	}
	private static void bangdiemTheoMonHoc() {
		// TODO Auto-generated method stub
		
	}
	
	
	private static void timKiem() {
		do {
			System.out.println("┌─────────────────────────────────────┐");
			System.out.format("│ %-36s│\n","TIM KIEM");
			System.out.println("├─────────────────────────────────────┤");
			System.out.format("│ %-36s│\n","1. Tim kiem theo ma sinh vien");
			System.out.format("│ %-36s│\n","2. Tim kiem theo ten sinh vien");	
			System.out.format("│ %-36s│\n","0. Tro ve menu truoc");
			System.out.println("└─────────────────────────────────────┘");
			System.out.println("Chon: ");
			
			chon = sc.nextInt();
			switch (chon) {
			case 1: timKiemTheoMaSv();	
				break;
			case 2: timKiemTheoTen();	
			break;	
			case 0: main();
			default:
				break;
			}
		} while (chon != 0 );
		
	}
		
	private static void timKiemTheoMaSv() {
		System.out.println("Nhap ma sinhvien");
		sc.nextLine();
		String timKiemMaSv = sc.nextLine();
		int key = 0;
		for (int i = 0; i < Data.listSv.size(); i++) {
			if(Data.listSv.get(i).getMaSv().equals(timKiemMaSv)) {
				key++;
				String fullName = Data.listSv.get(i).getHoDem()+" "+Data.listSv.get(i).getTen();
				System.out.println("┌─────────────────────────────────────┐");
				System.out.format("│%s %27s  │\n", Data.listSv.get(i).getMaSv(), fullName);
				System.out.format("│DTK: %30.2f  │\n", DTK(Data.listSv.get(i).getMaSv()));
				System.out.println("├─────────────────────────────────────┤");
				String chuaCoDiem = "Chua co diem";
				if (DTK(Data.listSv.get(i).getMaSv()) == 0.00) System.out.format("│%35s  │\n", chuaCoDiem);
				else {
					for (DiemHs diem : Data.listDiem) {
						if(Data.listSv.get(i).getMaSv().equals(diem.getMaSv())) {
							System.out.format("│%s", diem.getMaMh());
								for (MonHoc mh : Data.listMh) {
								if(diem.getMaMh().equals(mh.getMaMh())) {
									System.out.format("%27s", mh.getTenMh());
									break;
								}			
							}
						System.out.format(" %-5s │\n", diem.getDiem());		
						}
						
					}
				}
				System.out.println("└─────────────────────────────────────┘");
				
				System.out.println("\n");
			}

		}
	if (key == 0) {
		System.out.println("khong tim thay sinh vien "+timKiemMaSv);
	}
		
	}
	private static void timKiemTheoTen() {
			

		System.out.println("Nhap ten sinh vien: ");
		sc.nextLine();
		String timKiemTenSv = sc.nextLine().toLowerCase();
		ArrayList<SinhVien> listSearch = new ArrayList<>();
		for (SinhVien sv : Data.listSv) {
		String fullName = (sv.getHoDem()+" "+sv.getTen()).toLowerCase();
		if (fullName.contains(timKiemTenSv)) {
				listSearch.add(sv);
			}
			
		}	
		end = 30;
		start = 0;
		max = listSearch.size();
		soTrang = max/30 + 1;
		if (max % 30 == 0) soTrang = max/30;
		trang = start/end +1;
		if (end > max) end = max;
		System.out.println("-------------------KET QUA TIM KIEM------------------------");
		System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
		System.out.println("┌────────┬─────────────────────────┬───────────┬───────────┬───────────┐");
		 System.out.format("│ %-5s  │ %-22s  │ %-9s │ %-4s │ %s │\n", "Ma", "Ho dem","Ten", "Ngay sinh", "Gioi tinh");
		System.out.println("├────────┼─────────────────────────┼───────────┼───────────┼───────────┤"); 
		for (int i = start; i < end; i++) {
				 System.out.format("│ %s│ %-24s│ %-10s│ %-5s│ %-10s│\n", listSearch.get(i).getMaSv(), listSearch.get(i).getHoDem(), listSearch.get(i).getTen(), listSearch.get(i).getNgaySinh(), listSearch.get(i).getGioiTinh());	
		}
		System.out.println("└────────┴─────────────────────────┴───────────┴───────────┴───────────┘");
		System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
		
		
		
		int key = -1;
		do {
			System.out.println("\n1. Xem trang tiep theo");
			System.out.println("2. Tro lai trang truoc");
			System.out.println("3. Den trang cuoi");
			System.out.println("4. Den trang dau tien");
			System.out.println("5. Xem trang cu the");
			System.out.println("6. Xem chi tiet bang diem");
			System.out.println("0. Tro ve menu truoc");
			System.out.println("\nChon: ");
			key = sc.nextInt();
			switch (key) {
			case 1:
				end += 30;
				start +=30;
				trang++;
				if (trang >= soTrang) {
					start = (soTrang - 1)*30;
					end = max;
					trang = soTrang;
				}
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				System.out.println("┌────────┬─────────────────────────┬───────────┬───────────┬───────────┐");
				 System.out.format("│ %-5s  │ %-22s  │ %-9s │ %-4s │ %s │\n", "Ma", "Ho dem","Ten", "Ngay sinh", "Gioi tinh");
				System.out.println("├────────┼─────────────────────────┼───────────┼───────────┼───────────┤"); 
				for (int i = start; i < end; i++) {
						 System.out.format("│ %s│ %-24s│ %-10s│ %-5s│ %-10s│\n", listSearch.get(i).getMaSv(), listSearch.get(i).getHoDem(), listSearch.get(i).getTen(), listSearch.get(i).getNgaySinh(), listSearch.get(i).getGioiTinh());	
				}
				System.out.println("└────────┴─────────────────────────┴───────────┴───────────┴───────────┘");
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				break;
			case 2:
				end -= 30;
				start -= 30;
				trang--;
				if (start < 0) {
					start = 0;
					end = 30;
					if (end > max) end = max;
					trang = 1;
				}
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				System.out.println("┌────────┬─────────────────────────┬───────────┬───────────┬───────────┐");
				 System.out.format("│ %-5s  │ %-22s  │ %-9s │ %-4s │ %s │\n", "Ma", "Ho dem","Ten", "Ngay sinh", "Gioi tinh");
				System.out.println("├────────┼─────────────────────────┼───────────┼───────────┼───────────┤"); 
				for (int i = start; i < end; i++) {
						 System.out.format("│ %s│ %-24s│ %-10s│ %-5s│ %-10s│\n", listSearch.get(i).getMaSv(), listSearch.get(i).getHoDem(), listSearch.get(i).getTen(), listSearch.get(i).getNgaySinh(), listSearch.get(i).getGioiTinh());	
				}
				System.out.println("└────────┴─────────────────────────┴───────────┴───────────┴───────────┘");
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				break;
			case 3:
				start = (soTrang - 1)*30;
				trang = soTrang;
				end = max;
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				System.out.println("┌────────┬─────────────────────────┬───────────┬───────────┬───────────┐");
				 System.out.format("│ %-5s  │ %-22s  │ %-9s │ %-4s │ %s │\n", "Ma", "Ho dem","Ten", "Ngay sinh", "Gioi tinh");
				System.out.println("├────────┼─────────────────────────┼───────────┼───────────┼───────────┤"); 
				for (int i = start; i < end; i++) {
						 System.out.format("│ %s│ %-24s│ %-10s│ %-5s│ %-10s│\n", listSearch.get(i).getMaSv(), listSearch.get(i).getHoDem(), listSearch.get(i).getTen(), listSearch.get(i).getNgaySinh(), listSearch.get(i).getGioiTinh());	
				}
				System.out.println("└────────┴─────────────────────────┴───────────┴───────────┴───────────┘");
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				break;	
			case 4:
				start = 0;
				end = 30;
				if (end > max) end = max;
				trang = 1;
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				System.out.println("┌────────┬─────────────────────────┬───────────┬───────────┬───────────┐");
				 System.out.format("│ %-5s  │ %-22s  │ %-9s │ %-4s │ %s │\n", "Ma", "Ho dem","Ten", "Ngay sinh", "Gioi tinh");
				System.out.println("├────────┼─────────────────────────┼───────────┼───────────┼───────────┤"); 
				for (int i = start; i < end; i++) {
						 System.out.format("│ %s│ %-24s│ %-10s│ %-5s│ %-10s│\n", listSearch.get(i).getMaSv(), listSearch.get(i).getHoDem(), listSearch.get(i).getTen(), listSearch.get(i).getNgaySinh(), listSearch.get(i).getGioiTinh());	
				}
				System.out.println("└────────┴─────────────────────────┴───────────┴───────────┴───────────┘");
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				break;
			case 5:
				System.out.println("Nhap trang cu the");
				int nhap = sc.nextInt();
				start = (nhap-1)*30;
				end = 30*nhap;
				trang = nhap;
				if (nhap >= soTrang) {
					start = ((soTrang-1)*30);
					end = max;
					trang = soTrang;
				}
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				System.out.println("┌────────┬─────────────────────────┬───────────┬───────────┬───────────┐");
				 System.out.format("│ %-5s  │ %-22s  │ %-9s │ %-4s │ %s │\n", "Ma", "Ho dem","Ten", "Ngay sinh", "Gioi tinh");
				System.out.println("├────────┼─────────────────────────┼───────────┼───────────┼───────────┤"); 
				for (int i = start; i < end; i++) {
						 System.out.format("│ %s│ %-24s│ %-10s│ %-5s│ %-10s│\n", listSearch.get(i).getMaSv(), listSearch.get(i).getHoDem(), listSearch.get(i).getTen(), listSearch.get(i).getNgaySinh(), listSearch.get(i).getGioiTinh());	
				}
				System.out.println("└────────┴─────────────────────────┴───────────┴───────────┴───────────┘");
				System.out.println("--------------------"+trang+"/"+soTrang+"---------------------");
				break;
			case 6:
				if(end == 1) {
					String fullName = listSearch.get(0).getHoDem()+" "+Data.listSv.get(0).getTen();
					System.out.println("┌─────────────────────────────────────┐");
					System.out.format("│%s %27s  │\n", listSearch.get(0).getMaSv(), fullName);
					System.out.format("│DTK: %30.2f  │\n", DTK(listSearch.get(0).getMaSv()));
					System.out.println("├─────────────────────────────────────┤");
					String chuaCoDiem = "Chua co diem";
					if (DTK(listSearch.get(0).getMaSv()) == 0.00) System.out.format("│%35s  │\n", chuaCoDiem);
					else {
						for (DiemHs diem : Data.listDiem) {
							if(listSearch.get(0).getMaSv().equals(diem.getMaSv())) {
								System.out.format("│%s", diem.getMaMh());
									for (MonHoc mh : Data.listMh) {
									if(diem.getMaMh().equals(mh.getMaMh())) {
										System.out.format("%27s", mh.getTenMh());
										break;
									}			
								}
							System.out.format(" %-5s │\n", diem.getDiem());		
							}
							
						}
					}
					System.out.println("└─────────────────────────────────────┘");
					
					System.out.println("\n");
				}
				else timKiemTheoMaSv();
				
				int back = 0;
				do {
					System.out.println("nhap ... de quay lai");
					String backStr = sc.nextLine();
					if(backStr.equals("...")) {
						back = 1;
					}
				} while (back != 1);
				
				
				
			default:
				break;
			}						
		} while (key != 0);
				
	}


	private static void thoat() {
		// TODO Auto-generated method stub
		
	}

	

	
}
