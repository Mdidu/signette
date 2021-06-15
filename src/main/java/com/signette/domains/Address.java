package com.signette.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ADDRESS database table.
 * 
 */
@Entity
@Table(name="ADDRESS")
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ADRESSE_SEQ")
	@SequenceGenerator(name = "ADRESSE_SEQ", sequenceName = "ADRESSE_SEQ", allocationSize = 1)
	@Column(name="ADDRESS_ID", unique=true, nullable=false, precision=38)
	private long addressId;

	@Column(name="ADDRESS_CITY", length=20)
	private String addressCity;

	@Column(name="ADDRESS_COUNTRY", length=20)
	private String addressCountry;

	@Column(name="ADDRESS_NUMBER", precision=38)
	private long addressNumber;

	@Column(name="ADDRESS_STREET", length=50)
	private String addressStreet;

	//bi-directional one-to-one association to Center
	@OneToOne(mappedBy="address",fetch = FetchType.LAZY)
	@JsonIgnore
	private Center center;

	//bi-directional one-to-one association to Client
	@OneToOne(mappedBy="address", fetch = FetchType.LAZY)
	@JsonIgnore
	private Client client;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="address", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<User> users;

	public Address() {
	}

	public long getAddressId() {
		return this.addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getAddressCity() {
		return this.addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public String getAddressCountry() {
		return this.addressCountry;
	}

	public void setAddressCountry(String addressCountry) {
		this.addressCountry = addressCountry;
	}

	public long getAddressNumber() {
		return this.addressNumber;
	}

	public void setAddressNumber(long addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getAddressStreet() {
		return this.addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setAddress(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setAddress(null);

		return user;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

}
