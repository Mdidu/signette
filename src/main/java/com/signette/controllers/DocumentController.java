package com.signette.controllers;

import com.signette.domains.DocumentEntity;
import com.signette.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @GetMapping("/read")
    public List<DocumentEntity> read() {
        return documentService.findAll();
    }

    @GetMapping("/read/{id}")
    public DocumentEntity readById(@PathVariable int id) {
        return documentService.findById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody DocumentEntity documentEntity) {
        documentService.add(documentEntity);
    }

    @PutMapping("/update")
    public void update(@RequestBody DocumentEntity documentEntity) {
        documentService.update(documentEntity);
    }

    @DeleteMapping("/delete")
    public void delete(@PathVariable int id) {
        documentService.delete(documentService.findById(id));
    }
}
