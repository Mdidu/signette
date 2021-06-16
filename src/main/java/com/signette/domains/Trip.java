package com.signette.domains;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.signette.domains.Center;
import com.signette.domains.Client;
import com.signette.domains.Document;
import com.signette.domains.User;


import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the TRIP database table.
 * 
 */
@Entity
@Table(name="TRIP")
public class Trip implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "TRIP_SEQ")
	@SequenceGenerator(name = "TRIP_SEQ", sequenceName = "TRIP_SEQ", allocationSize = 1)
	@Column(name="TRIP_ID")
	private long tripId;

	@Temporal(TemporalType.DATE)
	@Column(name="TRIP_END_DATE")
	private Date tripEndDate;

	@Temporal(TemporalType.DATE)
	@Column(name="TRIP_START_DATE")
	private Date tripStartDate;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="trip")
	@JsonIgnore
	private List<Document> documents;

	//bi-directional many-to-many association to Employee
	@ManyToMany(mappedBy="trips")
	@JsonIgnore
	private List<User> users;

	//bi-directional many-to-one association to Center
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name="CENTER_ID", nullable=false)
	private Center center;

	//bi-directional many-to-one association to Client
	@ManyToOne( fetch = FetchType.EAGER)
	@JoinColumn(name="CLIENT_ID", nullable=false)
	private Client client;

	public Trip() {
	}

	public long getTripId() {
		return this.tripId;
	}

	public void setTripId(long tripId) {
		this.tripId = tripId;
	}

	public Date getTripEndDate() {
		return this.tripEndDate;
	}

	public void setTripEndDate(Date tripEndDate) {
		this.tripEndDate = tripEndDate;
	}

	public Date getTripStartDate() {
		return this.tripStartDate;
	}

	public void setTripStartDate(Date tripStartDate) {
		this.tripStartDate = tripStartDate;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
