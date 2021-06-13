package com.signette.service;

import com.signette.domains.Document;
import com.signette.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public void add(Document document) {
        documentRepository.save(document);
    }

    @Override
    public void delete(Document document) {
        documentRepository.delete(document);
    }

    @Override
    public void update(Document document) {
        documentRepository.save(document);
    }

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document findById(long id) {
        return documentRepository.findById(id).get();
    }
}
