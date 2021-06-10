package com.signette.security.auth.payload.request;

import java.util.Date;

public class SignupRequest {

    private String mail;

    private String password;

    private Date userDateOfBirth;

    private Date userEntryDate;

    private String userLastname;

    private String userName;

    private int userNss;

    private String userPhone;

    private String userUsername;

    private int addressId;

    private int roleId;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public Date getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(Date userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    public Date getUserEntryDate() {
        return userEntryDate;
    }

    public void setUserEntryDate(Date userEntryDate) {
        this.userEntryDate = userEntryDate;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserNss() {
        return userNss;
    }

    public void setUserNss(int userNss) {
        this.userNss = userNss;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }
}
