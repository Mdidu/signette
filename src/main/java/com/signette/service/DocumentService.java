package com.signette.service;

import com.signette.domains.Document;

import java.util.List;

public interface DocumentService extends GlobalService<Document> {
    List<Document> findDocumentByUser(long id);
    List<Document> findDocumentByTrip(long id);
}
