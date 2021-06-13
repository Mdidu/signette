package com.signette.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CLIENT database table.
 * 
 */
@Entity
@Table(name="CLIENT")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CLIENT_SEQ")
	@SequenceGenerator(name = "CLIENT_SEQ", sequenceName = "CLIENT_SEQ", allocationSize = 1)
	@Column(name="CLIENT_ID")
	private long clientId;

	@Column(name="CLIENT_MAIL")
	private String clientMail;

	@Column(name="CLIENT_PHONE")
	private String clientPhone;

	@Column(name="CLIENT_WORDING")
	private String clientWording;

	//bi-directional one-to-one association to Address
	@OneToOne
	@JoinColumn(name="ADDRESS_ID", nullable=false)
	private Address address;

	//bi-directional many-to-one association to Trip
	@OneToMany(mappedBy="client")
	private List<Trip> trips;

	public Client() {
	}

	public long getClientId() {
		return this.clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public String getClientMail() {
		return this.clientMail;
	}

	public void setClientMail(String clientMail) {
		this.clientMail = clientMail;
	}

	public String getClientPhone() {
		return this.clientPhone;
	}

	public void setClientPhone(String clientPhone) {
		this.clientPhone = clientPhone;
	}

	public String getClientWording() {
		return this.clientWording;
	}

	public void setClientWording(String clientWording) {
		this.clientWording = clientWording;
	}

	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Trip> getTrips() {
		return this.trips;
	}

	public void setTrips(List<Trip> trips) {
		this.trips = trips;
	}

	public Trip addTrip(Trip trip) {
		getTrips().add(trip);
		trip.setClient(this);

		return trip;
	}

	public Trip removeTrip(Trip trip) {
		getTrips().remove(trip);
		trip.setClient(null);

		return trip;
	}

}