package com.htngu.bt200316;

import androidx.annotation.NonNull;

public class SinhVien {
    private int id;
    private String name, birth, sex;
    private boolean checkSport, checkTravel, checkReadBook;

    public SinhVien(int id, String name, String birth, String sex, boolean checkSport, boolean checkTravel, boolean checkReadBook) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.checkSport = checkSport;
        this.checkTravel = checkTravel;
        this.checkReadBook = checkReadBook;
    }

    public SinhVien(@NonNull String name,@NonNull String birth,@NonNull String sex,@NonNull boolean checkSport,@NonNull boolean checkTravel,@NonNull boolean checkReadBook) {
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.checkSport = checkSport;
        this.checkTravel = checkTravel;
        this.checkReadBook = checkReadBook;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public boolean isCheckSport() {
        return checkSport;
    }

    public void setCheckSport(boolean checkSport) {
        this.checkSport = checkSport;
    }

    public boolean isCheckTravel() {
        return checkTravel;
    }

    public void setCheckTravel(boolean checkTravel) {
        this.checkTravel = checkTravel;
    }

    public boolean isCheckReadBook() {
        return checkReadBook;
    }

    public void setCheckReadBook(boolean checkReadBook) {
        this.checkReadBook = checkReadBook;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", sex='" + sex + '\'' +
                ", checkSport=" + checkSport +
                ", checkTravel=" + checkTravel +
                ", checkReadBook=" + checkReadBook +
                '}';
    }
}
