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
    private AdresseEntity adresseByCenterFkAddressId;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CENTER_SEQ")
    @SequenceGenerator(name = "CENTER_SEQ", sequenceName = "CENTER_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "center_id", nullable = false)
    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    @Basic
    @Column(name = "center_picture", nullable = true, length = 100)
    public String getCenterPicture() {
        return centerPicture;
    }

    public void setCenterPicture(String centerPicture) {
        this.centerPicture = centerPicture;
    }

    @Basic
    @Column(name = "center_name", nullable = false, length = 20)
    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    @Basic
    @Column(name = "center_mail", nullable = false, length = 20)
    public String getCenterMail() {
        return centerMail;
    }

    public void setCenterMail(String centerMail) {
        this.centerMail = centerMail;
    }

    @Basic
    @Column(name = "center_phone", nullable = true, length = 14)
    public String getCenterPhone() {
        return centerPhone;
    }

    public void setCenterPhone(String centerPhone) {
        this.centerPhone = centerPhone;
    }

    @Basic
    @Column(name = "center_comment", nullable = true, length = -1)
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

    @ManyToOne
    @JoinColumn(name = "center_fk_address_id", referencedColumnName = "address_id", nullable = false)
    public AdresseEntity getAdresseByCenterFkAddressId() {
        return adresseByCenterFkAddressId;
    }

    public void setAdresseByCenterFkAddressId(AdresseEntity adresseByCenterFkAddressId) {
        this.adresseByCenterFkAddressId = adresseByCenterFkAddressId;
    }
}
