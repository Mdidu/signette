package com.signette.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Document", schema = "public", catalog = "SIGNETTE")
public class DocumentEntity {
    private int documentId;
    private String documentName;
    private String documentLink;

    @Id
    @Column(name = "document_id", nullable = false)
    public int getDocumentId() {
        return documentId;
    }

    public void setDocumentId(int documentId) {
        this.documentId = documentId;
    }

    @Basic
    @Column(name = "document_name", nullable = false, length = 20)
    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    @Basic
    @Column(name = "document_link", nullable = false, length = 100)
    public String getDocumentLink() {
        return documentLink;
    }

    public void setDocumentLink(String documentLink) {
        this.documentLink = documentLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentEntity that = (DocumentEntity) o;
        return documentId == that.documentId && Objects.equals(documentName, that.documentName) && Objects.equals(documentLink, that.documentLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentId, documentName, documentLink);
    }
}
