package com.signette.service;

import com.signette.domains.DocumentEntity;
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
    public void add(DocumentEntity document) {
        documentRepository.save(document);
    }

    @Override
    public void delete(DocumentEntity document) {
        documentRepository.delete(document);
    }

    @Override
    public void update(DocumentEntity document) {
        documentRepository.save(document);
    }

    @Override
    public List<DocumentEntity> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public DocumentEntity findById(int id) {
        return documentRepository.findById(id).get();
    }
}
