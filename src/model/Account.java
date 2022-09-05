package model;

import java.io.Serializable;

public class Account implements Serializable {
    private String name, password;

    public Account() {
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "TaiKhoan{" +
                "Ten tai khoan: '" + name + '\'' +
                ", Mat khau: '" + password + '\'' +
                '}';
    }
}