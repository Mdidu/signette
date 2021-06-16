package com.signette.domains;

import java.io.Serializable;
import java.math.BigInteger;

public class TripByCenter implements Serializable {

    private BigInteger nbTrip;
    private String centerName;
    private String nameUser;
    private String userLasname;

    public BigInteger getNbTrip() {
        return nbTrip;
    }

    public void setNbTrip(BigInteger nbTrip) {
        this.nbTrip = nbTrip;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getUserLasname() {
        return userLasname;
    }

    public void setUserLasname(String userLasname) {
        this.userLasname = userLasname;
    }
}
