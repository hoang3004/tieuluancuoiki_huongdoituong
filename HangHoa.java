package oo.kiemtracuoiki;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class HangHoa {
    private String maHang ;
    private String tenHangHoa;
    private long giaNhap;
    private int soLuongTonKho;
    private Date ngayNhapKho;
    public HangHoa(String maHang , String tenHangHoa , long giaNhap , int soLuongTonKho , String ngayNhapKho) throws ParseException {
        this.tenHangHoa = tenHangHoa ;
        this.giaNhap = giaNhap ;
        this.soLuongTonKho = soLuongTonKho;
        this.maHang = maHang;
        this.ngayNhapKho = chuyenChuoiSangNgay(ngayNhapKho);
        
    }
    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }
    public String getMaHang() {
        return maHang;
    }
    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    } 
    public String getTenHangHoa() {
        return tenHangHoa;
    }
    public void setGiaNhap(long giaNhap) {
        this.giaNhap = giaNhap;
    }
    public long getGiaNhap() {
        return giaNhap;
    }
    public void setSoLuongTonKho(int soLuongTonKho) {
        this.soLuongTonKho = soLuongTonKho;
    }
    public int getSoLuongTonKho() {
        return soLuongTonKho;
    }
    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
    public Date getNgayNhapKho() {
        return ngayNhapKho;
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
	public static String chuyenNgaySangChuoi(Date date){
        String chuoiNgayViet = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyyy");
        chuoiNgayViet =  simpleDateFormat.format(date);
        return chuoiNgayViet;

    }
    public long tinhTien(){
        return (long)(getSoLuongTonKho()*getGiaNhap());
    }
    DecimalFormat ft = new DecimalFormat("###,###,### VND");
    public String toString() {
		String s = "";
		s+=String.format("|%-8s|%-25s|%-25s|%-23s|%-20s|", getMaHang(),getTenHangHoa(),getSoLuongTonKho(), ft.format(getGiaNhap()),chuyenNgaySangChuoi(getNgayNhapKho()));
		return s;
	}
     
}
