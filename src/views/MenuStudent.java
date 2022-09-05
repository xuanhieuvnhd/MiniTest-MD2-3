package views;

import controller.StudentManager;
import controller.AccountManager;

import java.util.Scanner;

public class MenuStudent {
    public static void MenuStudent() {
        Scanner scanner = new Scanner(System.in);
        StudentManager studentManager = new StudentManager();
        AccountManager accountManager = new AccountManager();
        accountManager.readData();
        studentManager.readData();
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
                case 1 -> studentManager.showAllStudent();
                case 2 -> studentManager.findStudentById(scanner);
                case 3 -> studentManager.findStudentByName(scanner);
                case 4 -> studentManager.sortById();
                case 5 -> studentManager.sortBymediumScore();
                case 6 -> studentManager.findStudentMax();
                case 7 -> accountManager.changeLoginName(scanner);
                case 8 -> accountManager.changePassword(scanner);
                case 0 -> Main.MenuMain();
            }
        }
        while (chon != 0);
    }
}
