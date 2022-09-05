package controller;

import model.Student;

import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

public class StudentManager implements Serializable {
    ArrayList<Student> students = new ArrayList<>();
    File file = new File("student.txt");
    public void writeData(ArrayList<Student> sinhViens){
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
    public void readData(){
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
            students = (ArrayList<Student>) o.readObject();
            o.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public boolean checkId(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }
    public Student createStudent(Scanner scanner){
        System.out.print("Ma so: ");
        int id = Integer.parseInt(scanner.nextLine());
        while (checkId(id)){
            System.err.println("Ma so da ton tai vung long nhap ma so khac:");
            id = Integer.parseInt(scanner.nextLine());
        }
        System.out.print("Ten: ");
        String name = scanner.nextLine();
        System.out.print("Tuoi: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Gioi tinh: ");
        String gender = scanner.nextLine();
        System.out.print("Diem trung binh: ");
        float mediumScore = Float.parseFloat(scanner.nextLine());
        System.out.print("Dia chi: ");
        String address = scanner.nextLine();
        return new Student(id,name,age,gender,mediumScore,address);
    }
    public void addStudent(Scanner scanner){
        Student student = createStudent(scanner);
        students.add(student);
        System.out.println("Them sinh vien thanh cong !");
        writeData(students);
    }
    public void showAllStudent(){
        boolean check = false;
        for (Student a: students){
            System.out.println(a);
            check = true;
        }
        if (!check){
            System.err.println("Chua co sinh vien nao trong he thong !");
        }
    }
    public void showStudentById(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ma so sinh vien can hien thi: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student a: students){
            if (a.getId()==id){
                System.out.println(a);
                check = true;
            }
        }
        if (!check){
            System.err.println("Khong ton tai sinh vien co ma so la: "+ id);
        }
    }
    public void editStudentByName(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ten sinh vien can sua: ");
        String name = scanner.nextLine();
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getName().equalsIgnoreCase(name)){
               check = true;
                System.out.print("Ma so moi: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Ten moi: ");
                String name1= scanner.nextLine();
                System.out.print("Tuoi moi: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Gioi tinh moi: ");
                String gender =  scanner.nextLine();
                System.out.print("Diem trung binh moi: ");
                float mediumScore = Float.parseFloat(scanner.nextLine());
                System.out.print("Dia chi moi: ");
                String address = scanner.nextLine();
                students.get(i).setId(id);
                students.get(i).setName(name1);
                students.get(i).setAge(age);
                students.get(i).setGender(gender);
                students.get(i).setMediumScore(mediumScore);
                students.get(i).setAddress(address);
                writeData(students);
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien !");
        }
    }
    public void editStudentById(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ma so sinh vien muon sua: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId() == id){
                check = true;
                System.out.print("Ma so moi: ");
                int id1 = Integer.parseInt(scanner.nextLine());
                System.out.print("Ten moi: ");
                String name1= scanner.nextLine();
                System.out.print("Tuoi moi: ");
                int age = Integer.parseInt(scanner.nextLine());
                System.out.print("Gioi tinh moi: ");
                String gender =  scanner.nextLine();
                System.out.print("Diem trung binh moi: ");
                float mediumScore = Float.parseFloat(scanner.nextLine());
                System.out.print("Dia chi moi: ");
                String address = scanner.nextLine();
                students.get(i).setId(id1);
                students.get(i).setName(name1);
                students.get(i).setAge(age);
                students.get(i).setGender(gender);
                students.get(i).setMediumScore(mediumScore);
                students.get(i).setAddress(address);
                writeData(students);
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien !");
        }
    }
    public void deleteStudentByName(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ten sinh vien can xoa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equalsIgnoreCase(name)) {
                students.remove(i);
                writeData(students);
                check = true;
            }
        }
        if (!check) {
            System.err.println("Khong tim thay sinh vien !");
        }
    }
    public void deleteStudentById(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ma so sinh vien can xoa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId() == id){
                students.remove(i);
                writeData(students);
                check = true;
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien !");
        }
    }
    public void findStudentByName(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ten sinh vien can tim: ");
        String name = scanner.nextLine();
        for (Student a: students){
            if (a.getName().contains(name)){
                System.out.println(a);
                check = true;
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien co ten la: "+name);
        }
    }
    public void findStudentById(Scanner scanner){
        boolean check = false;
        System.out.print("Nhap ma so sinh vien can tim: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Student a: students){
            if (a.getId() == id){
                System.out.println(a);
                check = true;
            }
        }
        if (!check){
            System.err.println("Khong tim thay sinh vien co ma so la: "+id);
        }
    }
    public void sortBymediumScore(){
        Comparator<Student>comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getMediumScore() - o2.getMediumScore());
            }
        };
        students.sort(comparator);
        showAllStudent();
    }
    public void sortById(){
        Comparator<Student>comparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getId() - o2.getId());
            }
        };
        students.sort(comparator);
        showAllStudent();
    }
    public void findStudentMax(){
        float max = 0;
        int student = 0;
        for (int i = 0; i < students.size(); i++){
            if (max < students.get(i).getMediumScore()){
                max = students.get(i).getMediumScore();
                student = i;
            }
        }
        System.out.println(students.get(student));
    }
}
