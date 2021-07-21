package com.signette.domains;

import java.util.Date;

public class DataContratPdf {
    String nameUser;
    String  userLastname;
    String userMail;
    String userPhone;
    Date tripStartDate;
    Date tripEndDate;
    String centerName;

    public DataContratPdf() {
    }

    public DataContratPdf(String nameUser, String userLastname, String userMail, String userPhone, Date tripStartDate, Date tripEndDate, String centerName) {
        this.nameUser = nameUser;
        this.userLastname = userLastname;
        this.userMail = userMail;
        this.userPhone = userPhone;
        this.tripStartDate = tripStartDate;
        this.tripEndDate = tripEndDate;
        this.centerName = centerName;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getTripStartDate() {
        return tripStartDate;
    }

    public void setTripStartDate(Date tripStartDate) {
        this.tripStartDate = tripStartDate;
    }

    public Date getTripEndDate() {
        return tripEndDate;
    }

    public void setTripEndDate(Date tripEndDate) {
        this.tripEndDate = tripEndDate;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    @Override
    public String toString() {
        return "DataContratPdf{" +
                "nameUser='" + nameUser + '\'' +
                ", userLastname='" + userLastname + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", tripStartDate=" + tripStartDate +
                ", tripEndDate=" + tripEndDate +
                ", centerName='" + centerName + '\'' +
                '}';
    }
}
