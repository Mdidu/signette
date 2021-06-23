package com.signette.domains;

import java.math.BigInteger;
import java.util.Date;

public class PostUser {
    private BigInteger tripId;
    private BigInteger userId;
    private String postName;
    private String centerName;
    private String clientWording;
    private Date tripEndDate;

    public PostUser(BigInteger tripId, BigInteger userId, String postName, String centerName, String clientWording, Date tripEndDate) {
        this.tripId = tripId;
        this.userId = userId;
        this.postName = postName;
        this.centerName = centerName;
        this.clientWording = clientWording;
        this.tripEndDate = tripEndDate;
    }

    public BigInteger getTripId() {
        return tripId;
    }

    public void setTripId(BigInteger tripId) {
        this.tripId = tripId;
    }

    public BigInteger getUserId() {
        return userId;
    }

    public void setUserId(BigInteger userId) {
        this.userId = userId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public String getClientWording() {
        return clientWording;
    }

    public void setClientWording(String clientWording) {
        this.clientWording = clientWording;
    }

    public Date getTripEndDate() {
        return tripEndDate;
    }

    public void setTripEndDate(Date tripEndDate) {
        this.tripEndDate = tripEndDate;
    }
}
