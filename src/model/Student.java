package model;

import java.io.Serializable;

public class Student implements Serializable {
    private int id;
    private String name;
    private int age;
    private String gender;
    private float mediumScore;
    private String address;
    private float theoretical, practice;

    public Student(int id, String name, float theoretical, float practice, float mediumScore) {
        this.id = id;
        this.name = name;
        this.mediumScore = mediumScore;
        this.theoretical = theoretical;
        this.practice = practice;
    }

    public Student() {
    }

    public Student(int id, String name, int age, String gender, float mediumScore, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.mediumScore = mediumScore;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(float mediumScore) {
        this.mediumScore = mediumScore;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getTheoretical() {
        return theoretical;
    }

    public void setTheoretical(float theoretical) {
        this.theoretical = theoretical;
    }

    public float getPractice() {
        return practice;
    }

    public void setPractice(float practice) {
        this.practice = practice;
    }
    public float tinhDiemTB(){
        return (theoretical + practice)/2;
    }
    public void inDanhSach(){
        System.out.printf("%6s %10s %20s %10s %10s \n","Ma sinh vien","Ho va ten","Diem ly thuyet","Diem thuc hanh","Diem trung binh");
    }

    @Override
    public String toString() {
        return "SinhVien [" +
                "ma so: " + id +
                ", ten: '" + name + '\'' +
                ", tuoi: " + age +
                ", gioi tinh: '" + gender + '\'' +
                ", diem TB: " + mediumScore +
                ", dia chi: '" + address + '\'' +
                ']';
    }
}
