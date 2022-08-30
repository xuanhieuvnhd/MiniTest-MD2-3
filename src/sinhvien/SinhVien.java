package sinhvien;

import java.io.Serializable;

public class SinhVien implements Serializable {
    int maso;
    String ten;
    int tuoi;
    String gioitinh;
    float diemTB;
    String diachi;
    float diemLT,diemTH;

    public SinhVien(int maso, String ten, float diemLT, float diemTH, float diemTB) {
        this.maso = maso;
        this.ten = ten;
        this.diemTB = diemTB;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    public SinhVien() {
    }

    public SinhVien(int maso, String ten, int tuoi, String gioitinh, float diemTB, String diachi) {
        this.maso = maso;
        this.ten = ten;
        this.tuoi = tuoi;
        this.gioitinh = gioitinh;
        this.diemTB = diemTB;
        this.diachi = diachi;
    }

    public int getMaso() {
        return maso;
    }

    public void setMaso(int maso) {
        this.maso = maso;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public float getDiemTB() {
        return diemTB;
    }

    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public float getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(float diemLT) {
        this.diemLT = diemLT;
    }

    public float getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(float diemTH) {
        this.diemTH = diemTH;
    }
    public float tinhDiemTB(){
        return (diemLT+diemTH)/2;
    }
    public void inDanhSach(){
        System.out.printf("%6s %10s %20s %10s %10s \n","Ma sinh vien","Ho va ten","Diem ly thuyet","Diem thuc hanh","Diem trung binh");
    }

    @Override
    public String toString() {
        return "SinhVien [" +
                "ma so: " + maso +
                ", ten: '" + ten + '\'' +
                ", tuoi: " + tuoi +
                ", gioi tinh: '" + gioitinh + '\'' +
                ", diem TB: " + diemTB +
                ", dia chi: '" + diachi + '\'' +
                ']';
    }
}
