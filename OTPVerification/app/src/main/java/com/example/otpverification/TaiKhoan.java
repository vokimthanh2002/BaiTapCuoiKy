package com.example.otpverification;


public class TaiKhoan {
    private String phoneNumber;
    private String password;

    public TaiKhoan(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
    public TaiKhoan(){
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "TaiKhoan[" +"PhoneNumber: 0" +getPhoneNumber()+"      Password: "+getPassword()+
                ']';
    }
}
