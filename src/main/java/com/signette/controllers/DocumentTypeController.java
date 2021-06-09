package com.signette.controllers;

import com.signette.domains.DocumentTypeEntity;
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
    public List<DocumentTypeEntity> read() {
        return documentTypeService.findAll();
    }

    @GetMapping("/read/{id}")
    public DocumentTypeEntity readById(@PathVariable int id) {
        return documentTypeService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody DocumentTypeEntity documentTypeEntity) {
        documentTypeService.add(documentTypeEntity);
    }

    @PutMapping("/update")
    public void update(@RequestBody DocumentTypeEntity documentTypeEntity) {
        documentTypeService.update(documentTypeEntity);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable int id) {
        documentTypeService.delete(documentTypeService.findById(id));
    }
}
