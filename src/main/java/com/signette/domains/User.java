package com.signette.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYEE database table.
 * 
 */
@Entity
@Table(name = "USEREntity")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "USER_SEQ")
	@SequenceGenerator(name = "USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
	@Column(name = "USER_ID", nullable = false)
	private long userId;

	@Column(name="USER_DATE_OF_BIRTH")
	private Date userDateOfBirth;

	@Column(name="USER_ENTRY_DATE")
	private Date userEntryDate;

	@Column(name="USER_LASTNAME")
	private String userLastname;

	@Column(name="USER_MAIL")
	private String userMail;

	@Column(name="NAME_USER")
	private String nameUser;

	@Column(name="USER_NSS")
	private long userNss;

	@Column(name="USER_PASSWORD")
	private String userPassword;

	@Column(name="USER_PHONE")
	private String userPhone;

	@Column(name="USER_USERNAME")
	private String userUsername;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="user")
	private List<Document> documents;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="ADDRESS_ID", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="ROLE_ID", nullable=false)
	private Role role;

	//bi-directional many-to-many association to Trip
	@ManyToMany
	@JoinTable(
			name="POST"
			, joinColumns={
			@JoinColumn(name="USER_ID", nullable=false)
	}
			, inverseJoinColumns={
			@JoinColumn(name="TRIP_ID", nullable=false)
	}
	)
	private List<Trip> trips;

	public User() {}

	public User(Date userDateOfBirth, Date userEntryDate, String userLastname, String userMail, String nameUser, long userNss, String userPassword, String userPhone, String userUsername) {
		this.userDateOfBirth = userDateOfBirth;
		this.userEntryDate = userEntryDate;
		this.userLastname = userLastname;
		this.userMail = userMail;
		this.nameUser = nameUser;
		this.userNss = userNss;
		this.userPassword = userPassword;
		this.userPhone = userPhone;
		this.userUsername = userUsername;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public long getUserNss() {
		return userNss;
	}

	public void setUserNss(long userNss) {
		this.userNss = userNss;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

}