package com.signette.domains;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DOCUMENTTYPE database table.
 * 
 */
@Entity
@Table(name="DOCUMENTTYPE")
public class DocumentType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "DOCUMENTTYPE_SEQ")
	@SequenceGenerator(name = "DOCUMENTTYPE_SEQ", sequenceName = "DOCUMENTTYPE_SEQ", allocationSize = 1)
	@Column(name="DOCUMENTTYPE_ID")
	private long documenttypeId;

	@Column(name="DOCUMENTTYPE_NAME")
	private String documenttypeName;

	//bi-directional many-to-one association to Document
	@OneToMany(mappedBy="documenttype", fetch=FetchType.EAGER)
	private List<Document> documents;

	public DocumentType() {
	}

	public long getDocumenttypeId() {
		return this.documenttypeId;
	}

	public void setDocumenttypeId(long documenttypeId) {
		this.documenttypeId = documenttypeId;
	}

	public String getDocumenttypeName() {
		return this.documenttypeName;
	}

	public void setDocumenttypeName(String documenttypeName) {
		this.documenttypeName = documenttypeName;
	}

	public List<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Document addDocument(Document document) {
		getDocuments().add(document);
		document.setDocumenttype(this);

		return document;
	}

	public Document removeDocument(Document document) {
		getDocuments().remove(document);
		document.setDocumenttype(null);

		return document;
	}

}