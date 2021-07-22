package com.signette.domains;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the DOCUMENT database table.
 * 
 */
@Entity
@Table(name="DOCUMENT")
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "DOCUMENT_SEQ")
	@SequenceGenerator(name = "DOCUMENT_SEQ", sequenceName = "DOCUMENT_SEQ", allocationSize = 1)
	@Column(name="DOCUMENT_ID")
	private long documentId;
	
	@Column(name="DOCUMENT_LINK")
	private String documentLink;

	@Column(name="DOCUMENT_NAME")
	private String documentName;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;

	//bi-directional many-to-one association to Trip
	@ManyToOne
	@JoinColumn(name="TRIP_ID", referencedColumnName="TRIP_ID")
	private Trip trip;

	public Document() {
	}

	public long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	public String getDocumentLink() {
		return this.documentLink;
	}

	public void setDocumentLink(String documentLink) {
		this.documentLink = documentLink;
	}

	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

//	public DocumentType getDocumenttype() {
//		return this.documenttype;
//	}
//
//	public void setDocumenttype(DocumentType documenttype) {
//		this.documenttype = documenttype;
//	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Trip getTrip() {
		return this.trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

}