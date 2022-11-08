package com.example.bt10_ketnoifirebase;

public class SinhVienModel {
    String ten,masv,quequan;
    SinhVienModel(){

    }
    public SinhVienModel(String ten, String masv, String quequan) {
        this.ten = ten;
        this.masv = masv;
        this.quequan = quequan;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMasv() {
        return masv;
    }

    public void setMasv(String masv) {
        this.masv = masv;
    }

    public String getQuequan() {
        return quequan;
    }

    public void setQuequan(String quequan) {
        this.quequan = quequan;
    }
}
