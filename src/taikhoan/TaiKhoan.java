package taikhoan;

import java.io.Serializable;

public class TaiKhoan implements Serializable {
    String ten,matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String ten, String matKhau) {
        this.ten = ten;
        this.matKhau = matKhau;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "ten='" + ten + '\'' +
                ", matKhau='" + matKhau + '\'' +
                '}';
    }
}