package menu;

import main.Main;
import sinhvien.QuanLySinhVien;
import taikhoan.QuanLyTaiKhoan;

import java.util.Scanner;

public class MenuSinhVien {
    public static void MenuSinhVien() {
        Scanner scanner = new Scanner(System.in);
        QuanLySinhVien SV = new QuanLySinhVien();
        QuanLyTaiKhoan TK = new QuanLyTaiKhoan();
        TK.docTaiLieu();
        SV.docTaiLieu();
        int chon = -1;
        do {
            System.out.println(" >>>>>>>>   Sinh Vien  <<<<<<<");
            System.out.println("|       1. Hien thi thong tin Sinh Vien      ");
            System.out.println("|       2. Tim Sinh Vien theo ma so        ");
            System.out.println("|       3. Tim Sinh Vien theo ten            ");
            System.out.println("|       4. Sap Sinh Vien theo ma so (tang dan)         ");
            System.out.println("|       5. Sap Sinh Vien theo diem TB (tang dan)         ");
            System.out.println("|       6. Tim kiem Sinh Vien co diem TB cao nhat         ");
            System.out.println("|       7. Doi ten tai khoan         ");
            System.out.println("|       8. Doi mat khau        ");
            System.out.println("|       0. Dang xuat                              ");
            System.out.println(" ----------------------------------------------");
            System.out.print("   ------>Vui long chon chuc nang: ");
            try {
                chon = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Chuc nang khong ton tai ! vui long chon lai: ");
            }

            switch (chon) {
                case 1 -> SV.hienTatCaSinhVien();
                case 2 -> SV.timSinhVienById(scanner);
                case 3 -> SV.timSinhVienByName(scanner);
                case 4 -> SV.sapXepById();
                case 5 -> SV.sapXepByDTB();
                case 6 -> SV.timSinhVienMax();
                case 7 -> TK.doiTenDangNhap (scanner);
                case 8 -> TK.doiMatKhau(scanner);
                case 0 -> Main.MenuMain();
            }
        }
        while (chon != 0);
    }
}
