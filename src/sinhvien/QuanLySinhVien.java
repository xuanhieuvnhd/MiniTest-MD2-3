package sinhvien;

import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

public class QuanLySinhVien implements Serializable {
    ArrayList<SinhVien> sinhViens = new ArrayList<>();
    File file = new File("SinhVien.txt");
    public void ghiTaiLieu(ArrayList<SinhVien> sinhViens){
        try {
            if (!file.exists()){
                file.createNewFile();
            }
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
            o.writeObject(sinhViens);
            o.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public void docTaiLieu(){
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
            sinhViens = (ArrayList<SinhVien>) o.readObject();
            o.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public boolean checkMaso(int maso) {
        for (int i = 0; i < sinhViens.size(); i++) {
            if (sinhViens.get(i).getMaso() == maso) {
                return true;
            }
        }
        return false;
    }
    public SinhVien taoSinhVien(Scanner scanner){
        System.out.print("Ma so: ");
        int maso = Integer.parseInt(scanner.nextLine());
        while (checkMaso(maso)){
            System.err.println("Ma so da ton tai vung long nhap ma so khac:");
            maso = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Ten: ");
        String ten = scanner.nextLine();
        System.out.print("Tuoi: ");
        int tuoi = Integer.parseInt(scanner.nextLine());
        System.out.print("Gioi tinh: ");
        String gioitinh = scanner.nextLine();
        System.out.print("Diem trung binh: ");
        float diemTB = Float.parseFloat(scanner.nextLine());
        System.out.print("Dia chi: ");
        String diachi = scanner.nextLine();
        return new SinhVien(maso,ten,tuoi,gioitinh,diemTB,diachi);
    }
    public void themSinhVien(Scanner scanner){
        SinhVien sinhVien = taoSinhVien(scanner);
        sinhViens.add(sinhVien);
        System.out.println("Them sinh vien thanh cong !");
        ghiTaiLieu(sinhViens);
    }
    public void hienTatCaSinhVien(){
        boolean check = false;
        for (SinhVien a: sinhViens){
            System.out.println(a);
            check = true;
        }
        if (!check){
            System.err.println("Chua co sinh vien nao trong he thong !");
        }
    }
    public void hienSinhVienById(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ma so sinh vien can hien thi: ");
        int maso = Integer.parseInt(scanner.nextLine());
        for (SinhVien a: sinhViens){
            if (a.getMaso()==maso){
                System.out.println(a);
                check = true;
            }
        }
        if (!check){
            System.err.println("Khong ton tai sinh vien co ma so la: "+ maso);
        }
    }
    public void suaSinhVienByName(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ten sinh vien can sua: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < sinhViens.size();i++){
            if (sinhViens.get(i).getTen().equalsIgnoreCase(ten)){
               check = true;
                System.out.print("Ma so moi: ");
                int maso = Integer.parseInt(scanner.nextLine());
                System.out.print("Ten moi: ");
                String ten1= scanner.nextLine();
                System.out.print("Tuoi moi: ");
                int tuoi = Integer.parseInt(scanner.nextLine());
                System.out.print("Gioi tinh moi: ");
                String gioitinh =  scanner.nextLine();
                System.out.print("Diem trung binh moi: ");
                float diemTB = Float.parseFloat(scanner.nextLine());
                System.out.print("Dia chi moi: ");
                String diachi = scanner.nextLine();
                sinhViens.get(i).setMaso(maso);
                sinhViens.get(i).setTen(ten1);
                sinhViens.get(i).setTuoi(tuoi);
                sinhViens.get(i).setGioitinh(gioitinh);
                sinhViens.get(i).setDiemTB(diemTB);
                sinhViens.get(i).setDiachi(diachi);
                ghiTaiLieu(sinhViens);
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien !");
        }
    }
    public void suaSinhVienById(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ma so sinh vien muon sua: ");
        int maso = Integer.parseInt(scanner.nextLine());
        for (int i = 0 ; i < sinhViens.size(); i++){
            if (sinhViens.get(i).getMaso() == maso){
                check = true;
                System.out.print("Ma so moi: ");
                int maso1 = Integer.parseInt(scanner.nextLine());
                System.out.print("Ten moi: ");
                String ten1= scanner.nextLine();
                System.out.print("Tuoi moi: ");
                int tuoi = Integer.parseInt(scanner.nextLine());
                System.out.print("Gioi tinh moi: ");
                String gioitinh =  scanner.nextLine();
                System.out.print("Diem trung binh moi: ");
                float diemTB = Float.parseFloat(scanner.nextLine());
                System.out.print("Dia chi moi: ");
                String diachi = scanner.nextLine();
                sinhViens.get(i).setMaso(maso1);
                sinhViens.get(i).setTen(ten1);
                sinhViens.get(i).setTuoi(tuoi);
                sinhViens.get(i).setGioitinh(gioitinh);
                sinhViens.get(i).setDiemTB(diemTB);
                sinhViens.get(i).setDiachi(diachi);
                ghiTaiLieu(sinhViens);
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien !");
        }
    }
    public void xoaSinhVienByNam(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ten sinh vien can xoa: ");
        String ten = scanner.nextLine();
        for (int i = 0; i < sinhViens.size(); i++) {
            if (sinhViens.get(i).getTen().equalsIgnoreCase(ten)) {
                sinhViens.remove(i);
                ghiTaiLieu(sinhViens);
                check = true;
            }
        }
        if (!check) {
            System.err.println("Khong tim thay sinh vien !");
        }
    }
    public void xoaSinhVienById(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ma so sinh vien can xoa: ");
        int maso = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < sinhViens.size(); i++){
            if (sinhViens.get(i).getMaso() == maso){
                sinhViens.remove(i);
                ghiTaiLieu(sinhViens);
                check = true;
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien !");
        }
    }
    public void timSinhVienByName(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ten sinh vien can tim: ");
        String ten = scanner.nextLine();
        for (SinhVien a: sinhViens){
            if (a.getTen().contains(ten)){
                System.out.println(a);
                check = true;
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien co ten la: "+ten);
        }
    }
    public void timSinhVienById(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ma so sinh vien can tim: ");
        int maso = Integer.parseInt(scanner.nextLine());
        for (SinhVien a: sinhViens){
            if (a.getMaso() == maso){
                System.out.println(a);
                check = true;
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien co ma so la: "+maso);
        }
    }
    public void sapXepByDTB(){
        Comparator<SinhVien>comparator = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return (int) (o1.getDiemTB() - o2.getDiemTB());
            }
        };
        sinhViens.sort(comparator);
        hienTatCaSinhVien();
    }
    public void sapXepById(){
        Comparator<SinhVien>comparator = new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return (int) (o1.getMaso() - o2.getMaso());
            }
        };
        sinhViens.sort(comparator);
        hienTatCaSinhVien();
    }
    public void timSinhVienMax(){
        float max = 0;
        int sv = 0;
        for (int i = 0; i < sinhViens.size(); i++){
            if (max < sinhViens.get(i).getDiemTB()){
                max = sinhViens.get(i).getDiemTB();
                sv = i;
            }
        }
        System.out.println(sinhViens.get(sv));
    }

}
