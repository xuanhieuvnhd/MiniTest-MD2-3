package views;

import controller.StudentManager;
import controller.AccountManager;

import java.util.Scanner;

public class MenuAdmin {
    public static void MenuAdmin() {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        AccountManager accountManager = new AccountManager();
        studentManager.readData();
        accountManager.readData();
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
                case 1 -> studentManager.addStudent(scanner);
                case 2 -> studentManager.showAllStudent();
                case 3 -> studentManager.showStudentById(scanner);
                case 4 -> studentManager.editStudentByName(scanner);
                case 5 -> studentManager.editStudentById(scanner);
                case 6 -> studentManager.deleteStudentByName(scanner);
                case 7 -> studentManager.deleteStudentById(scanner);
                case 8 -> studentManager.findStudentByName(scanner);
                case 9 -> studentManager.findStudentById(scanner);
                case 10 -> studentManager.sortById();
                case 11 -> studentManager.sortBymediumScore();
                case 12 -> accountManager.showAccount();
                case 13 -> accountManager.deleteAccount(scanner);
                case 0 -> Main.MenuMain();
            }
        }
        while (chon != 0);
    }
}
