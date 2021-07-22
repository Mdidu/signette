package com.signette.repository;

import com.signette.domains.Document;
import com.signette.domains.Trip;
import com.signette.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {

    List<Document> findDocumentByUser(User user);
    List<Document> findDocumentByTrip(Trip trip);
}
