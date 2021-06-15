package com.signette.service;

import com.signette.domains.DocumentType;
import com.signette.domains.Post;
import com.signette.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Autowired
    DocumentTypeRepository documentTypeRepository;

    @Override
    public void add(DocumentType documentType) {
        documentTypeRepository.save(documentType);
    }

    @Override
    public void delete(DocumentType documentTypeEntity) {
        documentTypeRepository.delete(documentTypeEntity);
    }

    @Override
    public void update(DocumentType documentTypeEntity) {
        documentTypeRepository.save(documentTypeEntity);
    }

    @Override
    public List<DocumentType> findAll() {
        return documentTypeRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return documentTypeRepository.findById(id).get();
    }
}
