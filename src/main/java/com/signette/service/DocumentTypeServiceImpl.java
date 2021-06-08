package com.signette.service;

import com.signette.domains.DocumentTypeEntity;
import com.signette.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public void add(DocumentTypeEntity documentType) {
        documentTypeRepository.save(documentType);
    }

    @Override
    public void delete(DocumentTypeEntity documentTypeEntity) {
        documentTypeRepository.delete(documentTypeEntity);
    }

    @Override
    public void update(DocumentTypeEntity documentTypeEntity) {
        documentTypeRepository.save(documentTypeEntity);
    }

    @Override
    public List<DocumentTypeEntity> findAll() {
        return documentTypeRepository.findAll();
    }

    @Override
    public DocumentTypeEntity findById(int id) {
        return documentTypeRepository.findById(id).get();
    }
}
