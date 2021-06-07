package com.signette.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Center", schema = "public", catalog = "SIGNETTE")
public class CenterEntity {
    private int centerId;
    private String centerPicture;
    private String centerName;
    private String centerMail;
    private String centerPhone;
    private String centerComment;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CENTER_SEQ")
    @SequenceGenerator(name = "CENTER_SEQ", sequenceName = "CENTER_SEQ", allocationSize = 1)
    @Column(name = "center_id", unique = true, nullable = false, precision = 22, scale = 0)
    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    @Basic
    @Column(name = "center_picture")
    public String getCenterPicture() {
        return centerPicture;
    }

    public void setCenterPicture(String centerPicture) {
        this.centerPicture = centerPicture;
    }

    @Basic
    @Column(name = "center_name")
    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    @Basic
    @Column(name = "center_mail")
    public String getCenterMail() {
        return centerMail;
    }

    public void setCenterMail(String centerMail) {
        this.centerMail = centerMail;
    }

    @Basic
    @Column(name = "center_phone")
    public String getCenterPhone() {
        return centerPhone;
    }

    public void setCenterPhone(String centerPhone) {
        this.centerPhone = centerPhone;
    }

    @Basic
    @Column(name = "center_comment")
    public String getCenterComment() {
        return centerComment;
    }

    public void setCenterComment(String centerComment) {
        this.centerComment = centerComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CenterEntity that = (CenterEntity) o;
        return centerId == that.centerId && Objects.equals(centerPicture, that.centerPicture) && Objects.equals(centerName, that.centerName) && Objects.equals(centerMail, that.centerMail) && Objects.equals(centerPhone, that.centerPhone) && Objects.equals(centerComment, that.centerComment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centerId, centerPicture, centerName, centerMail, centerPhone, centerComment);
    }
}
