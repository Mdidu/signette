package com.signette.domains;

import java.io.Serializable;
import java.math.BigInteger;

/*
* Model contenant un Post et le User Equivalent
* */
public class PostByUser implements Serializable {

    private BigInteger tripId;
    private BigInteger userId;
    private BigInteger postId;
    private String postName;
    private String nameUser;
    private String userLastname;
    private String userPhone;

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

    public BigInteger getPostId() {
        return postId;
    }

    public void setPostId(BigInteger postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
