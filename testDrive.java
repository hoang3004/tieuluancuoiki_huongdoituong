package oo.kiemtracuoiki;

import java.text.ParseException;
import java.util.Scanner;

public class testDrive {
    public static void main(String[] args) throws ParseException {
        int luaChon = 0;
        try (Scanner input = new Scanner(System.in)) {
            //TẠO DANH SÁCH L
            DanhSachQuanLi l = new DanhSachQuanLi();
            //TẠO ĐỐI TƯỢNG HÀNG THỰC PHẨM
            //HangHoa x = new HangThucPham(maHang, tenHangHoa, giaNhap, soLuongTonKho, ngayNhapKho, ngayHetHan) 
            HangHoa sp1 = new HangThucPham("100", "Rau Cai", 12000 ,1231, "22/11/2023","25/11/2021");
            HangHoa sp2 = new HangThucPham("101", "Ca thu", 40000 ,893, "29/12/2022","01/01/2022");
            HangHoa sp3 = new HangThucPham("102", "Thit Heo", 100000 ,562, "26/01/2021","26/02/2021");
      
            //TẠO ĐỐI TƯỢNG HÀNG SÀNH SỨ
            //HangHoa x = new HangSanhSu(maHang, tenHangHoa, giaNhap, soLuongTonKho, ngayNhapKho, xuatXu)
            HangHoa sp4 = new HangSanhSu("100", "Chen Tra", 50000, 235, "20/11/2014", "Bat Trang");
            HangHoa sp5 = new HangSanhSu("101", "Chen Com", 55000, 940, "19/11/2012", "TP HCM");
            HangHoa sp6 = new HangSanhSu("102", "Am Tra", 70000, 322, "20/02/2013", "Ha Noi");
            HangHoa sp7 = new HangSanhSu("103", "Muong Su", 45000, 446, "30/01/2011", "Nghe An");
            
            //TẠO ĐỐI TƯỢNG HÀNG ĐIỆN MÁY
            //HangHoa x = new HangDienMay(maHang, tenHangHoa, giaNhap, soLuongTonKho, ngayNhapKho, congSuat)
            HangHoa sp8 = new HangDienMay("100", "May Lanh", 10000000, 55,"20/11/2017", 500);
            HangHoa sp9 = new HangDienMay("101", "May Giat", 15000000, 46,"23/03/2016", 700);
            HangHoa sp10 = new HangDienMay("102", "May Say", 899000, 23,"17/07/2024", 250);
            
            //THÊM 10 SẢN PHẨM VÀO DANH SÁCH L SP1->SP10
            l.themHangHoaTrucTiep(sp1);
            l.themHangHoaTrucTiep(sp2);
            l.themHangHoaTrucTiep(sp3);
            l.themHangHoaTrucTiep(sp4);
            l.themHangHoaTrucTiep(sp5);
            l.themHangHoaTrucTiep(sp6);
            l.themHangHoaTrucTiep(sp7);
            l.themHangHoaTrucTiep(sp8);
            l.themHangHoaTrucTiep(sp9);
            l.themHangHoaTrucTiep(sp10);
            
            //MENU TỔNG
            while(luaChon != 6){
                System.out.println("===================MENU======================");
                System.out.println("|          1.Thao tac voi hang hoa          |");
                System.out.println("|          2.Sap xep tang dan               |");
                System.out.println("|          3.Tim kiem hang hoa               |");
                System.out.println("|          4.Thong ke                       |");
                System.out.println("|          0.Thoat chuong trinh             |");
                System.out.println("===================MENU======================\n\n\n");
                System.out.print("Nhap lua chon cua ban : ");
                luaChon = input.nextInt();
                switch(luaChon){
                    case 1 : {
                        //MENU THÊM SỬ XÓA HÀNG HÓA (CÁC THÔNG TIN ĐƯỢC NHẬP TỪ BÀN PHÍM)
                        System.out.println("==========MENU===========");
                        System.out.println("| 1. Them hang hoa     |");
                        System.out.println("| 2. Sua hang hoa      |");
                        System.out.println("| 3. Xoa hang hoa      |");
                        System.out.println("| 0.  Thoat             |");
                        System.out.println("=========================");
                        System.out.print("Nhap lua chon cua ban : ");
                        luaChon = input.nextInt();
                        input.nextLine();
                        switch(luaChon){
                            case 1 : l.themHangHoa();break;
                            case 2 : l.suaHangHoa();break;
                            case 3 : l.xoaHangHoa();break;
                            default : break;
                        }
                        break;
                    }
                    
                    case 2 : {
                        //MENU SẮP XẾP HÀNG HÓA TĂNG DẦN THEO GIÁ NHẬP , NGÀY NHẬP , THEO LOẠI VÀ NGÀY NHẬP , THEO LOẠI VÀ GIÁ NHẬP
                        System.out.println("===================MENU=======================");
                        System.out.println("| 2.Sap xep tang dan theo :                  |");
                        System.out.println("|    1. Gia nhap                            |");
                        System.out.println("|    2. Ngay nhap                           |");
                        System.out.println("|    3. Loai va ngay nhap                   |");
                        System.out.println("|    4. Loai va gia nhap                    |");
                        System.out.println("|    0.  Thoat                               |");
                        System.out.println("==============================================");
                        System.out.print("Nhap lua chon cua ban : ");
                        luaChon = input.nextInt();
                        switch(luaChon){
                            case 1 : l.sapXepHangHoaTangDanTheoGia();break;
                            case 2 : l.sapXepHangHoaTangDanTheoNgay();break;
                            case 3 : l.SapXepTangDanTheoLoaiVaTheoNgayNhap();break;
                            case 4 : l.SapXepTangDanTheoLoaiVaTheoGia();break;
                            default : break;
                        }
                        break;
                    }
                    case 3 : {
                        System.out.println("=============MENU==============");
                        System.out.println("| 1 Tim kiem theo loai        |");
                        System.out.println("| 0.  Thoat                   |");
                        System.out.println("===============================");
                        System.out.print("Nhap lua chon cua ban : ");   
                    luaChon = input.nextInt();
                    switch(luaChon){
                        case 1 : l.timKiemTheoLoai();break;
                        default : break;
                    } 
                }
                break;
                    case 4 : {
                    System.out.println("==========MENU=============");
                    System.out.println("| 1. Thong ke theo loai  |");
                    System.out.println("| 2. Thong ke tat ca     |");
                    System.out.println("| 0.  Thoat               |");
                    System.out.println("===========================");
                    System.out.print("Nhap lua chon cua ban : ");
                    luaChon = input.nextInt();
                    switch(luaChon){
                        case 1 : l.thongKeTheoLoaiHangHoa();break;
                        case 2 : l.thongKeTongHangHoa();break;
                        default : break;
                    } 
                    };break;
                    default : break; 
                    
                }
                
            }
        }
    }
}
