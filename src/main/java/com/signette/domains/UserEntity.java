package com.signette.domains;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "User", schema = "public", catalog = "SIGNETTE")
public class UserEntity {
    private Date userDateOfBirth;
    private Date userEntryDate;
    private int userId;
    private String userLastname;
    private String userMail;
    private String userName;
    private int userNss;
    private String userPassword;
    private String userPhone;
    private String userUsername;
    private AdresseEntity adresseByUserFkAddressId;
    private RoleEntity roleByUserFkRoleId;

    public UserEntity() {
    }

    public UserEntity(String mail, String password) {
        this.userMail = mail;
        this.userPassword = password;
    }

    public UserEntity(Date userDateOfBirth, Date userEntryDate, String userLastname, String userMail, String userName, int userNss, String userPassword, String userPhone, String userUsername) {
        this.userDateOfBirth = userDateOfBirth;
        this.userEntryDate = userEntryDate;
        this.userLastname = userLastname;
        this.userMail = userMail;
        this.userName = userName;
        this.userNss = userNss;
        this.userPassword = userPassword;
        this.userPhone = userPhone;
        this.userUsername = userUsername;
    }

    @Basic
    @Column(name = "user_date_of_birth", nullable = false)
    public Date getUserDateOfBirth() {
        return userDateOfBirth;
    }

    public void setUserDateOfBirth(Date userDateOfBirth) {
        this.userDateOfBirth = userDateOfBirth;
    }

    @Basic
    @Column(name = "user_entry_date", nullable = false)
    public Date getUserEntryDate() {
        return userEntryDate;
    }

    public void setUserEntryDate(Date userEntryDate) {
        this.userEntryDate = userEntryDate;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "USER_SEQ")
    @SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "user_id", unique = true, nullable = false, precision = 22, scale = 0)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_lastname", nullable = false, length = 20)
    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    @Basic
    @Column(name = "user_mail", unique = true, nullable = false, length = 30)
    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    @Basic
    @Column(name = "user_name", nullable = false, length = 30)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_nss", nullable = false)
    public int getUserNss() {
        return userNss;
    }

    public void setUserNss(int userNss) {
        this.userNss = userNss;
    }

    @Basic
    @Column(name = "user_password", nullable = false, length = 100)
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Basic
    @Column(name = "user_phone", nullable = false, length = 14)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "user_username", nullable = false, length = 20)
    public String getUserUsername() {
        return userUsername;
    }

    public void setUserUsername(String userUsername) {
        this.userUsername = userUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId && userNss == that.userNss && Objects.equals(userDateOfBirth, that.userDateOfBirth) && Objects.equals(userEntryDate, that.userEntryDate) && Objects.equals(userLastname, that.userLastname) && Objects.equals(userMail, that.userMail) && Objects.equals(userName, that.userName) && Objects.equals(userPassword, that.userPassword) && Objects.equals(userPhone, that.userPhone) && Objects.equals(userUsername, that.userUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userDateOfBirth, userEntryDate, userId, userLastname, userMail, userName, userNss, userPassword, userPhone, userUsername);
    }

    @ManyToOne
    @JoinColumn(name = "user_fk_address_id", referencedColumnName = "address_id", nullable = false)
    public AdresseEntity getAdresseByUserFkAddressId() {
        return adresseByUserFkAddressId;
    }

    public void setAdresseByUserFkAddressId(AdresseEntity adresseByUserFkAddressId) {
        this.adresseByUserFkAddressId = adresseByUserFkAddressId;
    }

    @ManyToOne
    @JoinColumn(name = "user_fk_role_id", referencedColumnName = "role_id", nullable = false)
    public RoleEntity getRoleByUserFkRoleId() {
        return roleByUserFkRoleId;
    }

    public void setRoleByUserFkRoleId(RoleEntity roleByUserFkRoleId) {
        this.roleByUserFkRoleId = roleByUserFkRoleId;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userDateOfBirth=" + userDateOfBirth +
                ", userEntryDate=" + userEntryDate +
                ", userId=" + userId +
                ", userLastname='" + userLastname + '\'' +
                ", userMail='" + userMail + '\'' +
                ", userName='" + userName + '\'' +
                ", userNss=" + userNss +
                ", userPassword='" + userPassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userUsername='" + userUsername + '\'' +
                ", adresseByUserFkAddressId=" + adresseByUserFkAddressId +
                ", roleByUserFkRoleId=" + roleByUserFkRoleId +
                '}';
    }
}
