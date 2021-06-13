package com.signette.controllers;

import com.signette.domains.DocumentType;
import com.signette.service.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/documentType")
public class DocumentTypeController {

    @Autowired
    DocumentTypeService documentTypeService;

    @GetMapping("/read")
    public List<DocumentType> read() {
        return documentTypeService.findAll();
    }

    @GetMapping("/read/{id}")
    public DocumentType readById(@PathVariable long id) {
        return documentTypeService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody DocumentType documentType) {
        documentTypeService.add(documentType);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable long id, @RequestBody DocumentType documentType) {
        documentType.setDocumenttypeId(id);
        documentTypeService.update(documentType);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        documentTypeService.delete(documentTypeService.findById(id));
    }
}
