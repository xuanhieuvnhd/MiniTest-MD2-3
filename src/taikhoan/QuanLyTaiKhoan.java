package taikhoan;

import menu.MenuGiangVien;
import menu.MenuSinhVien;
import main.Main;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class QuanLyTaiKhoan implements Serializable {
    ArrayList<TaiKhoan> taiKhoans = new ArrayList<>();
    File file = new File("TaiKhoan.txt");

    public void ghiTaiLieu(ArrayList<TaiKhoan> taiKhoans) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
            o.writeObject(taiKhoans);
            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void docTaiLieu() {
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
            taiKhoans = (ArrayList<TaiKhoan>) o.readObject();
            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public TaiKhoan taoTaiKhoan(Scanner scanner) {
        System.out.print("Ten tai khoan: ");
        Pattern p = Pattern.compile("[a-zA-Z0-9]{3,18}$");
        String ten = scanner.nextLine();
        while (p.matcher(ten).find() == false) {
            if (!p.matcher(ten).find()) {
                System.err.println("Sai quy tac tao tai khoan ! vui long nhap lai: ");
                ten = scanner.nextLine();
            }
        }
        while (checkTenDangKy(ten)) {
            ten = scanner.nextLine();
        }
        System.out.print("Nhap mat khau: ");
        String matkhau = scanner.nextLine();
        while (checkMatKhauDangKy(matkhau)) {
            matkhau = scanner.nextLine();
        }
        return new TaiKhoan(ten, matkhau);
    }

    public void themTaiKhoan(Scanner scanner) {
        TaiKhoan taiKhoan = taoTaiKhoan(scanner);
        taiKhoans.add(taiKhoan);
        System.out.println("Dang ky thanh cong , vui long chon dang nhap");
        ghiTaiLieu(taiKhoans);
        Main.MenuMain();
    }

    public boolean checkGiangVien(TaiKhoan taiKhoan) {
        if (taiKhoan.getTen().equals("adm") && taiKhoan.getMatKhau().equals("adm")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkTenDangKy(String ten) {
        String adm = "adm";
        String none1 = "";
        String none2 = " ";
        if (ten.equals(adm)) {
            System.err.print("Tai khoan da ton tai ! vui long nhap ten khac :");
            return true;
        }
        if (ten.equals(none1) || ten.startsWith(none2)) {
            System.err.print("Khong de trong ten tai khoan ! vui long nhap lai: ");
            return true;
        }

        for (int i = 0; i < taiKhoans.size(); i++) {
            if (taiKhoans.get(i).getTen().equals(ten)) {
                System.err.print("Tai khoan da ton tai, vui long nhap ten khac: ");
                return true;
            }
        }
        return false;
    }

    public boolean checkMatKhauDangKy(String matkhau) {
        String none1 = "";
        String none2 = " ";
        if (matkhau.equals(none1) || matkhau.startsWith(none2)) {
            System.err.print("Khong de trong mat khau ! vui long nhap lai: ");
            return true;
        }
        return false;
    }

    public void checkDangNhap(TaiKhoan taiKhoan) {
        boolean check = false;
        for (TaiKhoan a : taiKhoans) {
            if (taiKhoan.getTen().equals(a.getTen()) && taiKhoan.getMatKhau().equals(a.getMatKhau())) {
                check = true;
                System.out.println("Dang nhap thanh cong , vui long chon chuc nang");
                MenuSinhVien.MenuSinhVien();
            }
        }
        if (!check) {
            System.err.println("Sai ten dang nhap hoac mat khau , vui long nhap lai");
        }
    }

    public void dangNhap(Scanner scanner) {
        System.out.print("Ten dang nhap: ");
        String ten = scanner.nextLine();
        System.out.print("Mat khau dang nhap: ");
        String matkhau = scanner.nextLine();
        TaiKhoan taiKhoan = new TaiKhoan(ten, matkhau);
        if (checkGiangVien(taiKhoan)) {
            System.out.println("Dang nhap thanh cong , xin chao Giang Vien!");
            MenuGiangVien.MenuGV();
        } else {
            checkDangNhap(taiKhoan);
        }
    }

    public void hienTaiKhoan() {
        boolean check = false;
        for (TaiKhoan a : taiKhoans) {
            System.out.println(a);
            check = true;
        }
        if (!check) {
            System.err.println("Chua co tai khoan nao trong he thong, vui long chon muc dang ky");
        }
    }

    public void xoaTaiKhoan(Scanner scanner) {
        boolean check = false;
        System.out.print("Nhap ten tai khoan muon xoa: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < taiKhoans.size(); i++) {
            if (taiKhoans.get(i).getTen().equals(ten)) {
                taiKhoans.remove(i);
                check = true;
                System.out.println("Xoa tai khoan thanh cong");
                ghiTaiLieu(taiKhoans);
            }
        }
        if (!check) {
            System.err.println("Tai khoan khong ton tai !");
        }
    }
        public void doiMatKhau(Scanner scanner) {
        System.out.print("Nhap mat khau hien tai: ");
        String matkhau = scanner.nextLine();
        for (int i = 0 ; i < taiKhoans.size() ; i++){
            if (taiKhoans.get(i).getMatKhau().equals(matkhau)){
                System.out.print("Nhap mat khau moi: ");
                String matkhau1 = scanner.nextLine();
                taiKhoans.get(i).setMatKhau(matkhau1);
                System.out.println("Thay doi mat khau thanh cong !");
                ghiTaiLieu(taiKhoans);
            }
        }
    }
    public void doiTenDangNhap(Scanner scanner){
        System.out.print("Nhap ten hien tai: ");
        String ten = scanner.nextLine();
        for (int i = 0 ; i < taiKhoans.size();i++){
            if (taiKhoans.get(i).getTen().equals(ten)){
                System.out.print("Nhap ten moi: ");
                String ten1 = scanner.nextLine();
                taiKhoans.get(i).setTen(ten1);
                System.out.println("Doi ten tai khoan thanh cong !");
                ghiTaiLieu(taiKhoans);
            }
        }
    }
}

