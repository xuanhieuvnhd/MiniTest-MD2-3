package menu;

import main.Main;
import sinhvien.QuanLySinhVien;
import taikhoan.QuanLyTaiKhoan;

import java.util.Scanner;

public class MenuGiangVien {
    public static void MenuGV() {
        Scanner scanner = new Scanner(System.in);
        QuanLySinhVien SV = new QuanLySinhVien();
        QuanLyTaiKhoan TK = new QuanLyTaiKhoan();
        SV.docTaiLieu();
        TK.docTaiLieu();
        int chon = -1;
        do {
            System.out.println(" >>>>>>>>   Giang Vien  <<<<<<<");
            System.out.println("|       1. Them sinh vien moi      ");
            System.out.println("|       2. Hien thi tat ca sinh vien        ");
            System.out.println("|       3. Hien thi sinh vien theo ma so           ");
            System.out.println("|       4. Sua thong tin sinh vien theo ten          ");
            System.out.println("|       5. Sua thong tin sinh vien theo ma so       ");
            System.out.println("|       6. Xoa thong tin sinh vien theo ten        ");
            System.out.println("|       7. Xoa thong tin sinh theo ma so         ");
            System.out.println("|       8. Tim sinh vien theo ten         ");
            System.out.println("|       9. Tim sinh vien theo ma so         ");
            System.out.println("|       10.  Sap xep sinh vien theo ma so (tang dan)        ");
            System.out.println("|       11.  Sap xep sinh vien theo diemTB (tang dan)        ");
            System.out.println("|       12.  Hien thi tat ca cac tai khoan hien co        ");
            System.out.println("|       13.  Xoa tai khoan theo ten        ");
            System.out.println("|       0. Dang xuat                              ");
            System.out.println(" ----------------------------------------------");
            System.out.print("   ------> Vui long chon chuc nang: ");
            try {
                chon = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Chuc nang khong ton tai ! vui long chon lai: ");
            }

            switch (chon) {
                case 1 -> SV.themSinhVien(scanner);
                case 2 -> SV.hienTatCaSinhVien();
                case 3 -> SV.hienSinhVienById(scanner);
                case 4 -> SV.suaSinhVienByName(scanner);
                case 5 -> SV.suaSinhVienById(scanner);
                case 6 -> SV.xoaSinhVienByNam(scanner);
                case 7 -> SV.xoaSinhVienById(scanner);
                case 8 -> SV.timSinhVienByName(scanner);
                case 9 -> SV.timSinhVienById(scanner);
                case 10 -> SV.sapXepById();
                case 11 -> SV.sapXepByDTB();
                case 12 -> TK.hienTaiKhoan();
                case 13 -> TK.xoaTaiKhoan(scanner);
                case 0 -> Main.MenuMain();
            }
        }
        while (chon != 0);
    }
}
