package com.signette.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "DocumentType", schema = "public", catalog = "SIGNETTE")
public class DocumentTypeEntity {
    private int documenttypeId;
    private String documenttypeName;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "DOCUMENT_TYPE_SEQ")
    @SequenceGenerator(name = "DOCUMENT_TYPE_SEQ", sequenceName = "DOCUMENT_TYPE_SEQ", allocationSize = 1)
    @Column(name = "documenttype_id", unique = true, nullable = false, precision = 22, scale = 0)
    public int getDocumenttypeId() {
        return documenttypeId;
    }

    public void setDocumenttypeId(int documenttypeId) {
        this.documenttypeId = documenttypeId;
    }

    @Basic
    @Column(name = "documenttype_name", nullable = true, length = 20)
    public String getDocumenttypeName() {
        return documenttypeName;
    }

    public void setDocumenttypeName(String documenttypeName) {
        this.documenttypeName = documenttypeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentTypeEntity that = (DocumentTypeEntity) o;
        return documenttypeId == that.documenttypeId && Objects.equals(documenttypeName, that.documenttypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documenttypeId, documenttypeName);
    }
}
