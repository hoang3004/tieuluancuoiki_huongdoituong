package oo.kiemtracuoiki;


import static java.util.Collections.sort;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class DanhSachQuanLi {
    private static final int Comparator = 0;
    private ArrayList<HangHoa> list ;
    private Scanner input = new Scanner(System.in);

    DanhSachQuanLi(){
        list = new ArrayList<HangHoa>(30);
    }
    public ArrayList<HangHoa> getList() {
        return list;
    }
    public void setList(ArrayList<HangHoa> list) {
        this.list = list;
    }
    //CHỨC NĂNG THÊM HÀNG HÓA TRỰC TIẾP
    public void themHangHoaTrucTiep(HangHoa x) throws ParseException{
        int count = 0 ;
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa sp = list.get(i);
            if(sp.getMaHang().equalsIgnoreCase(x.getMaHang()) || sp.getMaHang().equalsIgnoreCase("HTP-") ||sp.getMaHang().equalsIgnoreCase("HSS-") || sp.getMaHang().equalsIgnoreCase("HDM-") ){
                System.out.println("HANG HOA BI TRUNG !!!!  VUI LONG NHAP LAI !!!!");
                count++ ;
                themHangHoa();
                break;
            }
        }
        if(count == 0){
            list.add(x);
        }
    }
    //CHỨC NĂNG THÊM HÀNG HÓA BẰNG DỮ LIỆU NHẬP TỪ BÀN PHÍM
    public void themHangHoa() throws ParseException {
        System.out.println("=============MENU=============");
        System.out.println("| 1.Hang thuc pham           |");
        System.out.println("| 2.Hang sanh su             |");
        System.out.println("| 3.Hang dien may            |");
		System.out.println("| 0.Quay lai                 |");
        System.out.println("=============MENU=============");
        System.out.print("Nhap lua chon loai hang hoa : ");
    	int luaChon = input.nextInt();
        HangHoa x;
        switch(luaChon){
            case 1 : {
				//HÀNG THỰC PHẨM
				System.out.println("\n\n\tNHAP THONG TIN HANG THUC PHAM NHAP KHO");
                System.out.print("Nhap ma hang hoa : ");
				input.nextLine();
				String maHH = input.nextLine();
				System.out.print("Nhap ten hang hoa (khong dau) : ");
				String tenHH = input.nextLine();
				System.out.print("Nhap so luong ton kho : ");
				int soLuongTonKho = input.nextInt();
				System.out.print("Nhap don gia (vnd) : ");
				int donGia = input.nextInt();				
				System.out.print("Nhap ngay nhap kho (dd/mm/yyyy) : ");
                input.nextLine();
				String ngayNK = input.nextLine();
                System.out.print("Nhap ngay het han (dd/mm/yyyy) : ");
				String ngayHH = input.nextLine();
				x = new HangThucPham( maHH, tenHH , donGia , soLuongTonKho , ngayNK , ngayHH );
				themHangHoaTrucTiep(x);
                break;
            }
			case 2 : {
				//HÀNG SÀNH SỨ
				System.out.println("\n\n\tNHAP THONG TIN HANG SANH SU NHAP KHO"); 
                System.out.print("Nhap ma hang hoa : ");
				input.nextLine();
				String maHH = input.nextLine();
				System.out.print("Nhap ten hang hoa (khong dau) : ");
				String tenHH = input.nextLine();
				System.out.print("Nhap so luong ton kho : ");
				int soLuongTonKho = input.nextInt();
				System.out.print("Nhap don gia (vnd) : ");
				int donGia = input.nextInt();				
				System.out.print("Nhap ngay nhap kho (dd/mm/yyyy) : ");
                input.nextLine();
				String ngayNK = input.nextLine();
                System.out.print("Nhap nha cung cap : ");
                String nhaCC = input.nextLine();
				x = new HangSanhSu(maHH, tenHH, donGia , soLuongTonKho , ngayNK , nhaCC);
                themHangHoaTrucTiep(x);
                break;
			}
			case 3 : {
				//HÀNG ĐIỆN TỬ
				System.out.println("\n\n\tNHAP THONG TIN HANG DIEN TU NHAP KHO");
                System.out.print("Nhap ma hang hoa : ");
				input.nextLine();
				String maHH = input.nextLine();
				System.out.print("Nhap ten hang hoa (khong dau) : ");
				String tenHH = input.nextLine();
				System.out.print("Nhap so luong ton kho : ");
				int soLuongTonKho = input.nextInt();
				System.out.print("Nhap don gia (vnd) : ");
				int donGia = input.nextInt();				
				System.out.print("Nhap ngay nhap kho (dd/mm/yyyy) : ");
                input.nextLine();
				String ngayNK = input.nextLine();
                System.out.print("Nhap cong suat thiet bi : ");
                int congSuat =input.nextInt();
				x = new HangDienMay(maHH, tenHH , donGia , soLuongTonKho,ngayNK, congSuat) ;
				themHangHoaTrucTiep(x);
                break;
			}
			default : break;
        } 
	}
    //CHỨC NĂNG SỬA HÀNG HÓA THÔNG QUA MÃ HÀ HÓA 
    public void suaHangHoa() throws ParseException{
        String maHang ;
        int count = 0;
        input.nextLine();//bắt dấu cách thừa nếu có
        System.out.print("Nhap ma hang hoa cua hang can sua (Ma Hang Hoa : 'LoaiHang-soMaHang' vd HDM-123) : ");
        maHang = input.nextLine();
        for(int i = 0 ; i< list.size();i++){
            HangHoa x = list.get(i);
            if(x.getMaHang().equals(maHang)){
                if(x instanceof HangThucPham){
                    String[] maHH = maHang.split("-",2);
                    System.out.println("\n\n\tNHAP THONG TIN HANG THUC PHAM CAN SUA");
                    System.out.print("Nhap ten hang hoa (khong dau) : ");
                    String tenHH = input.nextLine();
                    System.out.print("Nhap so luong ton kho : ");
                    int soLuongTonKho = input.nextInt();
                    System.out.print("Nhap don gia (vnd) : ");
                    int donGia = input.nextInt();				
                    System.out.print("Nhap ngay nhap kho (dd/mm/yyyy) : ");
                    input.nextLine();
                    String ngayNK = input.nextLine();
                    System.out.print("Nhap ngay het han (dd/mm/yyyy) : ");
                    String ngayHH = input.nextLine();
                    HangHoa a = new HangThucPham( maHH[1], tenHH , donGia , soLuongTonKho , ngayNK , ngayHH );
                    list.add(list.indexOf(x),a);
                    list.remove(x);
                }
                else if(x instanceof HangSanhSu){
                    String[] maHH = maHang.split("-",2);
                    System.out.println("\n\n\tNHAP THONG TIN HANG SANH SU CAN SUA"); 
                    System.out.print("Nhap ten hang hoa(khong dau) : ");
                    String tenHH = input.nextLine();
                    System.out.print("Nhap so luong ton kho : ");
                    int soLuongTonKho = input.nextInt();
                    System.out.print("Nhap don gia (vnd) : ");
                    int donGia = input.nextInt();				
                    System.out.print("Nhap ngay nhap kho (dd/mm/yyyy) : ");
                    input.nextLine();
                    String ngayNK = input.nextLine();
                    System.out.print("Nhap nha cung cap : ");
                    String nhaCC = input.nextLine();
                    HangHoa a = new HangSanhSu(maHH[1], tenHH, donGia , soLuongTonKho , ngayNK , nhaCC);
                    list.add(list.indexOf(x),a);
                    list.remove(x);
                }
                else if(x instanceof HangDienMay){
                    //HÀNG ĐIỆN TỬ
                    String[] maHH = maHang.split("-",2);
                    System.out.println("\n\n\tNHAP THONG TIN HANG DIEN TU CAN SUA");
                    System.out.print("Nhap ten hang hoa(khong dau) : ");
                    String tenHH = input.nextLine();
                    System.out.print("Nhap so luong ton kho : ");
                    int soLuongTonKho = input.nextInt();
                    System.out.print("Nhap don gia (vnd) : ");
                    int donGia = input.nextInt();				
                    System.out.print("Nhap ngay nhap kho (dd/mm/yyyy) : ");
                    input.nextLine();
                    String ngayNK = input.nextLine();
                    System.out.print("Nhap cong suat thiet bi : ");
                    int congSuat =input.nextInt();
                    HangHoa a = new HangDienMay(maHH[1], tenHH , donGia , soLuongTonKho,ngayNK, congSuat) ;
                    list.add(list.indexOf(x),a);
                    list.remove(x);
                }
            }
            else count++;
        }
        if(count == list.size()){
            System.out.println("Khong co ma hang " + maHang + " trong danh sach !!! Enter de nhap lai !!!");
            suaHangHoa();
        }


    }
    //CHỨC NĂNG XÓA HÀNG HÓA THEO MÃ HÀNG
    public void xoaHangHoa(){
        int count = 0;
        input.nextLine();
        System.out.print("Nhap ma hang hoa can xoa (Ma Hang Hoa : 'LoaiHang-soMaHang' vd HDM-123) : ");
		String maHH = input.nextLine();
		for(int i = 0 ; i <list.size() ; i++){
            HangHoa x = list.get(i);
            if(x.getMaHang().equals(maHH)){
                list.remove(x);
                System.out.println("Da xoa hang hoa co ma " + maHH + " khoi danh sach !!!");
            }
            else count++;
        }
        if(count == list.size()){
            System.out.println("Khong co ma hang " + maHH + " trong danh sach !!! Enter de nhap lai !!!");
            xoaHangHoa();
        }
    }
    //CÁC KIỂU XUẤT HÀNG HÓA
    public void xuatHangThucPham(){
        System.out.println("HANG THUC PHAM");
		for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof HangThucPham){
                System.out.println(hangHoa);
            }
        }
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();

    }
    public void xuatHangSanhSu(){
        System.out.println("HANG SANH SU");
		for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay Nhap Kho","Xuat xu","Tong gia tri");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof HangSanhSu){
                System.out.println(hangHoa);
            }
        }
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatHangDienMay(){
        System.out.println("HANG DIEN MAY");
		for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay Nhap Kho","Cong suat","Tong gia tri");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : list) {
            if(hangHoa instanceof HangDienMay){
                System.out.println(hangHoa);
            }
        }
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatHangThucPhamTrucTiep(HangHoa x){
		for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        System.out.println(x);
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();

    }
    public void xuatHangSanhSuTrucTiep(HangHoa x){
		for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay Nhap Kho","Xuat xu","Tong gia tri");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        System.out.println(x);
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatHangDienMayTrucTiep(HangHoa x){
		for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay Nhap Kho","Cong suat","Tong gia tri");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        System.out.println(x);
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatHangThucPhamTheoDanhSach(ArrayList<HangHoa> l){
        System.out.println("\t\t\t\t\t\t\t\tHANG THUC PHAM");
		for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay Nhap Kho","Ngay het han","Tong gia tri");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();

    }
    public void xuatHangSanhSuTheoDanhSach(ArrayList<HangHoa> l){
        System.out.println("\t\t\t\t\t\t\t\tHANG SANH SU");
		for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay Nhap Kho","Xuat xu","Tong gia tri");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();

    }
    public void xuatHangDienMayTheoDanhSach(ArrayList<HangHoa> l){
        System.out.println("\t\t\t\t\t\t\t\tHANG DIEN MAY");
		for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-8s|%-25s|%-25s|%-23s|%-20s|%-20s|%-20s|\n","Ma Hang","Ten Hang Hoa","So Luong ton Kho","Gia Nhap Kho","Ngay Nhap Kho","Cong suat","Tong gia tri");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
        for (HangHoa hangHoa : l) {
            System.out.println(hangHoa);
        }
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
        System.out.println();
    }
    public void xuatTatCa(){
        for(int i = 0 ; i < list.size() ; i++){
           HangHoa x = list.get(i);
            if(x instanceof HangThucPham){
                xuatHangThucPhamTrucTiep(x);
            }
            else if(x instanceof HangSanhSu){
                xuatHangSanhSuTrucTiep(x);
            }
            else if(x instanceof HangDienMay){
                xuatHangDienMayTrucTiep(x);
            }
        }
    }
    //CÁC CHỨC NĂNG SẮP XẾP TĂNG DẦN GIẢM DẦN
    
    public void sapXepHangHoaTangDanTheoGia(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }
    public void sapXepHangHoaTangDanTheoNgay(){
        Collections.sort(list,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().after(o2.getNgayNhapKho())){
                    return 1 ;
                }
                else {
                    if(o1.getNgayNhapKho().equals(o2.getNgayNhapKho())){
                        return 0 ;
                    }
                    else {
                        return -1 ;
                    }
                }
            }
        });
        xuatTatCa();
    }
   
    public void SapXepTangDanTheoLoaiVaTheoNgayNhap(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof HangThucPham){
                list1.add(x);
            }
            else if(x instanceof HangSanhSu){
                list2.add(x);
            }
            else if(x instanceof HangDienMay){
                list3.add(x);
            }
        }
        Collections.sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatHangThucPhamTheoDanhSach(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatHangSanhSuTheoDanhSach(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) < 0){
                    return -1 ;
                }
                else {
                    if(o1.getNgayNhapKho().compareTo(o2.getNgayNhapKho()) == 0){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatHangDienMayTheoDanhSach(list3);
    }
    
    public void SapXepTangDanTheoLoaiVaTheoGia(){
        ArrayList<HangHoa> list1 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list2 = new ArrayList<HangHoa>();
        ArrayList<HangHoa> list3 = new ArrayList<HangHoa>();
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof HangThucPham){
                list1.add(x);
            }
            else if(x instanceof HangSanhSu){
                list2.add(x);
            }
            else if(x instanceof HangDienMay){
                list3.add(x);
            }
        }
        sort(list1,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatHangThucPhamTheoDanhSach(list1);
        Collections.sort(list2,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatHangSanhSuTheoDanhSach(list2);
        Collections.sort(list3,new Comparator<HangHoa>(){
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getGiaNhap() < o2.getGiaNhap()){
                    return -1 ;
                }
                else {
                    if(o1.getGiaNhap() == o2.getGiaNhap()){
                        return 0 ;
                    }
                    else {
                        return 1 ;
                    }
                }
            }
        });
        xuatHangDienMayTheoDanhSach(list3);
    }
   //Chức năng tìm kiếm
   public void timKiemTheoLoai(){ 
    int luaChon = 0;
    System.out.println("=========================");
    System.out.println("| 1. Hang thuc pham     |");
    System.out.println("| 2. Hang sanh su       |");
    System.out.println("| 3. Hang dien may      |");
    System.out.println("=========================");
    System.out.print("Nhap lua chon cua ban : ");
    luaChon = input.nextInt();
    switch(luaChon){
        case 1 :{System.out.println("CAC LOAI HANG THUC PHAM LA :");
                 xuatHangThucPham();
                 break;
                }
        case 2 :{System.out.println("CAC LOAI HANG SANH SU LA : ");
                 xuatHangSanhSu();
                 break;
                }
        case 3 :{System.out.println("CAC LOAI HANG ĐIEN MAY LA :");
                 xuatHangDienMay();
                 break;
                }
    }
}
    public static Date chuyenChuoiSangNgay(String chuoiNgay) throws ParseException{
        //ngày việt nam
        Date date;
        /**
         * dd: ngày
         * mm: tháng
         * yyyy: năm
         */
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        date = simpleDateFormat.parse(chuoiNgay);
        return date;
    }
    
    DecimalFormat ft = new DecimalFormat("###,###,### VND");
    public void thongKeTongHangHoa(){
        long tongSoLuong = 0 ,tongChiPhi = 0;
        for (HangHoa hangHoa : list) {
            tongSoLuong += hangHoa.getSoLuongTonKho();
            tongChiPhi += hangHoa.tinhTien();
        }
		SapXepTangDanTheoLoaiVaTheoGia();
        System.out.println("\t\t\t\t\t\t\t\tBANG THONG KE");
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-34s|%-112d|\n","Tong so luong",tongSoLuong);
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();
        System.out.printf("|%-34s|%-25s%-67s%-20s|\n","Tong chi phi"," "," ",ft.format(tongChiPhi));
        for (int i =0; i< 149; i++) {
			System.out.print("-");
		}
		System.out.println();

    }
    public void thongKeTheoLoaiHangHoa(){
        long tongGiaTriHTP = 0;
        long tongGiaTriHSS = 0;
        long tongGiaTriHDM = 0;
        long tongSoLuongHTP = 0;
        long tongSoLuongHSS = 0;
        long tongSoLuongHDM = 0;
        for(int i = 0 ; i < list.size() ; i++){
            HangHoa x = list.get(i);
            if(x instanceof HangThucPham){
                tongGiaTriHTP+=x.tinhTien();
                tongSoLuongHTP+=x.getSoLuongTonKho();
            }
            else if(x instanceof HangSanhSu){
                tongGiaTriHSS+=x.tinhTien();
                tongSoLuongHSS+=x.getSoLuongTonKho();
            }
            else if(x instanceof HangDienMay){
                tongGiaTriHDM+= x.tinhTien();
                tongSoLuongHDM+=x.getSoLuongTonKho();
            }
        }
        System.out.println("=============MENU=============");
        System.out.println("| 1.Hang thuc pham           |");
        System.out.println("| 2.Hang sanh su             |");
        System.out.println("| 3.Hang dien may            |");
		System.out.println("| 0.Quay lai                 |");
        System.out.println("=============MENU=============");
        System.out.print("Nhap lua chon loai hang hoa : ");
    	int luaChon = input.nextInt();
        switch(luaChon){
            case 1 : {
                xuatHangThucPham();
                for (int i =0; i< 149; i++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.printf("|%-34s|%-112d|\n","Tong so luong",tongSoLuongHTP);
                for (int i =0; i< 149; i++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.printf("|%-34s|%-25s%-67s%-20s|\n","Tong chi phi"," "," ",ft.format(tongGiaTriHTP));
                for (int i =0; i< 149; i++) {
                    System.out.print("-");
                }
                System.out.println();
                break;
            }
            case 2 : {
                xuatHangSanhSu();
                for (int i =0; i< 149; i++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.printf("|%-34s|%-112d|\n","Tong so luong",tongSoLuongHSS);
                for (int i =0; i< 149; i++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.printf("|%-34s|%-25s%-67s%-20s|\n","Tong chi phi"," "," ",ft.format(tongGiaTriHSS));
                for (int i =0; i< 149; i++) {
                    System.out.print("-");
                }
                System.out.println();
                break;
            }
            case 3 : {
                xuatHangDienMay();
                for (int i =0; i< 149; i++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.printf("|%-34s|%-112d|\n","Tong so luong",tongSoLuongHDM);
                for (int i =0; i< 149; i++) {
                    System.out.print("-");
                }
                System.out.println();
                System.out.printf("|%-34s|%-25s%-67s%-20s|\n","Tong chi phi"," "," ",ft.format(tongGiaTriHDM));
                for (int i =0; i< 149; i++) {
                    System.out.print("-");
                }
                System.out.println();
                break;

            }
        }
    }
}
